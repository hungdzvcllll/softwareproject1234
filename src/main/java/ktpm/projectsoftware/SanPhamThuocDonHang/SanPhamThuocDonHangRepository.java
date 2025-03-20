package ktpm.projectsoftware.SanPhamThuocDonHang;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamThuocDonHangRepository extends JpaRepository<SanPhamThuocDonHang, CompositeKey1> {
   @Query(nativeQuery = true, value = "select *from san_pham_thuoc_don_hang where don_hangid in(select id from don_hang where nhan_hang=1)")
   public ArrayList<SanPhamThuocDonHang> danhSachBanHang();

   @Query(nativeQuery = true, value = "select sum(gia_tri_don_hang) from don_hang where nhan_hang=1")
   public Long TongDoanhThu();
}
