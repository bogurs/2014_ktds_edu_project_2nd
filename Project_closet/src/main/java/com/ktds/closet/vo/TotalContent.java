package com.ktds.closet.vo;

import java.sql.Timestamp;
import java.util.Arrays;

public class TotalContent {
	private String email;
	private int image_num;
	private String physical_name;
	private String image_name;
	private byte[] imagefile;
	private int favorite;
	private Timestamp image_date;
	private String imgbtnVal;
	private int article_num;
	private int scrab_num;
	private String name;
	private String content;
	Timestamp article_date;
	private int category;
	private int scrabPrivate;
	private String articlebtnVal;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getImage_num() {
		return image_num;
	}

	public void setImage_num(int image_num) {
		this.image_num = image_num;
	}

	public String getPhysical_name() {
		return physical_name;
	}

	public void setPhysical_name(String physical_name) {
		this.physical_name = physical_name;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public byte[] getImagefile() {
		return imagefile;
	}

	public void setImagefile(byte[] imagefile) {
		this.imagefile = imagefile;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public Timestamp getImage_date() {
		return image_date;
	}

	public void setImage_date(Timestamp image_date) {
		this.image_date = image_date;
	}

	public String getImgbtnVal() {
		return imgbtnVal;
	}

	public void setImgbtnVal(String imgbtnVal) {
		this.imgbtnVal = imgbtnVal;
	}

	public int getArticle_num() {
		return article_num;
	}

	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}

	public int getScrab_num() {
		return scrab_num;
	}

	public void setScrab_num(int scrab_num) {
		this.scrab_num = scrab_num;
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

	public int getScrabPrivate() {
		return scrabPrivate;
	}

	public void setScrabPrivate(int scrabPrivate) {
		this.scrabPrivate = scrabPrivate;
	}

	public String getArticlebtnVal() {
		return articlebtnVal;
	}

	public void setArticlebtnVal(String articlebtnVal) {
		this.articlebtnVal = articlebtnVal;
	}

	@Override
	public String toString() {
		return "TotalContent [email=" + email + ", image_num=" + image_num + ", physical_name=" + physical_name
				+ ", image_name=" + image_name + ", imagefile=" + Arrays.toString(imagefile) + ", favorite=" + favorite
				+ ", image_date=" + image_date + ", imgbtnVal=" + imgbtnVal + ", article_num=" + article_num
				+ ", scrab_num=" + scrab_num + ", name=" + name + ", content=" + content + ", article_date="
				+ article_date + ", category=" + category + ", scrabPrivate=" + scrabPrivate + ", articlebtnVal="
				+ articlebtnVal + "]";
	}

}
