package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.ReplyDto;

/**
 * Servlet implementation class reply
 */
@WebServlet(name = "Reply", urlPatterns = { "/board/reply" })
public class reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		int rindex = 0;
		if( type==1 ) {	
			rindex = 0;
		}else if(type==2 ) {
			rindex = Integer.parseInt(request.getParameter("rindex"));
			
		}
		ArrayList<ReplyDto> list = BoardDao.getInstance().getReplyList(rindex,bno);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(list);
		
		response.setCharacterEncoding("UTF-8");			// 응답 데이터 한글 인코딩 
		response.setContentType("application/json");	// 응답 데이터 타입
		response.getWriter().print(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
		request.setCharacterEncoding("UTF-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		String rcontent = request.getParameter("rcontent");
		
		boolean result = false;
		
		if( type==1 ) {
			ReplyDto dto = new ReplyDto(rcontent, mno, bno);
			
			result = BoardDao.getInstance().rwrite(dto);
			
		}else if(type==2 ) {
			int rindex = Integer.parseInt(request.getParameter("rindex"));
			
			ReplyDto dto = new ReplyDto(rcontent, rindex, mno, bno);
			
			result = BoardDao.getInstance().rwrite(dto);
		}
		response.getWriter().print(result);
		
	}

}
