package com.ktds.closet.vo;

import java.sql.Timestamp;

public class ActionVO {
	private String email;
	private String fdemail;
	private String action;
	private Timestamp sysdate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFdemail() {
		return fdemail;
	}
	public void setFdemail(String fdemail) {
		this.fdemail = fdemail;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Timestamp getSysdate() {
		return sysdate;
	}
	public void setSysdate(Timestamp sysdate) {
		this.sysdate = sysdate;
	}
	@Override
	public String toString() {
		return "ActionVO [email=" + email + ", fdemail=" + fdemail
				+ ", action=" + action + ", sysdate=" + sysdate + "]";
	}

	
}
