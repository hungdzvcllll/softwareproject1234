package ktpm.projectsoftware.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ktpm.projectsoftware.entity.SanPham;
import ktpm.projectsoftware.service.DichVuDatHang;

@RestController
public class GiaoDienDatHang {
    @Autowired
    DichVuDatHang dvdh;
    @PostMapping("dat_hang")
    public ResponseEntity<?> datHang(@RequestParam ArrayList<SanPham> dssp,@RequestParam ArrayList<Integer> slsp,
    @RequestParam String so_dien_thoai,@RequestParam String dia_chi)throws Exception{  
        try{      
            dvdh.datHang(dssp,slsp,so_dien_thoai,dia_chi);
            return ResponseEntity.ok("đặt hàng thành công");
        }
         catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
            
    }
}
