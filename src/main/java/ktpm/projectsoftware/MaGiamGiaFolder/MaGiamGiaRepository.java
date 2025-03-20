package ktpm.projectsoftware.MaGiamGiaFolder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface MaGiamGiaRepository extends JpaRepository<MaGiamGia,Integer> {
    @Query(nativeQuery=true,value="select * from ma_giam_gia where danh_mucid=?1 and ngay_het_han>CURDATE() and so_luot_con_lai>0 order by phan_tram_giam_gia desc limit 1")
    public MaGiamGia timKiemMaGiamGia(int id);
}
