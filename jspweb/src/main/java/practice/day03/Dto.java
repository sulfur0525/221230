package practice.day03;

public class Dto {
	private int bno;
	private String bcontent;
	private String bwriter;
	private String bdate;

	public Dto() {
		// TODO Auto-generated constructor stub
	}

	public Dto(int bno, String bcontent, String bwriter, String bdate) {
		super();
		this.bno = bno;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bdate = bdate;
	}

	@Override
	public String toString() {
		return "Dto [bno=" + bno + ", bcontent=" + bcontent + ", bwriter=" + bwriter + ", bdate=" + bdate + "]";
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	





}
