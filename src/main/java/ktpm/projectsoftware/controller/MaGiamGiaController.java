package ktpm.projectsoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void themMa(@RequestBody MaGiamGia mgg,@RequestParam String tendm){
        mggService.themMa(mgg,tendm);
    }
    @PostMapping("/huyMa")
    public void huyMa(@RequestParam int id){
        mggService.huyMa(id);
    }
}
