package ktpm.projectsoftware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ktpm.projectsoftware.DonHangFolder.DichVuDonHang;
import ktpm.projectsoftware.SanPhamThuocDonHang.DichVuDatHang;

@SpringBootApplication
public class ProjectsoftwareApplication implements CommandLineRunner {
	@Autowired
	DichVuDatHang dvdh;
    @Autowired
    DichVuDonHang dvdonhang;
	public static void main(String[] args) {
		SpringApplication.run(ProjectsoftwareApplication.class, args);
	}

	public void run(String... args) {
		System.out.println(dvdonhang.tongDoanhThu());
	}

}
