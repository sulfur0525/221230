package controller.product;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ProductDto;

/**
 * Servlet implementation class Write
 */
@WebServlet("/product/info")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String 동 = request.getParameter("동");
		String 서 = request.getParameter("서");
		String 남 = request.getParameter("남");
		String 북 = request.getParameter("북");
		System.out.println(동+"/"+서+"/"+남+"/"+북);
		
		
		ArrayList<ProductDto> list = ProductDao.getInstance().getList(동,서,남,북);
		System.out.println(list);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String josn = objectMapper.writeValueAsString(list);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(josn);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String 경로 = request.getSession().getServletContext().getRealPath("/product/pimg");
		
		File 저장경로객체 = new File(경로);
		
		DiskFileItemFactory 파일저장소 = new DiskFileItemFactory();
		파일저장소.setRepository(저장경로객체);
		파일저장소.setSizeThreshold(1024*1024*10);
		파일저장소.setDefaultCharset("UTF-8");
		
		ServletFileUpload 파일업로드객체 = new ServletFileUpload(파일저장소);
		
		try {
			List<FileItem> 파일아이템목록 = 파일업로드객체.parseRequest(request);
			List<String> 일반필드목록 = new ArrayList<>();
			List<String> 파일필드목록 = new ArrayList<>();
			
			for(FileItem item : 파일아이템목록) {
				if(item.isFormField()) {
					System.out.println(item.getFieldName());
					System.out.println(item.getString());
					일반필드목록.add(item.getString());
				}else {
					System.out.println(item.getFieldName());
					System.out.println(item.getName());
					
					String filename = UUID.randomUUID()+" "+item.getName().replaceAll(" ","-");
					
					파일필드목록.add(filename);
					
					File 업로드할파일경로 = new File(경로+"/"+filename);
					item.write(업로드할파일경로);
				}
			}
			int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
			ProductDto dto= new ProductDto(일반필드목록.get(0), 일반필드목록.get(1), Integer.parseInt(일반필드목록.get(2)), 
											일반필드목록.get(3), 일반필드목록.get(4), mno, 파일필드목록);
			System.out.println(dto);
			
			boolean result = ProductDao.getInstance().write(dto);
			response.getWriter().print(result);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
		
			
		
		/*
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		
		MultipartRequest multi = new MultipartRequest(
				request,  						// 1. 요청방식 
				path , 					// 2. 첨부파일 가져와서 저장할 서버내 폴더 
				1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
				"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
				);
		
		String pname = multi.getParameter("pname");
		String pcomment = multi.getParameter("pcomment");
		int pprice = Integer.parseInt(multi.getParameter("pprice"));
		String plat = multi.getParameter("plat");
		String plng = multi.getParameter("plng");
	
		//String pfile = multi.getFilesystemName("pfile");
		
		
		Enumeration pfiles = multi.getFileNames(); while (pfiles.hasMoreElements()) {
		String s = (String)pfiles.nextElement(); System.out.println(s); }
		 
		
		
		
		
		
		System.out.println(pname);
		System.out.println(pcomment);
		System.out.println(pprice);
		System.out.println(plat);
		System.out.println(plng);
		
		ProductDto dto= new ProductDto(pname, pcomment, pprice, plat, plng);
		
		boolean result = ProductDao.getInstance().write(dto);
		response.getWriter().print(result);
		*/
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
