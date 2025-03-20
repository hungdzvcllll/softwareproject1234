package ktpm.projectsoftware.SanPhamThuocDonHang;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ktpm.projectsoftware.HoTroThanhToan.ajaxServlet;
import ktpm.projectsoftware.SanPhamFolder.SanPham;

@RestController
public class GiaoDienDatHang {
    @Autowired
    DichVuDatHang dvdh;
    @PostMapping("dat_hang")
    public void datHang(@RequestParam ArrayList<SanPham> dssp,@RequestParam ArrayList<Integer> slsp,
    @RequestParam String so_dien_thoai,@RequestParam String dia_chi)throws Exception{        
        dvdh.datHang(dssp,slsp,so_dien_thoai,dia_chi);    
    }
}
