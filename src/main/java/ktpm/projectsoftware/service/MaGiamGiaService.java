package ktpm.projectsoftware.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ktpm.projectsoftware.entity.DanhMuc;
import ktpm.projectsoftware.entity.MaGiamGia;
import ktpm.projectsoftware.repository.DanhMucRepository;
import ktpm.projectsoftware.repository.MaGiamGiaRepository;

@Service
public class MaGiamGiaService {
    @Autowired
    MaGiamGiaRepository mggRepo;
    @Autowired
    DanhMucRepository dmRepo;
    public void themMa(MaGiamGia mgg,String tendm){
        DanhMuc dm=dmRepo.findBytenDanhMuc(tendm);
        mgg.setDanhmuc(dm);
        mggRepo.save(mgg);
    }
    public void huyMa(int id){
        mggRepo.huyMa(id);
    }
    public ArrayList<MaGiamGia> findAll(){
        return mggRepo.findAll();
    }
    public MaGiamGia findById(int id){
        return mggRepo.findById(id).get();
    }
}
