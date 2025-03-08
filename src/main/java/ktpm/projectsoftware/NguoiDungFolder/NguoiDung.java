package ktpm.projectsoftware.NguoiDungFolder;

import java.time.LocalDateTime;
import java.util.Collection;

import org.hibernate.annotations.DialectOverride.GeneratedColumns;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import ktpm.projectsoftware.DanhGiaFolder.DanhGia;
import ktpm.projectsoftware.DonHangFolder.DonHang;
import ktpm.projectsoftware.SanPhamFolder.SanPham;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@ComponentScan
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(columnDefinition = "NVARCHAR(50)", unique = true)
    private String ten;
    @Column(columnDefinition = "NVARCHAR(50)")
    private String VaiTro;
    @Column(columnDefinition = "NVARCHAR(200)")
    private String MatKhau;
    private boolean daDangKy;
    private String maXacNhan;
    private LocalDateTime ThoiHan;
    @ManyToMany
    @JoinTable(name = "GioHang", joinColumns = @JoinColumn(name = "NguoiDungID"), inverseJoinColumns = @JoinColumn(name = "SanPhamID"))
    private Collection<SanPham> sanpham;
    @JsonIgnore
    @OneToMany(mappedBy = "nguoidung")
    Collection<DonHang> donhang;
    @OneToMany(mappedBy = "nguoidung")
    Collection<DanhGia> danhgia;

    public NguoiDung() {
    }

}
