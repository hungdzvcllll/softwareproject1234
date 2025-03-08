package ktpm.projectsoftware.SanPhamThuocDonHang;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktpm.projectsoftware.DonHangFolder.DonHang;
import ktpm.projectsoftware.DonHangFolder.DonHangRepository;
import ktpm.projectsoftware.Exception.SanPhamKhongDu;
import ktpm.projectsoftware.Exception.SoLuongAm;
import ktpm.projectsoftware.NguoiDungFolder.DichVuNguoiDung;
import ktpm.projectsoftware.NguoiDungFolder.NguoiDung;
import ktpm.projectsoftware.SanPhamFolder.SanPham;
import ktpm.projectsoftware.SanPhamFolder.SanPhamRepository;

@Service
public class DichVuDatHang {
    @Autowired
    private SanPhamRepository spRepo;
    @Autowired
    private DonHangRepository dhRepo;
    @Autowired
    private DichVuNguoiDung dv;
    @Autowired
    private SanPhamThuocDonHangRepository spdhRepo;

    public void datHang(ArrayList<SanPham> dssp, ArrayList<Integer> slsp) throws Exception {
        long tong_so_tien = 0;
        NguoiDung nd = dv.timNguoiDungHienTai();
        for (int i = 0; i < dssp.size(); i++) {
            SanPham sp = spRepo.findById(dssp.get(i).getID());
            if (slsp.get(i) > sp.getSoLuongHienTai())
                throw new SanPhamKhongDu(
                        "Sản phẩm " + sp.getTenSanPham() + " chỉ còn số lượng là " + sp.getSoLuongHienTai());
            if (slsp.get(i) < 0)
                throw new SoLuongAm("Sản phẩm " + sp.getTenSanPham() + " không được có số lượng âm");
            sp.setSoLuongHienTai(sp.getSoLuongHienTai() - slsp.get(i));
            tong_so_tien += sp.getGia() * slsp.get(i);
        }
        DonHang dh = dhRepo.save(new DonHang(0, true, false, tong_so_tien, nd));
        ArrayList<SanPhamThuocDonHang> l = new ArrayList<SanPhamThuocDonHang>();
        for (int i = 0; i < dssp.size(); i++) {
            l.add(new SanPhamThuocDonHang(new CompositeKey1(dh.getID(), dssp.get(i).getID()), slsp.get(i)));
        }
        spdhRepo.saveAll(l);
    }

}