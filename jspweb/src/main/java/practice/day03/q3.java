package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class q3
 */
@WebServlet("/Ex3/q3")
public class q3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public q3() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Pdto> list = Pdao.getInstance().onPrint2();
		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString(list);
		
		System.out.println(list);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(result);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		String product = request.getParameter("product");
		int price = Integer.parseInt(request.getParameter("price"));
		
		System.out.println(product);
		System.out.println(price);
		
		Pdto pdto = new Pdto(0, product, price);
		boolean result = Pdao.getInstance().onWrite2(pdto);
		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String newProduct = request.getParameter("newProduct");
		System.out.println("product"+newProduct);
		int newPrice = Integer.parseInt(request.getParameter("newPrice"));
		System.out.println("price"+newPrice);
		int pno = Integer.parseInt(request.getParameter("pno"));
		System.out.println("pno"+pno);
		Pdto pdto = new Pdto(pno, newProduct, newPrice);
		System.out.println(pdto);
		
		boolean result = Pdao.getInstance().onUpdate2(pdto);
		response.getWriter().print(result);
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		boolean result = Pdao.getInstance().onDelete2(pno);
		response.getWriter().print(result);
		
	}

}
