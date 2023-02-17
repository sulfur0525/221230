package 과제.과제9.클래스.병원직원;

public class 직원 extends 병원직원{
	String 청소;
	
	public 직원() {
		// TODO Auto-generated constructor stub
	}

	public 직원(String 청소,String name, String job, String salary, String workTime) {
		super(name,job,salary,workTime);
		this.청소 = 청소;
	}

	@Override
	public String toString() {
		return "직원 [청소=" + 청소 + ", name=" + name + ", job=" + job + ", salary=" + salary + ", workTime=" + workTime
				+ "]";
	}
	
	
}
