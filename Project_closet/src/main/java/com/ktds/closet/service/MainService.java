package com.ktds.closet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ktds.closet.vo.ArticleImageVO;
import com.ktds.closet.vo.ArticleVO;
import com.ktds.closet.vo.CommentVO;
import com.ktds.closet.vo.ImageVO;
import com.ktds.closet.vo.ItemVO;
import com.ktds.closet.vo.SearchVO;

public interface MainService {
	// 메인에서 대표이미지 갖고 오는 메소드
	public ImageVO contentImageDown(int image_num);

	// 컨텐츠에서 사진을 가져오는 메소드
	public ImageVO mainImageDown(int article_num, int scrab_num);

	// 글에 첨부된 이미지들을 다루기 위한 매소드
	public List<ImageVO> getImagenum(int article_num);

	// 해당 글에 달린 댓글의 개수
	public int getCommentCount(int article_num);

	// 내가 올린 글의 개수
	public int getImageCount(String email);

	// 내가 스크랩한 개수
	public int getScrabCount(String email);

	// 나의 좋아요한 글 개수
	public int getLikeCountArticle(String email);

	// 나의 좋아요한 사진 개수
	public int getLikeCountImage(String email);

	// 내가 follow한 친구 수
	public int getFollowingCount(String email);

	// 나를 follow한 친구 수
	public int getFollowerCount(String email);

	// 동일한 태그를 가진 글 수
	public int getTagRecommendCount(int article_num, String email);

	// 동일한 브랜드 아이템을 갖는 게시글 수
	public int brandReqCount(int article_num, String email);

	// 내 게시글 개수
	public int myArticleCount(String email);

	// 글 작성을 위한 메소드(브랜드를 입력한 경우)
	public void writeArticle(MultipartHttpServletRequest mreq, HttpServletRequest req, ArticleVO articleVO,
			ItemVO itemVO);

	// 글 작성을 위한 메소드(브랜드를 입력하지 않은 경우)
	public void writeArticle(MultipartHttpServletRequest mreq, HttpServletRequest req, ArticleVO articleVO);

	// 글 삭제를 위한 메소드
	public void deleteArticle(int article_num);

	// 좋아요가 눌렸는지 확인하는 메소드
	public Boolean checkFavoriteArticle(int article_num, String email);

	public Boolean checkFavoriteImage(int image_num, String email);

	// favorite field 값을 +-1 하는 메소드 (좋아요/좋아요 취소 시)
	public void addFavoriteArticle(int article_num);

	public void subtractFavoriteArticle(int article_num);

	public void addFavoriteImage(int image_num);

	public void subtractFavoriteImage(int image_num);

	// 좋아요 개수를 반환하는 메소드
	public int selectlikeArticleNum(int article_num);

	public int selectlikeImageNum(int image_num);

	// 게시글, 이미지 각각에 대해 좋아요 누른 사람들을 목록에 추가하고 제거하는 메소드
	public void insertlikeArticle(int article_num, String email, String name);

	public void deletelikeArticle(int article_num, String email);

	public void insertlikeImage(int image_num, String email, String name);

	public void deletelikeImage(int image_num, String email);

	// 게시글, 이미지 각각에 대해 좋아요 누른 사람 목록을 보여주기 위한 메소드
	public List<String> getArticleNames(int article_num);

	public List<String> getImageNames(int image_num);

	// 로그인했을 때 내 게시글을 보여주기 위한 메소드
	public List<ArticleVO> showMyArticle(String email);

	public List<ArticleVO> showMyLikeArticle(String email);

	public List<ArticleImageVO> showMyLikeImage(String email);

	public List<ArticleVO> showMyScrab(String email);

	public List<ArticleVO> showArticle(String email);

	// 세부 내용을 보여주기 위한 메소드
	public ArticleVO showContent(int article_num);

	// 브랜드를 보여주는 메소드
	public ItemVO showItem(int article_num);

	// 글 세부내용 보기 화면에서 댓글과 관련된 메소드들
	public List<CommentVO> showComment(int article_num);

	public void insertComment(String email, String comment_content, int article_num);

	public void deleteComment(int article_num, int comment_num);

	// 좋아요 개수가 top 5인 이미지들
	public List<ImageVO> getbestImages();

	// 조건 검색을 위한 메소드들 (검색 결과를 시간 순으로 정렬)
	// 검색 키워드를 주지 않으면 전체를 보여준다.
	public List<ArticleVO> searchContent(SearchVO search);

	public List<ArticleVO> searchUser(SearchVO search);

	public List<Integer> searchComment(SearchVO search);

	public List<Integer> searchComment2(SearchVO search);

	public List<ArticleVO> searchCategory(SearchVO search);

	public List<ArticleVO> searchTag(SearchVO search);

	public List<ArticleVO> searchGender(SearchVO search);

	public List<ArticleVO> searchAge(SearchVO search);

	public ArticleVO searchArticle(SearchVO search);

	// 조건 검색을 위한 함수 (검색 결과를 favorite 순으로 정렬)
	public List<ArticleVO> searchContentOrderbyHot(SearchVO search);

	public List<ArticleVO> searchUserOrderbyHot(SearchVO search);

	public List<Integer> searchCommentOrderbyHot(SearchVO search);

	public List<Integer> searchComment2OrderbyHot(SearchVO search);

	public List<ArticleVO> searchCategoryOrderbyHot(SearchVO search);

	public List<ArticleVO> searchTagOrderbyHot(SearchVO search);

	public List<ArticleVO> searchGenderOrderbyHot(SearchVO search);

	public List<ArticleVO> searchAgeOrderbyHot(SearchVO search);

	public ArticleVO searchArticleOrderbyHot(SearchVO search);

	// 스크랩 입력
	public void scrabInput(ArticleVO articleVO);

	// 카테고리
	public List<Object> category(String email, int category);

	// 추천글 (최신글에 대한 태그, 브랜드별 추천글 가져오기)
	public int getLatestArticleNum(String email);

	public List<ArticleVO> getrecommendarticle(int article_num, String email);

	public List<ArticleVO> getTagRecommend(int article_num, String email);

}
