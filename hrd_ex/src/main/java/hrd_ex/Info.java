package hrd_ex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Info
 */
@WebServlet("/info")
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
		int type = Integer.parseInt(request.getParameter("type"));
		Dao dao = new Dao();
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray  = null;
		
		if(type==1) {
			ArrayList<MemberDto> result = dao.getmemeberlist();
			jsonArray  = mapper.writeValueAsString( result );	
		}else if(type==2) {
			ArrayList<MemberDto> result = dao.getsum();
			jsonArray  = mapper.writeValueAsString( result );
		}else if(type==3) {
			int custno = Integer.parseInt(request.getParameter("custno"));
			MemberDto dto = dao.getmember(custno);
			jsonArray  = mapper.writeValueAsString( dto );
		}
	
		// 3. 응답 
		response.setCharacterEncoding("UTF-8");			// 응답 데이터 한글 인코딩 
		response.setContentType("application/json");	// 응답 데이터 타입
		response.getWriter().print(jsonArray);			// 응답 데이터 보내기
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Dao dao = new Dao();
		
		int custno = Integer.parseInt(request.getParameter("custno"));
	    String custname = request.getParameter("custname");
	    String phone = request.getParameter("phone");
	    String address = request.getParameter("address");
	    String joindate = request.getParameter("joindate");
	    String grade = request.getParameter("grade");
	    String city = request.getParameter("city");
	    
	    MemberDto dto = new MemberDto(custno, custname, phone, address, joindate, grade, city, custno);
	    System.out.println(dto);
	    
		boolean result = dao.join(dto);
		response.getWriter().print(result);
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Dao dao = new Dao();
		
		int custno = Integer.parseInt(request.getParameter("custno"));
	    String custname = request.getParameter("custname");
	    String phone = request.getParameter("phone");
	    String address = request.getParameter("address");
	    String joindate = request.getParameter("joindate");
	    String grade = request.getParameter("grade");
	    String city = request.getParameter("city");
	    
	    MemberDto dto = new MemberDto(custno, custname, phone, address, joindate, grade, city, custno);
	    System.out.println(dto);
	    
		boolean result = dao.update(dto);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
