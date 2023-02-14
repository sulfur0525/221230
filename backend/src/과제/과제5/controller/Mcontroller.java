package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Member;

public class Mcontroller {
	private static Mcontroller mc = new Mcontroller();
	private Mcontroller() {}
	public static Mcontroller getInstance() {return mc;}
	
	private ArrayList<Member> memberDB = new ArrayList<>();
	
	private Member logSession = null;
	public Member getLogSession() {
		return logSession;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
