package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Memo;

public class Memocontroller {
	private static Memocontroller memoc = new Memocontroller();
	private Memocontroller() {}
	public static Memocontroller getInstance() {return memoc;}
	
	private ArrayList<Memo> memoBD = new ArrayList<>();
	
	// 1. 쪽지 보내기
	public boolean write(int pNo, String title, String content) {
		if(Mcontroller.getInstance().getLogSession()==null) {
			return false;
		}
		
		int memoNo = -1;
		
		if(memoBD.size()==0) {
			memoNo = 0;
		}else {
			memoNo = memoBD.get(memoBD.size()).getMemoNo()+1;
		}
		
		Memo memo = new Memo(memoNo, title, content, pNo, Mcontroller.getInstance().getLogSession().getmNo());
		
		memoBD.add(memo);
		
		return true;
	}
	
	// 2. 쪽지 삭제
	public boolean meDelete(int memoNo) {
		if(Mcontroller.getInstance().getLogSession().getmNo()!=memoBD.get(memoNo).getMno()) {
			return false;
		}else {
			memoBD.remove(memoNo);
			return true;
		}
		
	}
}
