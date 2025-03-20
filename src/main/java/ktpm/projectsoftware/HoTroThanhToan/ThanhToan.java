package ktpm.projectsoftware.HoTroThanhToan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ktpm.projectsoftware.DonHangFolder.DonHang;
import ktpm.projectsoftware.DonHangFolder.DonHangRepository;

@Controller
public class ThanhToan {
    @Autowired
    ajaxServlet aj;
    @Autowired
    DonHangRepository dhRepo;

    @GetMapping("/thanhtoan")
    public String thanhtoan(HttpServletRequest req, HttpServletResponse res) {
        try {
            DonHang dh = dhRepo.findById(Integer.parseInt(req.getParameter("don_hangid")));
            aj.doPost(req, res, Long.toString(dh.getGiaTriDonHang()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:" + aj.getPaymentUrl();
    }
    @GetMapping("/ketquathanhtoan")
    public String ketqua(@RequestParam int vnp_OrderInfo,@RequestParam int vnp_TransactionStatus){
        if(vnp_TransactionStatus==0){
            dhRepo.ThanhToanThanhCong(vnp_OrderInfo);
            return "abc";
        }
        else
        return "def";
    }
}