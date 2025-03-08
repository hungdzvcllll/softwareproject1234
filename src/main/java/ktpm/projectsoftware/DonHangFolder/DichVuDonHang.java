package ktpm.projectsoftware.DonHangFolder;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ktpm.projectsoftware.NguoiDungFolder.DichVuNguoiDung;

@Service
public class DichVuDonHang {
    @Autowired
    DichVuNguoiDung dvnd;
    @Autowired
    DonHangRepository dhRepo;
    public ArrayList<DonHang> danhSachDonHangNguoiDung(int id){
        return dhRepo.timKiemBangNguoiDung(id);
    }
}
