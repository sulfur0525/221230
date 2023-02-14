package 과제.과제5.model;

import java.util.ArrayList;

public class Member {
	private int mNo;
	private String id;
	private String pw;
	private String name;
	private String phone;
	
	
	//생성자
	public Member() {}


	public Member(int mNo, String id, String pw, String name, String phone) {
		super();
		this.mNo = mNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Member [mNo=" + mNo + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + "]";
	}


	public int getmNo() {
		return mNo;
	}


	public void setmNo(int mNo) {
		this.mNo = mNo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	

	
	
	
	
}
