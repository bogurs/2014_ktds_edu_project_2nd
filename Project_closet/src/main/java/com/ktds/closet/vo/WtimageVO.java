package com.ktds.closet.vo;

import java.sql.Timestamp;
import java.util.Arrays;

public class WtimageVO {
	private String email;
	private int wtimage_num;
	private String wtphysical_name;
	private String wtimage_name;
	private byte[] wtimagefile;
	private int wtfavorite;
	private Timestamp wtimage_date;
	private int article_num;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getWtimage_num() {
		return wtimage_num;
	}

	public void setWtimage_num(int wtimage_num) {
		this.wtimage_num = wtimage_num;
	}

	public String getWtphysical_name() {
		return wtphysical_name;
	}

	public void setWtphysical_name(String wtphysical_name) {
		this.wtphysical_name = wtphysical_name;
	}

	public String getWtimage_name() {
		return wtimage_name;
	}

	public void setWtimage_name(String wtimage_name) {
		this.wtimage_name = wtimage_name;
	}

	public byte[] getWtimagefile() {
		return wtimagefile;
	}

	public void setWtimagefile(byte[] wtimagefile) {
		this.wtimagefile = wtimagefile;
	}

	public int getWtfavorite() {
		return wtfavorite;
	}

	public void setWtfavorite(int wtfavorite) {
		this.wtfavorite = wtfavorite;
	}

	public Timestamp getWtimage_date() {
		return wtimage_date;
	}

	public void setWtimage_date(Timestamp wtimage_date) {
		this.wtimage_date = wtimage_date;
	}

	public int getArticle_num() {
		return article_num;
	}

	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}

	@Override
	public String toString() {
		return "WtimageVO [email=" + email + ", wtimage_num=" + wtimage_num + ", wtphysical_name=" + wtphysical_name
				+ ", wtimage_name=" + wtimage_name + ", wtimagefile=" + Arrays.toString(wtimagefile) + ", wtfavorite="
				+ wtfavorite + ", wtimage_date=" + wtimage_date + ", article_num=" + article_num + "]";
	}

}
