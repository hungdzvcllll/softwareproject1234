package ktpm.projectsoftware.DonHangFolder;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import ktpm.projectsoftware.HoTroThanhToan.ajaxServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GiaoDienDonHang {
    @Autowired
    private ajaxServlet httt;
    @Autowired
    DichVuDonHang dvdh;

    @GetMapping("/huydonhang")
    public void huyDonHang(@RequestParam int don_hangid) {
        dvdh.huyDonHang(don_hangid);
    }

    @GetMapping("danhsachhientai")
    public ArrayList<DonHang> danhSachHienTai(int id) {
        return dvdh.danhSachDonHangNguoiDung();
    }

    @GetMapping("/huyThanhToan")
    public void huyThanhToan(@RequestParam int don_hangid) {
        dvdh.huyThanhToan(don_hangid);
    }
}