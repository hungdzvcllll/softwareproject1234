package ktpm.projectsoftware.SanPhamFolder;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import ktpm.projectsoftware.DanhGiaFolder.DanhGia;
import ktpm.projectsoftware.DanhMucFolder.DanhMuc;
import ktpm.projectsoftware.NguoiDungFolder.NguoiDung;
import ktpm.projectsoftware.SanPhamThuocDonHang.SanPhamThuocDonHang;
import lombok.Data;
import lombok.ToString;

@Data
@Entity

public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String tenSanPham;
    @Column(columnDefinition = "NVARCHAR(500)")
    private String SourceHinhAnh;
    @Column(columnDefinition = "NVARCHAR(500)")
    private String MoTa;
    private long Gia;
    private int soLuongHienTai;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "DanhMucID", nullable = false)
    private DanhMuc danhmuc;
    @ManyToMany(mappedBy = "sanpham")
    Collection<NguoiDung> nguoidung;
    @OneToMany(mappedBy = "sanpham")
    Collection<DanhGia> danhgia;
}
