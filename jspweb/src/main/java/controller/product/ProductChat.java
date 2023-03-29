package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.admin.Alarm;
import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ChatDto;
import model.dto.ProductDto;

/**
 * Servlet implementation class ProductChat
 */
@WebServlet("/product/chat")
public class ProductChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductChat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = MemberDao.getInstance().getMno(((String) request.getSession().getAttribute("login")));
		int chatmno = Integer.parseInt(request.getParameter("chatmno"));
		ArrayList<ChatDto> result = ProductDao.getInstance().getChatList(mno, pno,chatmno);
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(result);
		String json = objectMapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ncontent = request.getParameter("ncontent");
		int pno = Integer.parseInt(request.getParameter("pno"));
		int frommno = MemberDao.getInstance().getMno(((String) request.getSession().getAttribute("login")));
		int tomno = Integer.parseInt(request.getParameter("tomno"));
		
		ChatDto dto = new ChatDto(0, ncontent, null, pno, frommno, tomno);
		boolean result = ProductDao.getInstance().setChat(dto);
		if(result) {
			try {
				Alarm.서버메시지(null, tomno+","+frommno);
			} catch (Exception e) {	System.out.println(e); }
		}
		
		response.getWriter().print(result);
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
