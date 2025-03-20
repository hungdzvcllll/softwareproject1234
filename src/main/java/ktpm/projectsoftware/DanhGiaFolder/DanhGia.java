package ktpm.projectsoftware.DanhGiaFolder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ktpm.projectsoftware.NguoiDungFolder.NguoiDung;
import ktpm.projectsoftware.SanPhamFolder.SanPham;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DanhGia {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;
    @Column(columnDefinition = "NVARCHAR(1000)")
    private String BinhLuan;
    @Column(columnDefinition = "NVARCHAR(500)")
    private String NguonAnh;
    private int Sao;
    @ManyToOne
    @JoinColumn(name="NguoiDungID",nullable=false)
    private NguoiDung nguoidung;
    @ManyToOne
    @JoinColumn(name="SanPhamID",nullable=false)
    private SanPham sanpham;
}

