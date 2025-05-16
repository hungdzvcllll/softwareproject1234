package ktpm.projectsoftware.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import ktpm.projectsoftware.entity.DonHang;
import ktpm.projectsoftware.service.DichVuDonHang;
import ktpm.projectsoftware.service.ajaxServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GiaoDienDonHang {
    @Autowired
    private ajaxServlet httt;
    @Autowired
    DichVuDonHang dvdh;

     @PostMapping("/huydonhang")
     public ResponseEntity<?> huyDonHang(@RequestParam int don_hangid) {
        try{
            dvdh.huyDonHang(don_hangid);
            return  ResponseEntity.ok("hủy đơn thành công");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/danhsachhientai")
     public ResponseEntity<?> danhSachHienTai() {
        try{
            
            return  ResponseEntity.ok(dvdh.danhSachDonHangNguoiDung());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/huyThanhToan")
     public ResponseEntity<?> huyThanhToan(@RequestParam int don_hangid) {
        try{
            dvdh.huyThanhToan(don_hangid);
            return  ResponseEntity.ok("hủy thanh toán thành công");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
     @PostMapping("/tuChoiDonHang")
     public ResponseEntity<?> tuChoiDonHang(@RequestParam int id) {
        try{
            dvdh.tuChoiDonHang(id);
            return  ResponseEntity.ok("từ chối thành công");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/xacNhanNhanHang")
    public ResponseEntity<?> xacNhanNhanHang(@RequestParam int id){
        try{
            dvdh.xacNhanNhanHang(id);
            return    ResponseEntity.ok("xác nhận thành công");
        }
         catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
     
    }
    @GetMapping("/TongDoanhThu")
    public ResponseEntity<?> tongDoanhThu(){
        return ResponseEntity.ok(dvdh.tongDoanhThu());
    }
}