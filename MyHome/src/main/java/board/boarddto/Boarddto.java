package board.boarddto;

import java.sql.Date;

public class Boarddto {
	
	private int bnum;
	private String bwriter;
	private Date bdate;
	private String bsubject;
	private String bcontent;
	private String bid;
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public String getBsubject() {
		return bsubject;
	}
	public void setBsubject(String bsubject) {
		this.bsubject = bsubject;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "Boarddto [bnum=" + bnum + ", bwriter=" + bwriter + ", bdate=" + bdate + ", bsubject=" + bsubject
				+ ", bcontent=" + bcontent + ", bid=" + bid + "]";
	}
	
	
	
	
}
