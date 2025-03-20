package ktpm.projectsoftware.DonHangFolder;

import java.util.ArrayList;

import org.hibernate.metamodel.model.domain.internal.DomainModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktpm.projectsoftware.NguoiDungFolder.DichVuNguoiDung;
import ktpm.projectsoftware.NguoiDungFolder.EmailSender;
import ktpm.projectsoftware.NguoiDungFolder.NguoiDung;

@Service
public class DichVuDonHang {
    @Autowired
    DichVuNguoiDung dvnd;
    @Autowired
    DonHangRepository dhRepo;
    @Autowired
    EmailSender sender;

    public ArrayList<DonHang> danhSachDonHangNguoiDung() {
        NguoiDung nd = dvnd.timNguoiDungHienTai();
        return dhRepo.timKiemBangNguoiDung(nd.getID());
    }

    public void huyDonHang(int nguoi_dungid) {
        dhRepo.huyDonHang(nguoi_dungid);
    }

    public void huyThanhToan(int don_hangid) {
        NguoiDung nd = dvnd.timNguoiDungHienTai();
        DonHang dh = dhRepo.findById(don_hangid);
        if (dh.isDaThanhToan() && !dh.isNhanHang()) {
            sender.sendEmail("hoan tien thanh cong", nd.getTen());
            dh.setDaThanhToan(false);
            dhRepo.save(dh);
        }
    }

    public Long tongDoanhThu() {
        return dhRepo.TongDoanhThu();
    }
}
