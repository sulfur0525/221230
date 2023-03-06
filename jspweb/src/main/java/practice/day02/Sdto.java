package practice.day02;

public class Sdto {
	private String name;
	private String phone;
	private double height;
	private int age;
	private String date;
	private String sex;
	private boolean agree;
	private String live;
	private String intro;
	
	public Sdto() {
		// TODO Auto-generated constructor stub
	}

	public Sdto(String name, String phone, double height, int age, String date, String sex, boolean agree, String live,
			String intro) {
		super();
		this.name = name;
		this.phone = phone;
		this.height = height;
		this.age = age;
		this.date = date;
		this.sex = sex;
		this.agree = agree;
		this.live = live;
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "Sdto [name=" + name + ", phone=" + phone + ", height=" + height + ", age=" + age + ", date=" + date
				+ ", sex=" + sex + ", agree=" + agree + ", live=" + live + ", intro=" + intro + "]";
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	public String getLive() {
		return live;
	}

	public void setLive(String live) {
		this.live = live;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
}
