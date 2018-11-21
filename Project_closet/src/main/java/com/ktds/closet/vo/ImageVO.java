package com.ktds.closet.vo;

import java.sql.Timestamp;
import java.util.Arrays;

public class ImageVO {
	private String email;
	private String name;
	private int image_num;
	private String physical_name;
	private String image_name;
	private byte[] imagefile;
	private int favorite;
	private Timestamp image_date;
	private int article_num;
	private String btnVal;
	
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
	public Timestamp getImage_date() {
		return image_date;
	}
	public void setImage_date(Timestamp image_date) {
		this.image_date = image_date;
	}
	public int getArticle_num() {
		return article_num;
	}
	public void setArticle_num(int article_num) {
		this.article_num = article_num;
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
	public String getBtnVal() {
		return btnVal;
	}
	public void setBtnVal(String btnVal) {
		this.btnVal = btnVal;
	}
	@Override
	public String toString() {
		return "ImageVO [image_num=" + image_num + ", physical_name="
				+ physical_name + ", image_name=" + image_name + ", imagefile="
				+ Arrays.toString(imagefile) + ", favorite=" + favorite
				+ ", image_date=" + image_date + ", article_num=" + article_num
				+ "]";
	}
}
