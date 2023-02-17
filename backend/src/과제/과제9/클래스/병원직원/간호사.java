package 과제.과제9.클래스.병원직원;

public class 간호사 extends 병원직원{
	String 차팅;
	String 환자케어;
	String 비품관리;
	
	public 간호사() {
		// TODO Auto-generated constructor stub
	}

	public 간호사(String 차팅, String 환자케어, String 비품관리, String name, String job, String salary, String workTime) {
		super(name,job,salary,workTime);
		this.차팅 = 차팅;
		this.환자케어 = 환자케어;
		this.비품관리 = 비품관리;
	}

	@Override
	public String toString() {
		return "간호사 [차팅=" + 차팅 + ", 환자케어=" + 환자케어 + ", 비품관리=" + 비품관리 + ", name=" + name + ", job=" + job + ", salary="
				+ salary + ", workTime=" + workTime + "]";
	}
	
	
}
