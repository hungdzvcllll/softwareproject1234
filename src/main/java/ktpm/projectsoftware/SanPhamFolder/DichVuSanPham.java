package ktpm.projectsoftware.SanPhamFolder;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ktpm.projectsoftware.DanhMucFolder.DanhMucRepository;
import ktpm.projectsoftware.DanhGiaFolder.DanhGiaRepository;
import ktpm.projectsoftware.DanhMucFolder.DanhMuc;

@Service
public class DichVuSanPham {
    @Autowired
    SanPhamRepository spRepo;
    @Autowired
    DanhMucRepository dmRepo;
    @Autowired
    DanhGiaRepository dgRepo;

    public boolean timKiem(SanPham sp, String tuKhoa, String danhMuc, String sao, String gia) {
        if (sp.getTenSanPham().toLowerCase().contains(tuKhoa.toLowerCase()) == false)
            return false;
        if (danhMuc.equals("Không") == false) {
            DanhMuc dm = dmRepo.findBytenDanhMuc(danhMuc);
            if (sp.getDanhmuc().getID() != dm.getID())
                return false;
        }
        if (sao.equals("Không") == false) {
            int i = (int) dgRepo.SaoTrungBinh(sp.getID());
            if (i != Integer.parseInt(sao))
                return false;
        }
        if (gia.equals("Không") == false) {
            if (sp.getGia() > Long.parseLong(gia))
                return false;
        }
        return true;
    }

    public ArrayList<SanPham> timKiemSanPham(String tuKhoa, String danhMuc, String sao, String gia) {
        ArrayList<SanPham> l1 = spRepo.findAll();

        ArrayList<SanPham> l2 = new ArrayList<SanPham>();
        for (SanPham sp : l1) {
            System.out.println(sp.getID() + " " + sp.getTenSanPham());
        }
        for (SanPham sp : l1) {
            if (timKiem(sp, tuKhoa, danhMuc, sao, gia))
                l2.add(sp);
        }
        return l2;
    }
    public SanPham chiTietSanPham(int id){    
        return spRepo.findById(id);
    }
}
