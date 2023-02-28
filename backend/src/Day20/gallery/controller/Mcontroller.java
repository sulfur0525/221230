package Day20.gallery.controller;

import Day20.gallery.model.Dao.MemberDao;
import Day20.gallery.model.Dto.MemberDto;

public class Mcontroller {
	private static Mcontroller mcontroller = new Mcontroller();
	private Mcontroller() {};
	public static Mcontroller getInstence() {return mcontroller;}
	private int loginSession = 0;
	
	public int getLoginSession() {return loginSession;}
	
	// 회원가입 + 아이디 중복체크
	public int signup(String mid,String mpw,String mname,String mphone) {
		// 아이디 중복체크
		if(MemberDao.getInstence().idCheck(mid)) {
			return 2;
		}
		MemberDto memberDto = new MemberDto(0, mid, mpw, mname, mphone);
		
		return MemberDao.getInstence().signup(memberDto);
	}
	
	
	// 로그인
	public boolean login(String mid,String mpw) {
		
		int result = MemberDao.getInstence().login(mid, mpw);
		
		if(result ==0 ) {
			return false;
		}else {
			loginSession = result;
			return true;
		}
	}
}
