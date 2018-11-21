package com.ktds.closet.vo;

import java.sql.Timestamp;

public class CommentVO {
	private int comment_num;
	private String email;
	private String comment_content;
	private Timestamp comment_date;
	private int article_num;

	public CommentVO() {
	}

	public CommentVO(String email, String comment_content, int article_num) {
		this.email = email;
		this.comment_content = comment_content;
		this.article_num = article_num;
	}

	public CommentVO(String email, String comment_content, Timestamp comment_date) {
		this.email = email;
		this.comment_content = comment_content;
		this.comment_date = comment_date;
	}

	public CommentVO(int comment_num, String email, String comment_content, Timestamp comment_date, int article_num) {
		this.comment_num = comment_num;
		this.email = email;
		this.comment_content = comment_content;
		this.comment_date = comment_date;
		this.article_num = article_num;
	}

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

//	@JsonSerialize(using=Formatting.class)
	public Timestamp getComment_date() {
		return comment_date;
	}

	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}

	public int getArticle_num() {
		return article_num;
	}

	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}
}
