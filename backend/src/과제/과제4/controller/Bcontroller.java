package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;
import 과제.과제4.model.Member;

public class Bcontroller {
	
	ArrayList<Board> boardDb = new ArrayList<>();
	Mcontroller mcontroller = new Mcontroller();
	
	//1. 게시판 글 목록 출력
	public String boardPrint() {
		String boardlist = "";
		for(int i = 0 ; i< boardDb.size() ; i++) {
			boardlist = boardlist+
					i+"\t"+
					boardDb.get(i).views+"\t"+
					boardDb.get(i).member.name+"\t"+
					boardDb.get(i).title+"\n";
		}
		
		 return boardlist;
	}
	
	//2. 글쓰기
	public int posting(String title,String contents,Member loginInfo) {
		Board board = new Board(title, contents, 0, loginInfo);
		boardDb.add(board);
		return 0;
	}
	
	//3. 글보기
	public String postPrint(int bnum) {
		String content ="제목 : " +boardDb.get(bnum).title +
						"\n작성자 : "+boardDb.get(bnum).member.name+
						"\t조회수 : "+boardDb.get(bnum).views+
						"\n내용 : "+boardDb.get(bnum).contents;
		
		boardDb.get(bnum).views++;
		
		return content;
	}
	
	//4. 글삭제
	public int delete(int bnum,Member loginInfo) {
		if(boardDb.get(bnum).member.name.equals(loginInfo.name)) {
			boardDb.remove(bnum);
			return 1;
		}else {
			return 2;
		}
	}
	
	//5. 글수정가능?
	public int editch(int bnum,Member loginInfo) {
		if(boardDb.get(bnum).member.name.equals(loginInfo.name)) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public int edit(int bnum, String text) {
		boardDb.get(bnum).contents = text;
		
		return 1;
	}
	
}
