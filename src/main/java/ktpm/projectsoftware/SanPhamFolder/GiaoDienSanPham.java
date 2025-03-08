package ktpm.projectsoftware.SanPhamFolder;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiaoDienSanPham {
    @Autowired
    DichVuSanPham dvsp;
    @GetMapping("/tim_kiem_san_pham")
    public ArrayList<SanPham> timKiemSanPham(@RequestParam String tuKhoa,@RequestParam String danhMuc,@RequestParam String sao,
    @RequestParam String gia  ){
        return dvsp.timKiemSanPham(tuKhoa, danhMuc, sao, gia);
    }
    @GetMapping("/chi_tiet_san_pham")
    public SanPham chiTietSanPham(@RequestParam int id){
        return dvsp.chiTietSanPham(id);
    }
}
