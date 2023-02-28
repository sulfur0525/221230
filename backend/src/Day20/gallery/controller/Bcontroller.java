package Day20.gallery.controller;

import java.util.ArrayList;

import Day20.gallery.model.Dao.BoardDao;
import Day20.gallery.model.Dto.BoardDto;
import Day20.gallery.model.Dto.CategoryDto;

public class Bcontroller {
	private static Bcontroller bcontroller = new Bcontroller();
	private Bcontroller() {};
	public static Bcontroller getInstence() {return bcontroller;}
	
	public boolean categoryAdd(String cname) {
		return BoardDao.getInstence().categoryAdd(cname);
	}
	
	public ArrayList<CategoryDto> categoryPrint() {
		return BoardDao.getInstence().categoryPrint();
		
	}
	
	public boolean boardAdd(String btitle , String bcontent , int cno ) {
		return BoardDao.getInstence().boardAdd(
				btitle, bcontent, 
				Mcontroller.getInstence().getLoginSession()
				, cno );
	}
	
	public ArrayList<BoardDto> boardPrintRecent(){
		return BoardDao.getInstence().boardPrintRecent();
	}
	
	public ArrayList<BoardDto> boardPrint(int cno) {
		return BoardDao.getInstence().boardPrint(cno);
	}
}
