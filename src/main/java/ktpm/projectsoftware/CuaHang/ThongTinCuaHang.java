package ktpm.projectsoftware.CuaHang;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinCuaHang {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    private String email;
    private String matKhau;
    @Column(columnDefinition = "TEXT")
    private String thongTin;
    @Column(columnDefinition = "TEXT")
    private String chinhSach;

}
