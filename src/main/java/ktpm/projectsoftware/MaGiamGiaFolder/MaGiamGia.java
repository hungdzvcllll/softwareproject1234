package ktpm.projectsoftware.MaGiamGiaFolder;

import java.sql.Date;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import ktpm.projectsoftware.DanhMucFolder.DanhMuc;
import ktpm.projectsoftware.SanPhamThuocDonHang.SanPhamThuocDonHang;
import lombok.Data;

@Data
@Entity
public class MaGiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(columnDefinition = "NVARCHAR(50)")
    private String Ma;
    private Date NgayHetHan;
    private int SoLuotConLai;
    private int PhanTramGiamGia;
    @ManyToOne
    @JoinColumn(name = "danh_mucid",nullable=false)
    private DanhMuc danhmuc;
    @OneToMany(mappedBy="magiamgia")
    private Collection<SanPhamThuocDonHang> sanphamthuocdonhang;
}
