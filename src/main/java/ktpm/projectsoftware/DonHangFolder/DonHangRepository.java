package ktpm.projectsoftware.DonHangFolder;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
    public DonHang save(DonHang dh);
    @Query(nativeQuery=true,value="select * from don_hang where nguoi_dungid=?1")
    public ArrayList<DonHang> timKiemBangNguoiDung(int nguoi_dungid);
}
