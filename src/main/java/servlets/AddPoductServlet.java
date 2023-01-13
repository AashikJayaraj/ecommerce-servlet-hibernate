package servlets;

import javax.servlet.http.HttpServlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ProductDao;
import entities.Product;
import helper.FactoryProvider;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class AddPoductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddPoductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("product_name");
		int productPrice = Integer.parseInt(request.getParameter("product_price")); 
		int productQty = Integer.parseInt(request.getParameter("product_qty")); 
		String productDescription = request.getParameter("product_description");
		Product product = new Product(productQty,productName,productDescription,productPrice);
		
		ProductDao productDao = new ProductDao(FactoryProvider.getFactory());
		int productDbId = productDao.addProduct(product);
		String imageFileName = productDbId+".jpg";
		
		String productImage = request.getParameter("productImage");
		Part part = request.getPart("productImage");
		
		String applicationPath = getServletContext().getRealPath("asset");
        String uploadPath = applicationPath + File.separator + "productimages";
        System.out.println("applicationPath:" + uploadPath);
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        String fullFilePath = uploadPath + File.separator + imageFileName;
        String sRootPath = new File(fullFilePath).getAbsolutePath();
        System.out.println("sRootPath: " + sRootPath);
        part.write(fullFilePath + File.separator);
        
        HttpSession httpSession = request.getSession();
		httpSession.setAttribute("message", " Product succesfully added");
		response.sendRedirect("admin.jsp");
		return;
	
		
	}

	

}
