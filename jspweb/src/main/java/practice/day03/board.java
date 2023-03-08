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
 * Servlet implementation class board
 */
@WebServlet("/Ex3/board")
public class board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public board() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Dto> list = Dao.getInstance().onPrint();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString(list);
		System.out.println(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(result);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		System.out.println(content);
		System.out.println(writer);
		
		Dto dto = new Dto(0, content, writer, null);
		
		boolean result = Dao.getInstance().onWrite(dto);
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno : "+bno);
		String newContent = request.getParameter("newContent");
		System.out.println("newContent : "+newContent);
		Dto dto = new Dto(bno, newContent, null, null);
		
		boolean result = Dao.getInstance().onUpdate(dto);
		response.getWriter().print(result);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno : "+bno);
		boolean result = Dao.getInstance().onDelete(bno);
		response.getWriter().print(result);
	}

}

/*
		JSP 서블릿 에서 HTTP 메소드 put , delete 사용시 필수 설정
	 	 	* 기본값 : 매개변수 요청 차단 
	 	1. Servers 폴더 클릭 
	 	2. server.xml 더블클릭 
	  	3. 하단 Source 탭 클릭 
	  	4. 대략 60번대 줄
	  		 원본 : <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" />
	  		 수정 : <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8" />
*/
