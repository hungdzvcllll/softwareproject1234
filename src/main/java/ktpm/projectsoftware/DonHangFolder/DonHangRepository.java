package ktpm.projectsoftware.DonHangFolder;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
    public DonHang save(DonHang dh);
    @Query(nativeQuery=true,value="select * from don_hang where nguoi_dungid=?1")
    public ArrayList<DonHang> timKiemBangNguoiDung(int nguoi_dungid);
    @Modifying
    @Transactional
    @Query(nativeQuery=true,value="update don_hang set trang_thai_don_hang=0 where id=?1 ")
    public void huyDonHang(int id);
    public DonHang findById(int id);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value="update don_hang set da_thanh_toan=1 where id=?1" )
    public void ThanhToanThanhCong(int id);
    @Query(nativeQuery=true,value="select sum(gia_tri_don_hang) from don_hang where nhan_hang=1")
    public Long TongDoanhThu();
}
