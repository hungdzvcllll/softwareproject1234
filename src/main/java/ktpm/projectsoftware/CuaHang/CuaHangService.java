package ktpm.projectsoftware.CuaHang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CuaHangService {
    @Autowired
    ThongTinCuaHangRepository ttchRepo;
    @Autowired
    PasswordEncoder pe;
    public void capNhatThongTin(String thong_tin) {
        ttchRepo.save(new ThongTinCuaHang(0,"bui269952@gmail.com",pe.encode("abc"),null,null));
        ttchRepo.capNhatThongTin(thong_tin);
    }

    public void capNhatChinhSach(String thong_tin) {
        ttchRepo.capNhatChinhSach(thong_tin);
    }

}
