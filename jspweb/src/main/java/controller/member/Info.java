package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.MultipartResponse;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class Info
 */
@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	// 로그인 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberDto> list = MemberDao.getInstance().memberList();
		ObjectMapper objectMapper = new ObjectMapper();
		String result = objectMapper.writeValueAsString(list);
		
		System.out.println(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(result);
	}
	
	// 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/member/pimg");
		System.out.println( uploadpath );
		
		// * 업로드 [ 유저파일 --> 서버폴더내 이동 ]
		MultipartRequest multi = new MultipartRequest(
				request,  						// 1. 요청방식 
				uploadpath , 					// 2. 첨부파일 가져와서 저장할 서버내 폴더 
				1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
				"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
				);
		
		// 그외 매개변수 요청 [ request --> multi / form 하위태그내 input 태그의 name 식별자  ]
		String mid = multi.getParameter("mid");	// 호출할 input의 name 
		String mpwd = multi.getParameter("mpwd");
		String memail = multi.getParameter("memail");
		String mimg = multi.getFilesystemName("mimg");	// 첨부파일된 파일명 호출[  .getFilesystemName ]
		
		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
			System.out.println( "dto : " + dto );
		boolean result = MemberDao.getInstance().signup(dto);
		response.getWriter().print(result);
		
		
		/*
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		String memail = request.getParameter("memail");
		String mimg = request.getParameter("mimg");
		
		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
		System.out.println(dto);
		
		boolean result = MemberDao.getInstance().signup(dto);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
		*/
	}

	// 회원 정보수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 회원탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
