package DTO;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int rollNo;
	private String name ;
	private String passYear ;
	private String imageLoc ;
	private String pdfLoc;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassYear() {
		return passYear;
	}
	public void setPassYear(String passYear) {
		this.passYear = passYear;
	}
	
	public String getImageLoc() {
		return imageLoc;
	}
	public void setImageLoc(String imageLoc) {
		this.imageLoc = imageLoc;
	}
	
	public String getPdfLoc() {
		return pdfLoc;
	}
	public void setPdfLoc(String pdfLoc) {
		this.pdfLoc = pdfLoc;
	}
	

	
}
