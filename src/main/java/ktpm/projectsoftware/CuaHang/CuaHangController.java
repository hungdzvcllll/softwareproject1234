package ktpm.projectsoftware.CuaHang;

import ktpm.projectsoftware.HoTroThanhToan.ajaxServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CuaHangController {
    @Autowired
    CuaHangService chService;
    @PostMapping("/thong_tin")
    public void capNhatThongTin(@RequestParam String thong_tin) {
        chService.capNhatThongTin(thong_tin);
    }
    @PostMapping("/chinh_sach")
     public void capNhatChinhSach(@RequestParam String chinh_sach) {
        chService.capNhatChinhSach(chinh_sach);
    }
}
