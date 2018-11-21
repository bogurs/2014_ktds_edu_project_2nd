package com.ktds.closet.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ktds.closet.dao.MainDao;
import com.ktds.closet.vo.ArticleImageVO;
import com.ktds.closet.vo.ArticleVO;
import com.ktds.closet.vo.CommentVO;
import com.ktds.closet.vo.ImageVO;
import com.ktds.closet.vo.ItemVO;
import com.ktds.closet.vo.SearchVO;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDao maindao;

	// 메인 대표이미지 갖고 오는 메소드
	public ImageVO mainImageDown(int article_num, int scrab_num) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("article_num", article_num);
		hm.put("scrab_num", scrab_num);
		return maindao.mainImageDown(hm);
	}

	// 컨텐츠에서 사진을 가져오는 메소드
	public ImageVO contentImageDown(int image_num) {
		return maindao.contentImageDown(image_num);
	}

	@Override
	public int getCommentCount(int article_num) {
		return maindao.getCommentCount(article_num);
	}

	@Override
	public int getImageCount(String email) {
		return maindao.getImageCount(email);
	}

	@Override
	public int getScrabCount(String email) {
		return maindao.getScrabCount(email);
	}

	@Override
	public int getLikeCountArticle(String email) {
		return maindao.getLikeCountArticle(email);
	}

	@Override
	public int getLikeCountImage(String email) {
		return maindao.getLikeCountImage(email);
	}

	@Override
	public int getFollowingCount(String email) {
		return maindao.getFollowingCount(email);
	}

	@Override
	public int getFollowerCount(String email) {
		return maindao.getFollowerCount(email);
	}

	@Override
	public int getTagRecommendCount(int article_num, String email) {
		String tag = maindao.getTagInArticleTable(article_num);
		HashMap<String, Object> hm;
		if (tag == null)
			return 0;
		else {
			hm = new HashMap<>();
			hm.put("email", email);
			hm.put("tag", tag);
			return maindao.getTagRecommendCount(hm);
		}
	}

	@Override
	public int brandReqCount(int article_num, String email) {
		ItemVO itemVO;
		int gender;
		HashMap<String, Object> hm;

		itemVO = maindao.getbrand(article_num);
		gender = maindao.getGenderByArticleNum(article_num);

		if (itemVO.getDress() == null && itemVO.getTshirt() == null && itemVO.getPants() == null
				&& itemVO.getJacket() == null && itemVO.getSneakers() == null && itemVO.getSocks() == null)
			return 0;
		else {
			if (gender == 1 || gender == 2) {
				if (itemVO.getJacket() == null)
					itemVO.setJacket("");
				if (itemVO.getTshirt() == null)
					itemVO.setTshirt("");
				if (itemVO.getPants() == null)
					itemVO.setPants("");
				if (itemVO.getSneakers() == null)
					itemVO.setSneakers("");
				if (itemVO.getSocks() == null)
					itemVO.setSocks("");
				itemVO.setDress("");
			} else {
				if (itemVO.getJacket() == null)
					itemVO.setJacket("");
				if (itemVO.getTshirt() == null)
					itemVO.setTshirt("");
				if (itemVO.getPants() == null)
					itemVO.setPants("");
				if (itemVO.getDress() == null)
					itemVO.setDress("");
				if (itemVO.getSneakers() == null)
					itemVO.setSneakers("");
				if (itemVO.getSocks() == null)
					itemVO.setSocks("");
			}
			hm = new HashMap<>();
			hm.put("email", email);
			hm.put("jacket", itemVO.getJacket());
			hm.put("tshirt", itemVO.getTshirt());
			hm.put("pants", itemVO.getPants());
			hm.put("dress", itemVO.getDress());
			hm.put("sneakers", itemVO.getSneakers());
			hm.put("socks", itemVO.getSocks());
			return maindao.brandReqCount(hm);
		}
	}

	@Override
	public int myArticleCount(String email) {
		return maindao.myArticleCount(email);
	}

	@Override
	public List<ImageVO> getImagenum(int article_num) {
		return maindao.getImagenum(article_num);
	}

	@Override
	public Boolean checkFavoriteArticle(int article_num, String email) {
		List<String> emailList = maindao.checkFavoriteArticle(article_num);
		Iterator<String> it = emailList.iterator();
		while (it.hasNext()) {
			String temp = it.next().toString();
			if (temp.equals(email))
				return true;
		}
		return false;
	}

	@Override
	public Boolean checkFavoriteImage(int image_num, String email) {
		List<String> emailList = maindao.checkFavoriteImage(image_num);
		Iterator<String> it = emailList.iterator();
		while (it.hasNext()) {
			String temp = it.next().toString();
			if (temp.equals(email))
				return true;
		}
		return false;
	}

	@Override
	public void addFavoriteArticle(int article_num) {
		maindao.addFavoriteArticle(article_num);
	}

	@Override
	public void subtractFavoriteArticle(int article_num) {
		maindao.subtractFavoriteArticle(article_num);
	}

	@Override
	public void addFavoriteImage(int image_num) {
		maindao.addFavoriteImage(image_num);
	}

	@Override
	public void subtractFavoriteImage(int image_num) {
		maindao.subtractFavoriteImage(image_num);
	}

	@Override
	public void insertlikeArticle(int article_num, String email, String name) {
		ArticleVO article = new ArticleVO();
		article.setArticle_num(article_num);
		article.setEmail(email);
		article.setName(name);

		maindao.insertlikeArticle(article);
	}

	@Override
	public void deletelikeArticle(int article_num, String email) {
		ArticleVO article = new ArticleVO();
		article.setArticle_num(article_num);
		article.setEmail(email);

		maindao.deletelikeArticle(article);
	}

	@Override
	public int selectlikeArticleNum(int article_num) {
		return maindao.selectlikeArticleNum(article_num);
	}

	@Override
	public void insertlikeImage(int image_num, String email, String name) {
		ImageVO image = new ImageVO();
		image.setImage_num(image_num);
		image.setEmail(email);
		image.setName(name);

		maindao.insertlikeImage(image);
	}

	@Override
	public void deletelikeImage(int image_num, String email) {
		ImageVO image = new ImageVO();
		image.setImage_num(image_num);
		image.setEmail(email);

		maindao.deletelikeImage(image);
	}

	@Override
	public int selectlikeImageNum(int image_num) {

		return maindao.selectlikeImageNum(image_num);
	}

	@Override
	public List<String> getArticleNames(int article_num) {
		List<String> emailList = maindao.getArticleEmails(article_num);
		List<String> nameList = new ArrayList<>();
		Iterator<String> it = emailList.iterator();

		while (it.hasNext()) {
			String email = it.next().toString();
			String name = maindao.getName(email);
			nameList.add(name);
		}
		return nameList;
	}

	@Override
	public List<String> getImageNames(int image_num) {
		List<String> emailList = maindao.getImageEmails(image_num);
		List<String> nameList = new ArrayList<>();
		Iterator<String> it = emailList.iterator();

		while (it.hasNext()) {
			String email = it.next().toString();
			String name = maindao.getName(email);
			nameList.add(name);
		}
		return nameList;
	}

	@Override
	public List<ArticleVO> showMyArticle(String email) {
		return maindao.showMyArticle(email);
	}

	@Override
	public List<ArticleVO> showMyScrab(String email) {
		return maindao.showMyScrab(email);
	}

	@Override
	public List<ArticleVO> showMyLikeArticle(String email) {
		return maindao.showMyLikeArticle(email);
	}

	@Override
	public List<ArticleImageVO> showMyLikeImage(String email) {
		return maindao.showMyLikeImage(email);
	}

	@Override
	public List<ArticleVO> showArticle(String email) {
		return maindao.showArticle(email);
	}

	@Override
	public ArticleVO showContent(int article_num) {
		return maindao.showContent(article_num);
	}

	@Override
	public ItemVO showItem(int article_num) {
		return maindao.showItem(article_num);
	}

	@Override
	public void writeArticle(MultipartHttpServletRequest mreq, HttpServletRequest req, ArticleVO articleVO,
			ItemVO itemVO) {
		articleVO.setEmail(req.getSession().getAttribute("email").toString());
		articleVO.setName(req.getSession().getAttribute("name").toString());
		maindao.writeArticle(articleVO);

		itemVO.setArticle_num(articleVO.getArticle_num());
		maindao.insertBrand(itemVO);

		List<MultipartFile> filelist = mreq.getFiles("file");
		Iterator<MultipartFile> it = filelist.iterator();
		while (it.hasNext()) {
			MultipartFile mFile = it.next();
			String image_name = mFile.getOriginalFilename();
			String physical_name = image_name + "_" + System.currentTimeMillis();
			byte[] imagefile = null;
			try {
				imagefile = new byte[(int) mFile.getSize()];
				imagefile = mFile.getBytes();
				ImageVO image = new ImageVO();
				image.setImage_name(image_name);
				image.setImagefile(imagefile);
				image.setPhysical_name(physical_name);
				image.setArticle_num(articleVO.getArticle_num());
				maindao.InsertImage(image);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void writeArticle(MultipartHttpServletRequest mreq, HttpServletRequest req, ArticleVO articleVO) {
		articleVO.setEmail(req.getSession().getAttribute("email").toString());
		articleVO.setName(req.getSession().getAttribute("name").toString());
		maindao.writeArticle(articleVO);

		List<MultipartFile> filelist = mreq.getFiles("file");
		Iterator<MultipartFile> it = filelist.iterator();
		while (it.hasNext()) {
			MultipartFile mFile = it.next();
			String image_name = mFile.getOriginalFilename();
			String physical_name = image_name + "_" + System.currentTimeMillis();
			byte[] imagefile = null;
			try {
				imagefile = new byte[(int) mFile.getSize()];
				imagefile = mFile.getBytes();
				ImageVO image = new ImageVO();
				image.setImage_name(image_name);
				image.setImagefile(imagefile);
				image.setPhysical_name(physical_name);
				maindao.InsertImage(image);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteArticle(int article_num) {
		maindao.deleteArticle(article_num);
	}

	@Override
	public List<CommentVO> showComment(int article_num) {
		return maindao.showComment(article_num);
	}

	@Override
	public void insertComment(String email, String comment_content, int article_num) {
		CommentVO cvo = new CommentVO();
		cvo.setEmail(email);
		cvo.setComment_content(comment_content);
		cvo.setArticle_num(article_num);

		maindao.insertComment(cvo);
	}

	@Override
	public void deleteComment(int article_num, int comment_num) {
		maindao.deleteComment(comment_num);
	}

	@Override
	public List<ImageVO> getbestImages() {
		return maindao.getbestImages();
	}

	@Override
	public List<ArticleVO> searchContent(SearchVO search) {
		return maindao.searchContent(search);
	}

	@Override
	public List<ArticleVO> searchUser(SearchVO search) {
		return maindao.searchUser(search);
	}

	@Override
	public List<Integer> searchComment(SearchVO search) {
		return maindao.searchComment(search);
	}

	@Override
	public List<Integer> searchComment2(SearchVO search) {
		return maindao.searchComment2(search);
	}

	@Override
	public List<ArticleVO> searchCategory(SearchVO search) {
		return maindao.searchCategory(search);
	}

	@Override
	public List<ArticleVO> searchTag(SearchVO search) {
		return maindao.searchTag(search);
	}

	@Override
	public List<ArticleVO> searchGender(SearchVO search) {
		return maindao.searchGender(search);
	}

	@Override
	public List<ArticleVO> searchAge(SearchVO search) {
		return maindao.searchAge(search);
	}

	@Override
	public ArticleVO searchArticle(SearchVO search) {
		return maindao.searchArticle(search);
	}

	@Override
	public List<ArticleVO> searchContentOrderbyHot(SearchVO search) {
		return maindao.searchContentOrderbyHot(search);
	}

	@Override
	public List<ArticleVO> searchUserOrderbyHot(SearchVO search) {
		return maindao.searchUserOrderbyHot(search);
	}

	@Override
	public List<Integer> searchCommentOrderbyHot(SearchVO search) {
		return maindao.searchCommentOrderbyHot(search);
	}

	@Override
	public List<Integer> searchComment2OrderbyHot(SearchVO search) {
		return maindao.searchComment2OrderbyHot(search);
	}

	@Override
	public List<ArticleVO> searchCategoryOrderbyHot(SearchVO search) {
		return maindao.searchCategoryOrderbyHot(search);
	}

	@Override
	public List<ArticleVO> searchTagOrderbyHot(SearchVO search) {
		return maindao.searchTagOrderbyHot(search);
	}

	@Override
	public List<ArticleVO> searchGenderOrderbyHot(SearchVO search) {
		return maindao.searchGenderOrderbyHot(search);
	}

	@Override
	public List<ArticleVO> searchAgeOrderbyHot(SearchVO search) {
		return maindao.searchAgeOrderbyHot(search);
	}

	@Override
	public ArticleVO searchArticleOrderbyHot(SearchVO search) {
		return maindao.searchArticleOrderbyHot(search);
	}

	@Override
	public void scrabInput(ArticleVO articleVO) {
		maindao.scrabInput(articleVO);
	}

	@Override
	public List<Object> category(String email, int category) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("email", email);
		hm.put("category", category);
		return maindao.category(hm);

	}

	@Override
	public int getLatestArticleNum(String email) {
		return maindao.getLatestArticleNum(email);
	}

	@Override
	public List<ArticleVO> getrecommendarticle(int article_num, String email) {
		ItemVO itemVO;
		int gender;
		HashMap<String, Object> hm;

		itemVO = maindao.getbrand(article_num);
		gender = maindao.getGenderByArticleNum(article_num);

		if (itemVO.getDress() == null && itemVO.getTshirt() == null && itemVO.getPants() == null
				&& itemVO.getJacket() == null && itemVO.getSneakers() == null && itemVO.getSocks() == null)
			return null;
		else {
			if (gender == 1 || gender == 2) {
				if (itemVO.getJacket() == null)
					itemVO.setJacket("");
				if (itemVO.getTshirt() == null)
					itemVO.setTshirt("");
				if (itemVO.getPants() == null)
					itemVO.setPants("");
				if (itemVO.getSneakers() == null)
					itemVO.setSneakers("");
				if (itemVO.getSocks() == null)
					itemVO.setSocks("");
				itemVO.setDress("");
			} else {
				if (itemVO.getJacket() == null)
					itemVO.setJacket("");
				if (itemVO.getTshirt() == null)
					itemVO.setTshirt("");
				if (itemVO.getPants() == null)
					itemVO.setPants("");
				if (itemVO.getDress() == null)
					itemVO.setDress("");
				if (itemVO.getSneakers() == null)
					itemVO.setSneakers("");
				if (itemVO.getSocks() == null)
					itemVO.setSocks("");
			}
			hm = new HashMap<>();
			hm.put("email", email);
			hm.put("jacket", itemVO.getJacket());
			hm.put("tshirt", itemVO.getTshirt());
			hm.put("pants", itemVO.getPants());
			hm.put("dress", itemVO.getDress());
			hm.put("sneakers", itemVO.getSneakers());
			hm.put("socks", itemVO.getSocks());
			return maindao.getrecommendarticle(hm);
		}

	}

	@Override
	public List<ArticleVO> getTagRecommend(int article_num, String email) {
		// 해당 article_num에 대한 태그를 가져온 후 공백인지 확인
		String tag = maindao.getTagInArticleTable(article_num);
		HashMap<String, Object> hm;
		if (tag == null)
			return null;
		else {
			hm = new HashMap<>();
			hm.put("email", email);
			hm.put("tag", tag);
			return maindao.getTagRecommend(hm);
		}

	}

}
