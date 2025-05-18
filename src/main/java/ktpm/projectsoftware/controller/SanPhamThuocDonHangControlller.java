package ktpm.projectsoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ktpm.projectsoftware.service.SanPhamThuocDonHangService;

@RestController
public class SanPhamThuocDonHangControlller {
    @Autowired
    SanPhamThuocDonHangService service;
    @GetMapping("/AllspThuocDonHang")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/findByDonHangId")
    public ResponseEntity<?> findByDonHangId(@RequestParam int id){
        return ResponseEntity.ok(service.findByDonHangId(id));
    }
}
