package ktpm.projectsoftware.NguoiDungFolder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

import ktpm.projectsoftware.Exception.MaSaiHoacHetHan;
import ktpm.projectsoftware.Exception.NguoiDungDaDangKy;
import ktpm.projectsoftware.SanPhamFolder.SanPham;
import ktpm.projectsoftware.SanPhamFolder.SanPhamRepository;
import ktpm.projectsoftware.Security.MyUserDetails;

@Service
public class DichVuNguoiDung {
    @Autowired
    NguoiDungRepository repo;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    EmailSender sender;
    @Autowired
    SanPhamRepository sprepo;

    public NguoiDung timNguoiDungHienTai() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails u = (UserDetails) principal;
        String ten = u.getUsername();
        NguoiDung nd = repo.findByten(ten);
        return nd;
    }
    public String taoMa() {
        Random random = new Random();
        int number = random.nextInt(100000); // Generates 0 to 99999
        return String.format("%05d", number); // Ensures 5-digit format with leading zeros
    }

    public static boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (email == null || email.isEmpty()) {
            return false; // Empty or null emails are invalid
        }

        return Pattern.matches(EMAIL_REGEX, email);
    }

    public NguoiDung KhachHangChuaDangKy(NguoiDung nd) throws Exception {
        NguoiDung ndht = repo.findByten(nd.getTen());
        if (ndht == null) {
            String ma = taoMa();
            nd.setDaDangKy(false);
            nd.setMaXacNhan(ma);
            nd.setMatKhau(encoder.encode(nd.getMatKhau()));
            nd.setVaiTro("KhachHang");
            nd.setThoiHan(LocalDateTime.now().plusHours(1));
            if (isValidEmail(nd.getTen()))
                sender.sendEmail(ma, nd.getTen());
            return repo.save(nd);

        } else if (ndht.isDaDangKy() == false) {
            String ma = taoMa();
            ndht.setMatKhau(encoder.encode(nd.getMatKhau()));
            ndht.setMaXacNhan(ma);
            ndht.setThoiHan(LocalDateTime.now().plusHours(1));
            if (isValidEmail(ndht.getTen()))
                sender.sendEmail(ma, ndht.getTen());
            return repo.save(ndht);
        } else
            throw new NguoiDungDaDangKy("Tai khoan da co nguoi dang ky");
    }

    public NguoiDung NguoiDungDangKyThanhCong(String ten, String mxn) throws Exception {
        NguoiDung nd = repo.findByTenAndMaXacNhan(ten, mxn);
        if (nd != null && nd.isDaDangKy() == false && LocalDateTime.now().isBefore(nd.getThoiHan())) {
            nd.setDaDangKy(true);
            return repo.save(nd);
        }
        throw new MaSaiHoacHetHan("Tai khoan da dang ky,ma sai hoac het han");
    }

    public NguoiDung themSanPhamVaoGioHang(int sanphamid) {
        NguoiDung nd = timNguoiDungHienTai();
        SanPham sp = sprepo.findById(sanphamid);
        ArrayList<SanPham> l = new ArrayList<SanPham>();
        l.add(sp);
        nd.setSanpham(l);
        return repo.save(nd);

    }
    public void xoaSanPhamKhoiGioHang(int san_phamid){
        NguoiDung nd=timNguoiDungHienTai();
        repo.xoaKhoiGioHang(nd.getID(), san_phamid);
    }
}