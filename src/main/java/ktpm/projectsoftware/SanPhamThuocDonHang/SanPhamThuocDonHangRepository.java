package ktpm.projectsoftware.SanPhamThuocDonHang;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SanPhamThuocDonHangRepository extends JpaRepository<SanPhamThuocDonHang,CompositeKey1> {
   // public void saveAll(ArrayList<SanPhamThuocDonHang> l);
}
