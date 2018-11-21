package com.ktds.closet.vo;

public class SearchVO {
	private String email;
	private int article_num;
	private String searchOption;
	private String searchContent;
	private String searchCategory;
	private String searchGender;
	private int searchAge;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getArticle_num() {
		return article_num;
	}

	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public String getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	public String getSearchGender() {
		return searchGender;
	}

	public void setSearchGender(String searchGender) {
		this.searchGender = searchGender;
	}

	public int getSearchAge() {
		return searchAge;
	}

	public void setSearchAge(int searchAge) {
		this.searchAge = searchAge;
	}

	@Override
	public String toString() {
		return "SearchVO [email=" + email + ", article_num=" + article_num + ", searchOption=" + searchOption
				+ ", searchContent=" + searchContent + ", searchCategory=" + searchCategory + ", searchGender="
				+ searchGender + ", searchAge=" + searchAge + "]";
	}

}
