package com.ktds.closet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ktds.closet.vo.FriendVO;
import com.ktds.closet.vo.ImageVO;
import com.ktds.closet.vo.JoinVO;
import com.ktds.closet.vo.TagVO;
import com.ktds.closet.vo.WeatherVO;

public interface EtcService {
	// join
	public boolean join(JoinVO joinVO);

	// login
	public int login_check(String email, String pass);

	// getNamebyEmail
	public String getNamebyEmail(String email);

	// weatherStyle
	public List<WeatherVO> weatherStyleReadList();

	public void weatherStyleWrite(WeatherVO weatherVO);

	public List<TagVO> keyword();

	public List<TagVO> searchid(String name);

	public List<FriendVO> fdmanageview(String myemail);

	public void addfollow(FriendVO friendVO);

	public List<FriendVO> friendlist(String email);

	public List<FriendVO> searchfriend(String name);

	public List<JoinVO> profileview(String email);

	public void updateprofile(MultipartHttpServletRequest mreq, HttpServletRequest req, String cm, String kg,
			String status);

	public ImageVO profileImageDown(String email);

	public void deletefollow(String myemail, String fdemail);

	public List<FriendVO> followerlist(String email);

	public void addactionlog(FriendVO friendVO);

	public List<FriendVO> actionlogview(String email);

	public int searchId(String id);

	public String searchfollow(FriendVO friend);
}
