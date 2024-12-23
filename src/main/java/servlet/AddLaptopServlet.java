package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import dao.AddLaptopDAO;
import entity.Laptop;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/adminPage/addLaptop")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class AddLaptopServlet extends HttpServlet {
	private static final String UPLOAD_DIR = "uploads";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = req.getParameter("name");
		String description = req.getParameter("description");

		int price = Integer.parseInt(req.getParameter("price"));
		String brand = req.getParameter("brand");
		String category = req.getParameter("category");
		String cpu = req.getParameter("cpu");
		String gpu = req.getParameter("gpu");
		String ram = req.getParameter("ram");
		String drive = req.getParameter("drive");
		String size = req.getParameter("size");
		String resolution = req.getParameter("resolution");

		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir(); // Tạo thư mục nếu chưa tồn tại
		}

		String imagePath = null; // Đường dẫn file trong ứng dụng

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
				imagePath =UPLOAD_DIR + "/" + fileName;
			}
		}

		Laptop newLaptop = new Laptop(name, description, imagePath, price, brand, category, cpu, gpu, ram, drive, size,
				resolution);

		AddLaptopDAO addLaptopDao = new AddLaptopDAO();
		boolean isSuccess = addLaptopDao.isAddLaptop(newLaptop);
		System.out.println(isSuccess);

		if (isSuccess) {

			
//			resp.sendRedirect(req.getContextPath() + "/adminPage/listProduct");
			resp.sendRedirect(req.getContextPath() + "/adminPage/listLaptop");
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
