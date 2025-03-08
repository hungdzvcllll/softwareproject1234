package ktpm.projectsoftware.NguoiDungFolder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung,Integer> {
    public NguoiDung findByten(String ten);
    public NguoiDung findByTenAndMaXacNhan(String ten,String mxn);
    public NguoiDung findByTenAndDaDangKy(String ten,boolean daDangKy);
    @Modifying
    @Transactional
    @Query(nativeQuery=true,value="delete from gio_hang where nguoi_dungid=?1 and san_phamid=?2 ")
    public void xoaKhoiGioHang(int ndid,int spid);
}
