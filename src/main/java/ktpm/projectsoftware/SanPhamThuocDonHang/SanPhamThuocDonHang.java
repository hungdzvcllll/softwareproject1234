package ktpm.projectsoftware.SanPhamThuocDonHang;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import ktpm.projectsoftware.DonHangFolder.DonHang;
import ktpm.projectsoftware.SanPhamFolder.SanPham;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamThuocDonHang {
    @EmbeddedId
    CompositeKey1 key;
   
    private int SoLuong;
}
