package ktpm.projectsoftware.DanhGiaFolder;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ktpm.projectsoftware.HoTroHinhAnh.FilesStorageServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GiaoDienDanhGia {
    @Autowired
    FilesStorageServiceImpl fileservice;
    @Autowired
    DichVuDanhGia dvdg;

    @PostMapping("/danh_gia")
    public DanhGia luuDanhGia(@RequestParam String binh_luan, @RequestParam MultipartFile hinh_anh,
            @RequestParam int sao, @RequestParam int san_phamid) {
        if (hinh_anh != null) {
            String s = fileservice.generateRandomString(hinh_anh.getOriginalFilename());
            fileservice.save(hinh_anh,s);
            return dvdg.luuDanhGia(binh_luan, s,  sao, san_phamid);
        }
        return dvdg.luuDanhGia(binh_luan, null,  sao, san_phamid);
    }
}
