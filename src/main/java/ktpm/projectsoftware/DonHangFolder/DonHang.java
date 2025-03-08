package ktpm.projectsoftware.DonHangFolder;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import ktpm.projectsoftware.NguoiDungFolder.NguoiDung;
import ktpm.projectsoftware.SanPhamThuocDonHang.SanPhamThuocDonHang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DonHang {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;
    private boolean TrangThaiDonHang;
    private boolean NhanHang;
    private long GiaTriDonHang;
    @ManyToOne
    @JoinColumn(name="NguoiDungID",nullable=false)
    NguoiDung nguoidung;
   
}
