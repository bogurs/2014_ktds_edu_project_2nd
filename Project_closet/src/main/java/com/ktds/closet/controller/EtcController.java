package com.ktds.closet.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.closet.service.EtcService;
import com.ktds.closet.service.MainService;
import com.ktds.closet.vo.ArticleVO;
import com.ktds.closet.vo.FriendVO;
import com.ktds.closet.vo.ImageVO;
import com.ktds.closet.vo.JoinVO;
import com.ktds.closet.vo.SearchVO;
import com.ktds.closet.vo.TagVO;

@Controller
public class EtcController {
	@Autowired
	EtcService etcService;
	@Autowired
	MainService mainService;

	ModelAndView mav;
	List<JoinVO> profile;
	int count = 0;

	@RequestMapping("/main.etc")
	public ModelAndView main() {
		mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}

	@RequestMapping("/join.etc")
	public ModelAndView join(@ModelAttribute JoinVO joinVO, HttpServletRequest req) {
		boolean result = etcService.join(joinVO);

		HttpSession hs = req.getSession();
		hs.setAttribute("email", joinVO.getEmail());
		hs.setAttribute("name", joinVO.getName());

		mav.addObject("result", result);
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/main_content.etc")
	public ModelAndView main_content(HttpServletRequest req) {

		List<ArticleVO> articleList = mainService.showArticle(req.getSession().getAttribute("email").toString());

		Iterator<ArticleVO> it = articleList.iterator();

		// 좋아요 버튼값 설정을 위한 처리
		while (it.hasNext()) {
			ArticleVO avo = it.next();
			boolean check = mainService.checkFavoriteArticle(avo.getArticle_num(),
					req.getSession().getAttribute("email").toString());

			// 좋아요를 이전에 눌렀음
			if (check == true)
				// 좋아요 버튼 값
				avo.setBtnVal("좋아요 취소");
			else
				avo.setBtnVal("좋아요");
		}

		mav.addObject("order", 0);
		mav.addObject("html", "최신순으로 보실 수 있습니다.");
		mav.addObject("id", req.getSession().getAttribute("email").toString());
		mav.addObject("myArticleCount", mainService.myArticleCount(req.getSession().getAttribute("email").toString()));
		mav.addObject("imageList", mainService.getbestImages());
		mav.addObject("articleList", articleList);

		mav.setViewName("main_content");
		return mav;
	}

	@RequestMapping("/searchOrderbyHot.etc")
	public ModelAndView searchOrderbyHot(@ModelAttribute SearchVO search, HttpServletRequest req) {

		List<ArticleVO> articleList = new ArrayList<>();
		search.setEmail(req.getSession().getAttribute("email").toString());

		// 내용 검색
		if (search.getSearchOption().equals("1")) {
			articleList = mainService.searchContentOrderbyHot(search);
		}
		// 작성자 검색
		else if (search.getSearchOption().equals("2")) {
			articleList = mainService.searchUserOrderbyHot(search);
		}
		// 댓글 검색
		else if (search.getSearchOption().equals("3")) {
			List<Integer> articlenumList = new ArrayList<>();

			if (search.getSearchContent().length() == 0)
				articlenumList = mainService.searchComment2OrderbyHot(search);
			else
				articlenumList = mainService.searchCommentOrderbyHot(search);

			Iterator<Integer> it = articlenumList.iterator();
			while (it.hasNext()) {
				int article_num = it.next();
				search.setArticle_num(article_num);
				if (mainService.searchArticleOrderbyHot(search) != null)
					articleList.add(mainService.searchArticleOrderbyHot(search));
			}
		}
		// 카테고리 검색
		else if (search.getSearchOption().equals("4")) {
			articleList = mainService.searchCategoryOrderbyHot(search);
		}
		// 태그 검색
		else if (search.getSearchOption().equals("5")) {
			articleList = mainService.searchTagOrderbyHot(search);
		}
		// 성별 검색
		else if (search.getSearchOption().equals("6")) {
			articleList = mainService.searchGenderOrderbyHot(search);
		}
		// 연령대 검색
		else if (search.getSearchOption().equals("7")) {
			articleList = mainService.searchAgeOrderbyHot(search);
		}

		Iterator<ArticleVO> it2 = articleList.iterator();

		// 좋아요 버튼값 설정을 위한 처리
		while (it2.hasNext()) {
			ArticleVO avo = it2.next();
			boolean check = mainService.checkFavoriteArticle(avo.getArticle_num(),
					req.getSession().getAttribute("email").toString());

			// 좋아요를 이전에 눌렀음
			if (check == true)
				// 좋아요 버튼 값
				avo.setBtnVal("좋아요 취소");
			else
				avo.setBtnVal("좋아요");
		}

		mav.addObject("order", 1);
		mav.addObject("html", "인기순으로 보실 수 있습니다.");
		mav.addObject("id", req.getSession().getAttribute("email").toString());
		mav.addObject("imageList", mainService.getbestImages());
		mav.addObject("articleList", articleList);
		mav.addObject("search", search);

		mav.setViewName("main_content");
		return mav;
	}

	@RequestMapping("/logout.etc")
	public ModelAndView logout(HttpServletRequest req) {
		mav = new ModelAndView();
		HttpSession hs = req.getSession();
		hs.invalidate();

		mav.setViewName("redirect:/main.etc");
		return mav;
	}

	@RequestMapping("/login.etc")
	public ModelAndView login(HttpServletRequest req) {
		mav = new ModelAndView();
		if (req.getParameter("email").equals("")) {
			mav.addObject("login_error", 1);
			mav.setViewName("JSON");
			return mav;
		} else if (req.getParameter("pass").equals("")) {
			mav.addObject("login_error", 2);
			mav.setViewName("JSON");
			return mav;
		} else {
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			int status = etcService.login_check(email, pass);
			String name = etcService.getNamebyEmail(email);
			if (status == 1) {
				HttpSession hs = req.getSession();
				hs.setAttribute("email", email);
				hs.setAttribute("name", name);
				mav.setViewName("JSON");
				return mav;
			} else if (status == 2) {
				mav.addObject("login_error", 3);
				mav.setViewName("JSON");
				return mav;
			} else {
				mav.addObject("login_error", 4);
				mav.setViewName("JSON");
				return mav;
			}
		}
	}

	@RequestMapping("/weatherStyleRead.etc") // 날씨 코디 추천에 전체 글 띄우기
	public ModelAndView weatherStyleRead(HttpServletRequest req) {
		mav = new ModelAndView();
		mav.addObject("weatherStyleReadList", etcService.weatherStyleReadList());
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/keyword.etc")
	public ModelAndView keyword() {
		List<TagVO> keyword;
		mav = new ModelAndView();
		keyword = etcService.keyword();
		mav.addObject("keyword", keyword);
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/searchid.etc")
	public ModelAndView searchid(HttpServletRequest req) {
		List<TagVO> searchid;
		mav = new ModelAndView();
		String name;
		name = req.getParameter("keyword");
		searchid = etcService.searchid(name);
		mav.addObject("searchid", searchid);
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/searchfriend.etc")
	public ModelAndView searchfriend(HttpServletRequest req) {
		List<FriendVO> searchid;
		String email = "a";
		mav = new ModelAndView();
		searchid = etcService.friendlist(email);
		mav.addObject("searchid", searchid);

		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/fdmanageview.etc")
	public ModelAndView fdmanageview(HttpServletRequest req) {
		mav = new ModelAndView();
		List<FriendVO> friendList;
		String myemail = (String) req.getSession().getAttribute("email");
		friendList = etcService.fdmanageview(myemail);
		mav.addObject("friendList", friendList);
		mav.setViewName("fdmanageview");
		return mav;
	}

	@RequestMapping("deletefollow.etc")
	public String deletefollow(String fdemail, HttpServletRequest req) {
//			etcService.deletefriend(req.getParameter("seqno"));			
		String myemail;
		myemail = (String) req.getSession().getAttribute("email");
		etcService.deletefollow(myemail, fdemail);
		return "redirect:/closet.main?email=" + fdemail;

	}

	@RequestMapping("addfollow.etc")
	public String addfriend(HttpServletRequest req) {
		mav = new ModelAndView();
		FriendVO friendVO = new FriendVO();
		friendVO.setName((String) req.getSession().getAttribute("name"));
		friendVO.setEmail((String) req.getSession().getAttribute("email"));
		friendVO.setFdemail(req.getParameter("fdemail"));
		friendVO.setFdname(req.getParameter("fdname"));
		friendVO.setAction("팔로우");
		etcService.addfollow(friendVO);
		etcService.addactionlog(friendVO);
		return "redirect:/closet.main?email=" + req.getParameter("fdemail");

	}

	@RequestMapping("follow.etc")
	public ModelAndView friendlist(String email, HttpServletRequest req) {
		mav = new ModelAndView();
		List<FriendVO> friendList = etcService.friendlist(email);
		List<JoinVO> profile = etcService.profileview(email);

		mav.addObject("id", (String) req.getSession().getAttribute("email"));
		mav.addObject("friendList", friendList);
		mav.addObject("profile", profile);

		mav.setViewName("followinglist");
		return mav;
	}

	@RequestMapping("follower.etc")
	public ModelAndView followerlist(String email, HttpServletRequest req) {
		mav = new ModelAndView();
		List<FriendVO> followerList = etcService.followerlist(email);
		List<JoinVO> profile = etcService.profileview(email);

		mav.addObject("id", (String) req.getSession().getAttribute("email"));
		mav.addObject("followerList", followerList);
		mav.addObject("profile", profile);

		mav.setViewName("followerlist");
		return mav;
	}

	@RequestMapping("profileview.etc")
	public ModelAndView profileview(String email, HttpServletRequest req) {
		List<JoinVO> profile;
		mav = new ModelAndView();
		profile = etcService.profileview(email);
		mav.addObject("profile", profile);
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("weatherInform.etc")
	public ModelAndView test_weather(HttpServletRequest req) {
		mav = new ModelAndView();
		mav.setViewName("weatherInform");
		return mav;
	}

	@RequestMapping("updateprofileview.etc")
	public ModelAndView updateprofileview(HttpServletRequest req) {
		mav = new ModelAndView();
		List<JoinVO> profile;
		profile = etcService.profileview((String) req.getSession().getAttribute("email"));
		mav.addObject("profile", profile);
		mav.setViewName("updateprofileview");
		return mav;
	}

	@RequestMapping("updateprofile.etc")
	public String updateprofile(HttpServletRequest req, MultipartHttpServletRequest mreq, String cm, String kg,
			String status) {
		mav = new ModelAndView();
		String myemail = (String) req.getSession().getAttribute("email");

		etcService.updateprofile(mreq, req, cm, kg, status);
		return "redirect:/closet.main?email=" + myemail;

	}

	@RequestMapping("/profileImageDown.etc")
	public ModelAndView profileImageDown(String email, HttpServletRequest req) {
		mav = new ModelAndView();
		ImageVO image = etcService.profileImageDown(email);
		if (image == null)
			image = etcService.profileImageDown("manager@manager.com");
		mav.addObject("imagefile", image.getImagefile());
		mav.setViewName("downloadview");
		return mav;
	}

	@RequestMapping("closetgil.etc")
	public ModelAndView closet(String email, HttpServletRequest req) {
		mav = new ModelAndView();
		String fdemail;
		int statusnum = 0;
		FriendVO friendVO = new FriendVO();
		List<ArticleVO> articleList = mainService.showMyArticle(email);
		profile = etcService.profileview(email);
		String myemail = (String) req.getSession().getAttribute("email");
		friendVO.setEmail(myemail);
		friendVO.setFdemail(email);

		if (!myemail.equals(email)) {
			fdemail = etcService.searchfollow(friendVO);
			if (fdemail == null)
				fdemail = "";
			if (fdemail.equals(email))
				statusnum = 1;
			else
				statusnum = 2;
			mav.addObject("statusnum", statusnum);
		}

		mav.addObject("id", myemail);
		mav.addObject("articleList", articleList);
		mav.addObject("profile", profile);
//			
		mav.setViewName("closetgo");
		return mav;
	}

	@RequestMapping("test.etc")
	public ModelAndView test(HttpServletRequest req) {
		mav = new ModelAndView();
		List<FriendVO> action;
		action = etcService.actionlogview((String) req.getSession().getAttribute("email"));
		mav.addObject("action", action);
		mav.setViewName("test");
		return mav;
	}

	@RequestMapping("test2.etc")
	public ModelAndView test2(HttpServletRequest req) {
		mav = new ModelAndView();
		mav.setViewName("giltest");
		return mav;
	}

	@RequestMapping("/searchId.etc")
	public ModelAndView searchId(String email) {
		mav = new ModelAndView();
		mav.addObject("status", etcService.searchId(email));
		mav.setViewName("JSON");
		return mav;
	}

}