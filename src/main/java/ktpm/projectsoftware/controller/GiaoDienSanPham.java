package ktpm.projectsoftware.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ktpm.projectsoftware.entity.DanhMuc;
import ktpm.projectsoftware.entity.SanPham;
import ktpm.projectsoftware.repository.DanhMucRepository;
import ktpm.projectsoftware.service.DichVuSanPham;
import ktpm.projectsoftware.service.FilesStorageServiceImpl;

@RestController
public class GiaoDienSanPham {
    @Autowired
    DichVuSanPham dvsp;
    @Autowired
    FilesStorageServiceImpl fileService;
    @Autowired
    DanhMucRepository dmRepo;
    @GetMapping("/tim_kiem_san_pham")
    public ArrayList<SanPham> timKiemSanPham(@RequestParam String tuKhoa,@RequestParam String danhMuc,@RequestParam String sao,
    @RequestParam String gia  ){
        return dvsp.timKiemSanPham(tuKhoa, danhMuc, sao, gia);
    }
    @GetMapping("/chi_tiet_san_pham")
    public SanPham chiTietSanPham(@RequestParam int id){
        return dvsp.chiTietSanPham(id);
    }
    @PostMapping("/themSanPham")
    public void themSanPham(@RequestBody SanPham sp,@RequestParam String category_name,@RequestParam MultipartFile image){
        String name=fileService.generateRandomString(image.getOriginalFilename());
        fileService.save(image,name);
        sp.setSourceHinhAnh(name);
        DanhMuc dm=dmRepo.findBytenDanhMuc(category_name);
        sp.setDanhmuc(dm);
        dvsp.themSanPham(sp);
    }
     @PostMapping("/xoaSanPham")
    public void ngungBayBan(@RequestParam int id){
        dvsp.ngungBayBan(id);
    }
    
    
}
