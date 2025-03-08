package ktpm.projectsoftware.SanPhamFolder;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,Integer>{
    ArrayList<SanPham> findAll();
    SanPham findById(int id);
}
