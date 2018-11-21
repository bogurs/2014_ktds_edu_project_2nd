package com.ktds.closet.vo;

public class JoinVO {
	private String email;
	private String name;
	private String pass;
	private int year;
	private int month;
	private int day;
	private int gender;
	private String kg;
	private String cm;
	private String status;

	public String getKg() {
		return kg;
	}

	public void setKg(String kg) {
		this.kg = kg;
	}

	public String getCm() {
		return cm;
	}

	public void setCm(String cm) {
		this.cm = cm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "JoinVO [email=" + email + ", name=" + name + ", pass=" + pass + ", year=" + year + ", month=" + month
				+ ", day=" + day + ", gender=" + gender + ", kg=" + kg + ", cm=" + cm + ", status=" + status + "]";
	}

}
