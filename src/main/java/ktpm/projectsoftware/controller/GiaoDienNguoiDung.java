package ktpm.projectsoftware.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ktpm.projectsoftware.Exception.MaSaiHoacHetHan;
import ktpm.projectsoftware.Exception.NguoiDungDaDangKy;
import ktpm.projectsoftware.Exception.SanPhamKhongDu;
import ktpm.projectsoftware.Exception.SoLuongAm;
import ktpm.projectsoftware.entity.DonHang;
import ktpm.projectsoftware.entity.NguoiDung;
import ktpm.projectsoftware.entity.SanPham;
import ktpm.projectsoftware.repository.NguoiDungRepository;
import ktpm.projectsoftware.repository.SanPhamRepository;
import ktpm.projectsoftware.service.DichVuDatHang;
import ktpm.projectsoftware.service.DichVuDonHang;
import ktpm.projectsoftware.service.DichVuNguoiDung;

@RestController
public class GiaoDienNguoiDung {
    @Autowired
    DichVuNguoiDung dv;
    @Autowired
    SanPhamRepository spRepo;
    @Autowired
    NguoiDungRepository repo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    DichVuDatHang dvdh;
    @Autowired
    DichVuDonHang dvdonhang;
    @PostMapping("/dang_ky")
    public NguoiDung dangKy(@RequestBody NguoiDung nd) throws Exception {
        return dv.KhachHangChuaDangKy(nd);
    }

    @PostMapping("/xac_nhan_dang_ky")
    public NguoiDung xacNhan(@RequestBody NguoiDung nd) throws Exception {
        return dv.NguoiDungDangKyThanhCong(nd.getTen(), nd.getMaXacNhan());
    }

    @GetMapping("/them_vao_gio_hang")
    public NguoiDung themVaoGioHang(@RequestParam int san_phamid) {
        return dv.themSanPhamVaoGioHang(san_phamid);
    }

    @GetMapping("/xoa_khoi_gio_hang")
    public void xoa_khoi_gio_hang(@RequestParam int san_phamid) {
        dv.xoaSanPhamKhoiGioHang(san_phamid);
    }

    @GetMapping("/abc")
    public String abc() {
        return "abc";
    }
    @GetMapping("/GioHang")
    public ArrayList<SanPham> timKiemGioHang(){
        return dv.timKiemGioHang();
    }
    @ExceptionHandler(NguoiDungDaDangKy.class)
    public String daDangKy() {
        return "Nguoi Dung Da Dang Ky";
    }

    @ExceptionHandler(MaSaiHoacHetHan.class)
    public String maSai() {
        return "Ma sai hoac het han";
    }
    @ExceptionHandler(SoLuongAm.class)
    public String soluongam(Exception e){
        return e.getMessage();
    }
     @ExceptionHandler(SanPhamKhongDu.class)
    public String spkodu(Exception e){
        return e.getMessage();
    }
}
