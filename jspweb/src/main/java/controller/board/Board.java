package controller.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;
import model.dto.PageDto;

/**
 * Servlet implementation class Write
 */
@WebServlet("/board/info")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if( type.equals("1") ) {
			
			int cno = Integer.parseInt(request.getParameter("cno"));
			
			String key = request.getParameter("key");
			String keyword = request.getParameter("keyword");
			
			int page = Integer.parseInt(request.getParameter("page"));
			int listsize = Integer.parseInt(request.getParameter("listsize"));
			int startrow = (page-1)*listsize;
			
			//int totalsize = BoardDao.getInstance().gettotalsize();
			int totalsize = BoardDao.getInstance().gettotalsize(key,keyword,cno);
			int totalpage = totalsize%listsize==0 ? totalsize/listsize : totalsize/listsize+1;
			
			int btnsize = 5;
			int startbtn = ((page-1)/btnsize)*5+1;
			int endbtn = startbtn+(btnsize-1);
			if(endbtn>totalpage) {
				endbtn = totalpage;
			}
			
			//ArrayList<BoardDto> list = BoardDao.getInstance().getBoardList(startrow,listsize);
			ArrayList<BoardDto> list = BoardDao.getInstance().getBoardList(startrow,listsize,key,keyword,cno);
			PageDto dto = new PageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, list);
			
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonArray = objectMapper.writeValueAsString(dto);
			
			response.setCharacterEncoding("UTF-8");			// 응답 데이터 한글 인코딩 
			response.setContentType("application/json");	// 응답 데이터 타입
			response.getWriter().print(jsonArray);
		}else if(type.equals("2")) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			BoardDto boardDto = BoardDao.getInstance().getBoard(bno);
			
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(boardDto);
			response.setCharacterEncoding("UTF-8");	
			response.setContentType("application/json");
			response.getWriter().print(json);
		}
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		
		MultipartRequest multi = new MultipartRequest(
				request,  						// 1. 요청방식 
				path , 					// 2. 첨부파일 가져와서 저장할 서버내 폴더 
				1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
				"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
				);
		int cno = Integer.parseInt(multi.getParameter("cno")) ;	// 호출할 input의 name 
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		String mid = (String)request.getSession().getAttribute("login");
		int mno = MemberDao.getInstance().getMno(mid);
		if( mno < 1 ) { response.getWriter().print("false"); }
		
		
		BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, cno);
		System.out.println(boardDto);
		boolean result = BoardDao.getInstance().bwrite(boardDto);
		response.getWriter().print(result);
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		
		MultipartRequest multi = new MultipartRequest(
				request,  						// 1. 요청방식 
				path , 					// 2. 첨부파일 가져와서 저장할 서버내 폴더 
				1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
				"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
				);
		
		int bno = Integer.parseInt(multi.getParameter("bno")) ;	// 호출할 input의 name 
		int cno = Integer.parseInt(multi.getParameter("cno")) ;
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		String oldbfile = BoardDao.getInstance().getBoard(bno).getBfile();
		
		if(bfile==null) {
			bfile = oldbfile;
		}else {
			String filepath = request.getSession().getServletContext().getRealPath("/board/bfile/"+oldbfile);
			File file = new File(filepath);
			if(file.exists()) {
				file.delete();
			}
		}
		
		BoardDto boardDto = new BoardDto(bno, btitle, bcontent, bfile, cno);
		System.out.println(boardDto);
		
		boolean result = BoardDao.getInstance().bupdate(boardDto);
		response.getWriter().print(result);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		String bfile = BoardDao.getInstance().getBoard(bno).getBfile();
		
		boolean result = BoardDao.getInstance().bdelete(bno);
		
		//파일삭제
		if(result) {
			String path = request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);
			File file = new File(path);
			if(file.exists()) {
				file.delete();
			}
		}
		response.getWriter().print(result);
	}

}
