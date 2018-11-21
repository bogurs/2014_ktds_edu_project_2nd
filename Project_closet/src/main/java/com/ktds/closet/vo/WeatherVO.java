package com.ktds.closet.vo;

import java.sql.Timestamp;

public class WeatherVO {
	private int weather_num;
	private String content;
	private String email;
	private String name;
	private Timestamp write_date;

	public int getWeather_num() {
		return weather_num;
	}

	public void setWeather_num(int weather_num) {
		this.weather_num = weather_num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Timestamp getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}

	@Override
	public String toString() {
		return "WeatherVO [weather_num=" + weather_num + ", content=" + content + ", email=" + email + ", name=" + name
				+ ", write_date=" + write_date + "]";
	}

}
