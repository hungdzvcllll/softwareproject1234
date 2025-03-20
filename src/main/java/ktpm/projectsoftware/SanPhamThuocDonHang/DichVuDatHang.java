package ktpm.projectsoftware.SanPhamThuocDonHang;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktpm.projectsoftware.DonHangFolder.DonHang;
import ktpm.projectsoftware.DonHangFolder.DonHangRepository;
import ktpm.projectsoftware.Exception.SanPhamKhongDu;
import ktpm.projectsoftware.Exception.SoLuongAm;
import ktpm.projectsoftware.MaGiamGiaFolder.MaGiamGia;
import ktpm.projectsoftware.MaGiamGiaFolder.MaGiamGiaRepository;
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
    @Autowired
    MaGiamGiaRepository mggRepo;

    public void datHang(ArrayList<SanPham> dssp, ArrayList<Integer> slsp, String so_dien_thoai, String dia_chi)
            throws Exception {
        long tong_so_tien = 0;
        NguoiDung nd = dv.timNguoiDungHienTai();
        ArrayList<SanPhamThuocDonHang> l = new ArrayList<SanPhamThuocDonHang>();
        for (int i = 0; i < dssp.size(); i++) {
            SanPham sp = spRepo.findById(dssp.get(i).getID());
            if (slsp.get(i) > sp.getSoLuongHienTai())
                throw new SanPhamKhongDu(
                        "Sản phẩm " + sp.getTenSanPham() + " chỉ còn số lượng là " + sp.getSoLuongHienTai());
            if (slsp.get(i) < 0)
                throw new SoLuongAm("Sản phẩm " + sp.getTenSanPham() + " không được có số lượng âm");
            sp.setSoLuongHienTai(sp.getSoLuongHienTai() - slsp.get(i));
            MaGiamGia mgg = mggRepo.timKiemMaGiamGia(sp.getDanhmuc().getID());
            l.add(new SanPhamThuocDonHang(new CompositeKey1(0, sp.getID()), slsp.get(i), sp.getGia(), mgg));
            if (mgg == null)
                tong_so_tien += sp.getGia() * slsp.get(i);
            else {
                mgg.setSoLuotConLai(mgg.getSoLuotConLai() - 1);
                tong_so_tien += sp.getGia() * slsp.get(i) * (1 - mgg.getPhanTramGiamGia() / 100.00);
                mggRepo.save(mgg);
            }
        }
        DonHang dh = dhRepo.save(new DonHang(0, true, false, false, tong_so_tien, nd));
        for (SanPhamThuocDonHang spdh : l) {
            CompositeKey1 ck1 = spdh.getKey();
            ck1.setDonHangID(dh.getID());
        }
        spdhRepo.saveAll(l);
    }

    public long doanhThuSanPham(int san_phamid) {
        ArrayList<SanPhamThuocDonHang> l = spdhRepo.danhSachBanHang();
        long doanhThu = 0;
        for (SanPhamThuocDonHang spdh : l) {
            if (spdh.getMagiamgia() == null)
                doanhThu += spdh.getGiaGoc() * spdh.getSoLuong();
            else
                doanhThu += spdh.getGiaGoc() * spdh.getSoLuong() * (1 - (float)spdh.getMagiamgia().getPhanTramGiamGia()/100);
        }
        return doanhThu;
    }

}