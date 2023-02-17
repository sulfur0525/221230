package 과제.과제9.클래스.병원직원;

public class 의사 extends 병원직원{
	//필드
	String 진료;
	String 회진;
	String 당직;
	String 처방;
	
	public 의사() {
		// TODO Auto-generated constructor stub
	}

	public 의사(String 진료, String 회진, String 당직, String 처방, String name, String job, String salary, String workTime) {
		super(name,job,salary,workTime);
		this.진료 = 진료;
		this.회진 = 회진;
		this.당직 = 당직;
		this.처방 = 처방;
	}




	@Override
	public String toString() {
		return "의사 [진료=" + 진료 + ", 회진=" + 회진 + ", 당직=" + 당직 + ", 처방=" + 처방 + ", name=" + name + ", job=" + job
				+ ", salary=" + salary + ", workTime=" + workTime + "]";
	}
	
	
	
	
}
