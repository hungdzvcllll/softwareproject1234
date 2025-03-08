package ktpm.projectsoftware.DanhGiaFolder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhGiaRepository extends JpaRepository<DanhGia, Integer> {
    @Query(nativeQuery = true, value = "select avg(sao) from danh_gia where san_phamid=?1")
    public float SaoTrungBinh(int spID);

}
