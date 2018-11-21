package com.ktds.closet.vo;

public class ItemVO {
	private int article_num;
	private String jacket;
	private String tshirt;
	private String pants;
	private String sneakers;
	private String dress;
	private String socks;

	public int getArticle_num() {
		return article_num;
	}

	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}

	public String getJacket() {
		return jacket;
	}

	public void setJacket(String jacket) {
		this.jacket = jacket;
	}

	public String getTshirt() {
		return tshirt;
	}

	public void setTshirt(String tshirt) {
		this.tshirt = tshirt;
	}

	public String getPants() {
		return pants;
	}

	public void setPants(String pants) {
		this.pants = pants;
	}

	public String getSneakers() {
		return sneakers;
	}

	public void setSneakers(String sneakers) {
		this.sneakers = sneakers;
	}

	public String getDress() {
		return dress;
	}

	public void setDress(String dress) {
		this.dress = dress;
	}

	public String getSocks() {
		return socks;
	}

	public void setSocks(String socks) {
		this.socks = socks;
	}

	@Override
	public String toString() {
		return "ItemVO [article_num=" + article_num + ", jacket=" + jacket + ", tshirt=" + tshirt + ", pants=" + pants
				+ ", sneakers=" + sneakers + ", dress=" + dress + ", socks=" + socks + "]";
	}

}