package practice.day02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class q2
 */
@WebServlet("/q2")
public class q2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public q2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Sdto> list = Dao.getInstance().getSdata();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString(list);
		System.out.println(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		double height = Double.parseDouble(request.getParameter("height")); 
		int age = Integer.parseInt(request.getParameter("age"));
		String date = request.getParameter("date");
		String sex = request.getParameter("gender");
		boolean agree = Boolean.parseBoolean(request.getParameter("agree"));
		String live = request.getParameter("live");
		String intro = request.getParameter("intro");
		
		Sdto sdto = new Sdto(name, phone, height, age, date, sex, agree, live, intro);
		Boolean result = Dao.getInstance().setSdata(sdto);
		response.getWriter().print(result);
	}

}
