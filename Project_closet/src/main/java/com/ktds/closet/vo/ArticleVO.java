package com.ktds.closet.vo;

import java.sql.Timestamp;

public class ArticleVO {
	private int article_num;
	private int scrab_num;
	private String email;
	private String name;
	private String content;
	private int favorite;
	Timestamp article_date;
	private int category;
	private int scrabPrivate;
	private String tag;
	private String tab;
	private int gender;
	private String btnVal;
	
	public int getArticle_num() {
		return article_num;
	}
	public void setArticle_num(int article_num) {
		this.article_num = article_num;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFavorite() {
		return favorite;
	}
	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}
	public Timestamp getArticle_date() {
		return article_date;
	}	
	public void setArticle_date(Timestamp article_date) {
		this.article_date = article_date;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getBtnVal() {
		return btnVal;
	}
	public void setBtnVal(String btnVal) {
		this.btnVal = btnVal;
	}
	public int getScrab_num() {
		return scrab_num;
	}
	public void setScrab_num(int scrab_num) {
		this.scrab_num = scrab_num;
	}	
	public int getScrabPrivate() {
		return scrabPrivate;
	}
	public void setScrabPrivate(int scrabPrivate) {
		this.scrabPrivate = scrabPrivate;
	}	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}	
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "ArticleVO [article_num=" + article_num + ", scrab_num="
				+ scrab_num + ", email=" + email + ", name=" + name
				+ ", content=" + content + ", favorite=" + favorite
				+ ", article_date=" + article_date + ", category=" + category
				+ ", scrabPrivate=" + scrabPrivate + ", tag=" + tag + ", tab="
				+ tab + ", gender=" + gender + ", btnVal=" + btnVal + "]";
	}
	
	
	
}