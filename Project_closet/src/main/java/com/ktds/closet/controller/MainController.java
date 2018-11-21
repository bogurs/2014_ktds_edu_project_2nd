package com.ktds.closet.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.closet.service.EtcService;
import com.ktds.closet.service.MainService;
import com.ktds.closet.vo.ArticleImageVO;
import com.ktds.closet.vo.ArticleVO;
import com.ktds.closet.vo.FriendVO;
import com.ktds.closet.vo.ImageVO;
import com.ktds.closet.vo.ItemVO;
import com.ktds.closet.vo.JoinVO;
import com.ktds.closet.vo.SearchVO;

@Controller
public class MainController {
	@Autowired
	MainService mainService;
	@Autowired
	EtcService etcService;

	ModelAndView mav;

	// main_content에서 article에 해당하는 사진 하나만 뿌리는 RequestMapping
	@RequestMapping("/mainImageDown.main")
	public ModelAndView mainImageDown(HttpServletRequest req) {
		mav = new ModelAndView();
		int article_num = Integer.parseInt((req.getParameter("article_num")));
		int scrab_num = Integer.parseInt((req.getParameter("scrab_num")));
		ImageVO image = mainService.mainImageDown(article_num, scrab_num);
		mav.addObject("imagefile", image.getImagefile());
		mav.setViewName("downloadview");
		return mav;
	}

	// content_detail에서 article에 해당하는 사진 여러장을 뿌리는 RequestMapping
	@RequestMapping("/contentImageDown.main")
	public ModelAndView contentImageDown(@RequestParam int image_num) {
		mav = new ModelAndView();
		ImageVO image = mainService.contentImageDown(image_num);

		mav.addObject("imagefile", image.getImagefile());
		mav.setViewName("downloadview");
		return mav;
	}

	// 게시글 좋아요 처리를 위한 RequestMapping
	@RequestMapping("/likeArticle.main")
	public ModelAndView likeArticle(@RequestParam int article_num, String fdemail, String fdname,
			HttpServletRequest req) {
		mav = new ModelAndView();
		FriendVO friendVO = new FriendVO();
		String email = req.getSession().getAttribute("email").toString();
		String name = req.getSession().getAttribute("name").toString();
		boolean check = mainService.checkFavoriteArticle(article_num, email);

		// 좋아요 눌렀던 사람이 다시 누름 (좋아요 취소)
		if (check == true) {
			// favorite field에 -1 하고, 게시글 좋아요 한 사람들 목록에서 제거한다
			mainService.subtractFavoriteArticle(article_num);
			mainService.deletelikeArticle(article_num, email);
		} else {
			mainService.addFavoriteArticle(article_num);
			mainService.insertlikeArticle(article_num, email, name);
		}
		friendVO.setName((String) req.getSession().getAttribute("name"));
		friendVO.setFdname(req.getParameter("fdname"));
		friendVO.setEmail((String) req.getSession().getAttribute("email"));
		friendVO.setFdemail(req.getParameter("fdemail"));
		friendVO.setArticle_num(article_num);
		friendVO.setAction("글좋아요");
		etcService.addactionlog(friendVO);

		mav.addObject("like_num", mainService.selectlikeArticleNum(article_num));
		mav.addObject("check", check);
		mav.setViewName("JSON");

		return mav;
	}

	// 이미지 좋아요 처리를 위한 RequestMapping
	@RequestMapping("/likeImage.main")
	public ModelAndView likeImage(@RequestParam int image_num, String fdname, String fdemail, HttpServletRequest req,
			int article_num) {
		mav = new ModelAndView();
		FriendVO friendVO = new FriendVO();
		String email = req.getSession().getAttribute("email").toString();
		String name = req.getSession().getAttribute("name").toString();
		boolean check = mainService.checkFavoriteImage(image_num, email);

		// 좋아요 눌렀던 사람이 다시 누름 (좋아요 취소)
		if (check == true) {
			// favorite field에 -1 하고, 이미지 좋아요 한 사람들 목록에서 제거한다
			mainService.subtractFavoriteImage(image_num);
			mainService.deletelikeImage(image_num, email);
		} else {
			mainService.addFavoriteImage(image_num);
			mainService.insertlikeImage(image_num, email, name);
		}
		friendVO.setName((String) req.getSession().getAttribute("name"));
		friendVO.setFdname(req.getParameter("fdname"));
		friendVO.setEmail((String) req.getSession().getAttribute("email"));
		friendVO.setFdemail(req.getParameter("fdemail"));
		friendVO.setArticle_num(article_num);
		friendVO.setAction("사진좋아요");
		etcService.addactionlog(friendVO);

		mav.addObject("like_num", mainService.selectlikeImageNum(image_num));
		mav.addObject("imageList", mainService.getbestImages());
		mav.addObject("check", check);
		mav.setViewName("JSON");

		return mav;
	}

	// 글 좋아요를 누른 사람들을 보여주기 위한 RequestMapping
	@RequestMapping("/getArticleNames.main")
	public ModelAndView getArticleNames(@RequestParam int article_num) {
		mav = new ModelAndView();
		List<String> nameList = mainService.getArticleNames(article_num);

		mav.addObject("nameList", nameList);

		mav.setViewName("JSON");
		return mav;
	}

	// 이미지 좋아요를 누른 사람들을 보여주기 위한 RequestMapping
	@RequestMapping("/getImageNames.main")
	public ModelAndView getImageNames(@RequestParam int image_num) {
		mav = new ModelAndView();
		List<String> nameList = mainService.getImageNames(image_num);

		mav.addObject("nameList", nameList);

		mav.setViewName("JSON");
		return mav;
	}

	// 검색을 위한 RequestMapping
	@RequestMapping("/search.main")
	public ModelAndView search(@ModelAttribute SearchVO search, HttpServletRequest req) {
		mav = new ModelAndView();
		List<ArticleVO> articleList = new ArrayList<>();
		search.setEmail(req.getSession().getAttribute("email").toString());

		// 내용 검색
		if (search.getSearchOption().equals("1")) {
			articleList = mainService.searchContent(search);
		}
		// 작성자 검색
		else if (search.getSearchOption().equals("2")) {
			articleList = mainService.searchUser(search);
		}
		// 댓글 검색
		else if (search.getSearchOption().equals("3")) {
			List<Integer> articlenumList = new ArrayList<>();

			if (search.getSearchContent().length() == 0)
				articlenumList = mainService.searchComment2(search);
			else
				articlenumList = mainService.searchComment(search);

			Iterator<Integer> it = articlenumList.iterator();
			while (it.hasNext()) {
				int article_num = it.next();
				search.setArticle_num(article_num);
				if (mainService.searchArticle(search) != null)
					articleList.add(mainService.searchArticle(search));
			}
		}
		// 카테고리 검색
		else if (search.getSearchOption().equals("4")) {
			articleList = mainService.searchCategory(search);
		}
		// 태그 검색
		else if (search.getSearchOption().equals("5")) {
			articleList = mainService.searchTag(search);
		}
		// 성별 검색
		else if (search.getSearchOption().equals("6")) {
			articleList = mainService.searchGender(search);
		}
		// 연령대 검색
		else if (search.getSearchOption().equals("7")) {
			articleList = mainService.searchAge(search);
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
		mav.addObject("order", 0);
		mav.addObject("html", "최신순으로 보실 수 있습니다.");
		mav.addObject("id", req.getSession().getAttribute("email").toString());
		mav.addObject("imageList", mainService.getbestImages());
		mav.addObject("articleList", articleList);
		mav.addObject("search", search);

		mav.setViewName("main_content");
		return mav;
	}

	// 작성한 내용을 보여주기 위한 RequestMapping (jsp단에서 새창 띄워 보여줌)
	@RequestMapping("/content.main")
	public ModelAndView showContent(@RequestParam int article_num, int scrab_num, HttpServletRequest req) {
		mav = new ModelAndView();
		List<ImageVO> imageList;

		if (scrab_num != 0) {
			imageList = mainService.getImagenum(scrab_num);
		} else {
			imageList = mainService.getImagenum(article_num);
		}
		Iterator<ImageVO> it = imageList.iterator();
		while (it.hasNext()) {
			ImageVO ivo = it.next();
			boolean check = mainService.checkFavoriteImage(ivo.getImage_num(),
					req.getSession().getAttribute("email").toString());

			// 좋아요를 이전에 눌렀음
			if (check == true)
				// 좋아요 버튼 값
				ivo.setBtnVal("좋아요취소");
			else
				ivo.setBtnVal("좋아요");
		}

		// 스크랩 관련 기능
		if (scrab_num != 0) {
			mav.addObject("popupcontent", mainService.showContent(scrab_num)); // 스크랩한 게시글
			mav.addObject("id", mainService.showContent(scrab_num).getEmail());
			mav.addObject("brand", mainService.showItem(scrab_num));
		} else {
			mav.addObject("popupcontent", mainService.showContent(article_num));
			mav.addObject("id", mainService.showContent(article_num).getEmail());
			mav.addObject("brand", mainService.showItem(article_num));
		}

		mav.addObject("popupimageList", imageList);
		mav.addObject("sessionid", req.getSession().getAttribute("email"));

		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/closet.main")
	public ModelAndView closet(String email) {
		mav = new ModelAndView();
		int imagecount = mainService.getImageCount(email);
		int scrabcount = mainService.getScrabCount(email);
		int likecountArticle = mainService.getLikeCountArticle(email);
		int likecountImage = mainService.getLikeCountImage(email);
		int followingcount = mainService.getFollowingCount(email);
		int followercount = mainService.getFollowerCount(email);

		mav.addObject("myemail", email);
		mav.addObject("mywritecount", imagecount - scrabcount);
		mav.addObject("myimagecount", imagecount);
		mav.addObject("myscrabcount", scrabcount);
		mav.addObject("mylikecountArticle", likecountArticle);
		mav.addObject("mylikecountImage", likecountImage);
		mav.addObject("myfollowingcount", followingcount);
		mav.addObject("myfollowercount", followercount);
		mav.addObject("myArticleCount", mainService.myArticleCount(email));

		mav.setViewName("closet");
		return mav;
	}

	@RequestMapping("/mycloset.main")
	public ModelAndView mycloset(HttpServletRequest req) {
		mav = new ModelAndView();
		List<ArticleVO> articleList = mainService.showMyArticle(req.getSession().getAttribute("email").toString());
		mav.addObject("articleList", articleList);
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/myscrab.main")
	public ModelAndView scrab(@RequestParam String email, HttpServletRequest req) {
		mav = new ModelAndView();

		List<ArticleVO> articleList = mainService.showMyScrab(email);
		List<JoinVO> profile = etcService.profileview(email);

		mav.addObject("id", (String) req.getSession().getAttribute("email"));
		mav.addObject("articleList", articleList);
		mav.addObject("profile", profile);

		mav.setViewName("closetgo");
		return mav;
	}

	@RequestMapping("/mylikeArticle.main")
	public ModelAndView mylikeArticle(@RequestParam String email, HttpServletRequest req) {
		mav = new ModelAndView();
		List<ArticleVO> articleList = mainService.showMyLikeArticle(email);
		List<JoinVO> profile = etcService.profileview(email);

		mav.addObject("id", (String) req.getSession().getAttribute("email"));
		mav.addObject("articleList", articleList);
		mav.addObject("profile", profile);
		mav.setViewName("closetlikeArticle");
		return mav;
	}

	@RequestMapping("/mylikeImage.main")
	public ModelAndView mylikeImage(@RequestParam String email, HttpServletRequest req) {
		mav = new ModelAndView();
		List<ArticleImageVO> imageList = mainService.showMyLikeImage(email);
		List<JoinVO> profile = etcService.profileview(email);

		mav.addObject("id", (String) req.getSession().getAttribute("email"));
		mav.addObject("imageList", imageList);
		mav.addObject("profile", profile);
		mav.setViewName("closetlikeImage");
		return mav;
	}

	// 글쓰기 창을 보여주기 위한 RequestMapping
	@RequestMapping("/writeForm.main")
	public ModelAndView writeForm(HttpServletRequest req) {
		mav = new ModelAndView();
		mav.setViewName("writeForm");
		return mav;
	}

	// 글쓰기 창에서 브랜드명 추가 보여주기 위한 RequestMapping
	@RequestMapping("/addCategory.main")
	public ModelAndView addCategory(HttpServletRequest req) {
		mav = new ModelAndView();
		mav.setViewName("addCategory");
		return mav;
	}

	// 게시글과 이미지를 테이블에 넣기 위한 RequestMapping
	@RequestMapping("/contentwrite.main")
	@Transactional(readOnly = false)
	public ModelAndView writeArticle(@ModelAttribute ArticleVO articleVO, ItemVO itemVO, HttpServletRequest req,
			MultipartHttpServletRequest mreq) {
		mav = new ModelAndView();
		if (articleVO.getTag().equals("브랜드 명/ 코디 명/ 옷 종류 등을 적어주세요!(예: 스파브랜드, 캐쥬얼)"))
			articleVO.setTag("");
		if (articleVO.getGender() == 1 || articleVO.getGender() == 2) {
			if (itemVO.getJacket().equals("겉옷"))
				itemVO.setJacket("");
			if (itemVO.getTshirt().equals("상의"))
				itemVO.setTshirt("");
			if (itemVO.getPants().equals("하의"))
				itemVO.setPants("");
			if (itemVO.getSneakers().equals("신발"))
				itemVO.setSneakers("");
			if (itemVO.getSocks().equals("악세사리"))
				itemVO.setSocks("");
			itemVO.setDress("");
		} else {
			if (itemVO.getJacket().equals("겉옷"))
				itemVO.setJacket("");
			if (itemVO.getTshirt().equals("상의"))
				itemVO.setTshirt("");
			if (itemVO.getPants().equals("하의"))
				itemVO.setPants("");
			if (itemVO.getDress().equals("원피스"))
				itemVO.setDress("");
			if (itemVO.getSneakers().equals("신발"))
				itemVO.setSneakers("");
			if (itemVO.getSocks().equals("악세사리"))
				itemVO.setSocks("");
		}
		if (itemVO.getDress() == null && itemVO.getTshirt() == null && itemVO.getPants() == null
				&& itemVO.getJacket() == null && itemVO.getSneakers() == null && itemVO.getSocks() == null)
			mainService.writeArticle(mreq, req, articleVO);
		else
			mainService.writeArticle(mreq, req, articleVO, itemVO);
		mav.setViewName("redirect:/main_content.etc");
		return mav;
	}

	// 게시글과 첨부된 이미지, 댓글 삭제를 위한 RequestMapping
	@RequestMapping("/deleteArticle.main")
	public ModelAndView deleteArticle(@RequestParam int article_num, String email, HttpServletRequest req) {
		mav = new ModelAndView();

		mainService.deleteArticle(article_num);

		mav.setViewName("main_content");
		return mav;
	}

	// 내 옷장 좋아요 한 글보기에서 삭제하기 위한 RequestMapping
	@RequestMapping("/deletelikeArticle.main")
	public ModelAndView deletelikeArticle(@RequestParam int article_num, String email, HttpServletRequest req) {
		mav = new ModelAndView();

		mainService.deletelikeArticle(article_num, email);

		mav.setViewName("JSON");
		return mav;
	}

	// 내 옷장 좋아요 한 사진보기에서 삭제하기 위한 RequestMapping
	@RequestMapping("/deletelikeImage.main")
	public ModelAndView deletelikeImage(@RequestParam int image_num, String email, HttpServletRequest req) {
		mav = new ModelAndView();

		mainService.deletelikeImage(image_num, email);

		mav.setViewName("JSON");
		return mav;
	}

	// 댓글 보기를 위한 RequestMapping
	@RequestMapping("/commentRead.main")
	public ModelAndView showArticle(@RequestParam int article_num, HttpServletRequest req) {
		mav = new ModelAndView();

		mav.addObject("sessionemail", req.getSession().getAttribute("name").toString());
		mav.addObject("commentList", mainService.showComment(article_num));
		mav.setViewName("JSON");

		return mav;
	}

	// 댓글 쓰기를 위한 RequestMapping
	@RequestMapping("/commentWrite.main")
	public ModelAndView insertArticle(@RequestParam String comment_content, @RequestParam int article_num,
			HttpServletRequest req, String name, String email) {
		mav = new ModelAndView();
		FriendVO friendVO = new FriendVO();
		mainService.insertComment((String) req.getSession().getAttribute("email"), comment_content, article_num);
		friendVO.setName((String) req.getSession().getAttribute("name"));
		friendVO.setFdname(req.getParameter("name"));
		friendVO.setEmail((String) req.getSession().getAttribute("email"));
		friendVO.setFdemail(req.getParameter("email"));
		friendVO.setArticle_num(article_num);
		friendVO.setAction("댓글");
		etcService.addactionlog(friendVO);
		mav.setViewName("JSON");

		return mav;
	}

	// 댓글 삭제를 위한 RequestMapping
	@RequestMapping("/commentDelete.main")
	public ModelAndView commentDelete(@RequestParam int article_num, @RequestParam int comment_num,
			HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sessionemail", req.getSession().getAttribute("name").toString());
		mainService.deleteComment(article_num, comment_num);
		mav.setViewName("JSON");
		return mav;
	}

	@RequestMapping("/follow.main")
	public ModelAndView follow(HttpServletRequest req) {
		mav = new ModelAndView();
		mav.setViewName("follow");
		return mav;
	}

	@RequestMapping("/category.main")
	public ModelAndView category(HttpServletRequest req) {
		mav = new ModelAndView();
		List<Object> articleList;
		articleList = mainService.category(req.getSession().getAttribute("email").toString(),
				Integer.parseInt(req.getParameter("category")));
		mav.addObject("articleList", articleList);
		mav.setViewName("closet");
		return mav;
	}

	// 스크랩 글쓰기 폼(새창으로 띄워준다)
	@RequestMapping("/scrab_writeForm.main")
	public ModelAndView scrab_writeForm(@RequestParam int article_num, int scrab_num) {
		mav = new ModelAndView();
		// 스크랩 관련 기능
		if (scrab_num != 0) {
			mav.addObject("imageList", mainService.getImagenum(scrab_num));
			mav.addObject("content", mainService.showContent(scrab_num));
		} else {
			mav.addObject("imageList", mainService.getImagenum(article_num));
			mav.addObject("content", mainService.showContent(article_num));
		}
		mav.setViewName("scrab_writeForm");
		return mav;
	}

	// 스크랩 article에 입력(script로 값 넘기고 db에 저장)
	@RequestMapping("/scrabInput.main")
	public ModelAndView scrabInput(@ModelAttribute ArticleVO articleVO) {
		mav = new ModelAndView();
		if (articleVO.getTag().equals("브랜드 명/ 코디 명/ 옷 종류 등을 적어주세요!(예: 스파브랜드, 캐쥬얼)"))
			articleVO.setTag("");
		mainService.scrabInput(articleVO);
		mav.setViewName("redirect:/main_content.etc");
		return mav;
	}

	// 자동 추천 글 main화면 view controller
	@RequestMapping("recommend.main")
	public ModelAndView recommend(HttpServletRequest req) {
		int article_num = mainService.getLatestArticleNum(req.getParameter("email"));
		mav.addObject("tagReqCount", mainService.getTagRecommendCount(article_num, req.getParameter("email")));
		mav.addObject("brandReqCount", mainService.brandReqCount(article_num, req.getParameter("email")));
		mav.addObject("myArticleCount", mainService.myArticleCount(req.getParameter("email")));

		mav.setViewName("recommend");
		return mav;
	}

	@RequestMapping("tagReq.main")
	public ModelAndView tagReq(@RequestParam String email, HttpServletRequest req) {
		int article_num = mainService.getLatestArticleNum(email);
		List<ArticleVO> tagList = mainService.getTagRecommend(article_num, email);
		mav = new ModelAndView();
//		Iterator it = tagList.iterator();
//		while (it.hasNext()) {
//			ArticleVO avo = (ArticleVO) it.next();
//			boolean check = mainService.checkFavoriteImage(
//					avo.getArticle_num(), req.getSession()
//							.getAttribute("email").toString());
//			// 좋아요를 이전에 눌렀음
//			if (check == true)
//				// 좋아요 버튼 값
//				avo.setBtnVal("좋아요취소");
//			else
//				avo.setBtnVal("좋아요");
//		}
		mav.addObject("tagList", tagList);
		mav.setViewName("tagReq");
		return mav;
	}

	@RequestMapping("brandReq.main")
	public ModelAndView brandReq(@RequestParam String email, HttpServletRequest req) {
		int article_num = mainService.getLatestArticleNum(email);
		List<ArticleVO> brandList = mainService.getrecommendarticle(article_num, email);
//		int tab = Integer.parseInt(req.getParameter("tab"));
		mav = new ModelAndView();
//		Iterator it = brandList.iterator();
//		while (it.hasNext()) {
//			ArticleVO avo = (ArticleVO) it.next();
//			boolean check = mainService.checkFavoriteImage(
//					avo.getArticle_num(), req.getSession()
//							.getAttribute("email").toString());
//			// 좋아요를 이전에 눌렀음
//			if (check == true)
//				// 좋아요 버튼 값
//				avo.setBtnVal("좋아요취소");
//			else
//				avo.setBtnVal("좋아요");
//		}
		mav.addObject("brandList", brandList);
		mav.setViewName("brandReq");
		return mav;
	}
}
