package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import dao.UpdatePeripheralDAO;
import entity.Peripheral;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/adminPage/updatePeripheral")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UpdatePeripheralServlet extends HttpServlet {
	private static final String UPLOAD_DIR = "uploads";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int pagePeripheral = Integer.parseInt(req.getParameter("pagePeripheral"));
		int peripheralId = Integer.parseInt(req.getParameter("peripheralId"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String image = req.getParameter("imagePath");
		int price = Integer.parseInt(req.getParameter("price"));
		String brand = req.getParameter("brand");
		String category = req.getParameter("category");

		String connect = req.getParameter("connect");

		String ledRGB = req.getParameter("ledRGB");
		boolean isledRGB = "1".equals(ledRGB);

		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir(); // Tạo thư mục nếu chưa tồn tại
		}

		String imagePath = image; // Đường dẫn file trong ứng dụng

		for (Part part : req.getParts()) {
			String fileName = extractFileName(part);
			if (fileName != null && !fileName.isEmpty()) {
				String filePath = uploadPath + File.separator + fileName;
				try (FileOutputStream fos = new FileOutputStream(filePath); InputStream is = part.getInputStream()) {
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = is.read(buffer)) != -1) {
						fos.write(buffer, 0, bytesRead);
					}
					fos.close();
					is.close();
				}
				// Tạo đường dẫn file trong ứng dụng để lưu vào database
				imagePath = UPLOAD_DIR + "/" + fileName;
			}
		}

		Peripheral newPeripheral = new Peripheral(name, description, imagePath, price, brand, category, connect,
				isledRGB);
		newPeripheral.setPeripheralId(peripheralId);

		UpdatePeripheralDAO updatePeripheral = new UpdatePeripheralDAO();
		boolean isSuccess = updatePeripheral.isUpdatePeripheral(newPeripheral);

		if (isSuccess) {

			System.out.println("thanh cong");
//			resp.sendRedirect(req.getContextPath() + "/adminPage/listProduct");
			resp.sendRedirect(req.getContextPath() + "/adminPage/listPeripheral?pagePeripheral=" + pagePeripheral);
		} else {
			System.out.println("loi");
		}

	}

	private String extractFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		for (String content : contentDisposition.split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
			}
		}
		return null;
	}
}
