package Day15.Ex9_MVC패턴;

import java.util.ArrayList;

public class Controller {
	private static Controller con = new Controller();
	private Controller() {};
	public static Controller getInstance() {
		return con;
	}
	
	
	public boolean singup(String mid , String mpw) {
		MemberDto dto = new MemberDto(0,mid,mpw);
		
		boolean singup = MemberDao.getInstance().singup(dto);
		return singup;
	}
	
	public String list() {
		ArrayList<MemberDto> memberList = MemberDao.getInstance().list();
		String list = "회원번호\t아이디\t비밀번호\n";
		for(MemberDto m : memberList) {
			list += m.getMno()+"\t"+m.getMid()+"\t"+m.getMpw()+"\n";
		}
		
		return list;
	}
	
	public boolean update(int mno, String mpw) {
		return MemberDao.getInstance().update(mno, mpw);
	}
	
	public boolean delete(int mno) {
		return MemberDao.getInstance().delete(mno);
	}
}
