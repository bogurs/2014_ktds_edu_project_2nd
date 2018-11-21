package com.ktds.closet.vo;

import java.sql.Timestamp;

public class FriendVO {
	private String name;
	private String email;
	private String fdname;
	private String fdemail;
	private Timestamp logdate;
	private String action;
	private String fdmanage_seq_no;
	private String friend_seq_no;
	private int article_num;

	public int getArticle_num() {
		return article_num;
	}

	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}

	@Override
	public String toString() {
		return "FriendVO [name=" + name + ", email=" + email + ", fdname=" + fdname + ", fdemail=" + fdemail
				+ ", logdate=" + logdate + ", action=" + action + ", fdmanage_seq_no=" + fdmanage_seq_no
				+ ", friend_seq_no=" + friend_seq_no + "]";
	}

	public Timestamp getLogdate() {
		return logdate;
	}

	public void setLogdate(Timestamp logdate) {
		this.logdate = logdate;
	}

	public String getFriend_seq_no() {
		return friend_seq_no;
	}

	public void setFriend_seq_no(String friend_seq_no) {
		this.friend_seq_no = friend_seq_no;
	}

	public String getFdmanage_seq_no() {
		return fdmanage_seq_no;
	}

	public void setFdmanage_seq_no(String fdmanage_seq_no) {
		this.fdmanage_seq_no = fdmanage_seq_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFdname() {
		return fdname;
	}

	public void setFdname(String fdname) {
		this.fdname = fdname;
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

}
