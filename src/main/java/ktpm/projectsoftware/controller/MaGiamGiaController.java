package ktpm.projectsoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ktpm.projectsoftware.entity.MaGiamGia;
import ktpm.projectsoftware.service.MaGiamGiaService;

@RestController
public class MaGiamGiaController {
    @Autowired
    MaGiamGiaService mggService;
    @PostMapping("/themMa")
    public ResponseEntity<?> themMa(@RequestBody MaGiamGia mgg,@RequestParam String tendm){
        try{
            mggService.themMa(mgg,tendm);
            return ResponseEntity.ok("Thêm mã thành công");
        }
         catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/huyMa")
    public ResponseEntity<?> huyMa(@RequestParam int id){
        try{
            mggService.huyMa(id);
            return ResponseEntity.ok("Hủy mã thành công");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
