package ktpm.projectsoftware.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ktpm.projectsoftware.entity.DanhMuc;
import ktpm.projectsoftware.entity.SanPham;
import ktpm.projectsoftware.repository.DanhMucRepository;
import ktpm.projectsoftware.service.DichVuDatHang;
import ktpm.projectsoftware.service.DichVuSanPham;
import ktpm.projectsoftware.service.FilesStorageServiceImpl;

@RestController
public class GiaoDienSanPham {
    @Autowired
    DichVuSanPham dvsp;
    @Autowired
    FilesStorageServiceImpl fileService;
    @Autowired
    DichVuDatHang dathang;
    @Autowired
    DanhMucRepository dmRepo;
    @GetMapping("/chi_tiet_san_pham")
    public ResponseEntity<?> chiTietSanPham(@RequestParam int id){
        try{
            return ResponseEntity.ok( dvsp.chiTietSanPham(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/Allsp")
    public ResponseEntity<?> getAll(){
        try{
            return  ResponseEntity.ok(dvsp.findAll());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/GiaTangDan")
    public ResponseEntity<?> getSpGiaTangDan(){
        try{
            return  ResponseEntity.ok(dvsp.sortByPriceAsc());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
     @GetMapping("/GiaGiamDan")
    public ResponseEntity<?> getSpGiaGiamDan(){
        try{
            return  ResponseEntity.ok(dvsp.sortByPriceDesc());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/themSanPham")
    public ResponseEntity<?> themSanPham(@ModelAttribute SanPham sp,@RequestParam String category_name,@RequestParam MultipartFile image){
        try{
            String name=fileService.generateRandomString(image.getOriginalFilename());
            fileService.save(image,name);
            sp.setSourceHinhAnh(name);
            DanhMuc dm=dmRepo.findBytenDanhMuc(category_name);
            sp.setDanhmuc(dm);
            dvsp.themSanPham(sp);
            return ResponseEntity.ok("Thêm sản phẩm thành công");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
     @PostMapping("/xoaSanPham")
    public ResponseEntity<?> ngungBayBan(@RequestParam int id){
        try{
            dvsp.ngungBayBan(id);
            return ResponseEntity.ok("Đã ngừng bày bán");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        
    }
    @PostMapping("/doanhThuSanPham")
    public ResponseEntity<?> doanhThuSanPham(@RequestParam int sanpham_id){
        return ResponseEntity.ok(dathang.doanhThuSanPham(sanpham_id));
    }
   
}
