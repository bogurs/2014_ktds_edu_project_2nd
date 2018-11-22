package com.ktds.closet.dao;

import java.util.HashMap;
import java.util.List;

import com.ktds.closet.vo.ArticleImageVO;
import com.ktds.closet.vo.ArticleVO;
import com.ktds.closet.vo.CommentVO;
import com.ktds.closet.vo.ImageVO;
import com.ktds.closet.vo.ItemVO;
import com.ktds.closet.vo.SearchVO;

public interface MainDao {
	public ImageVO mainImageDown(HashMap<String, Integer> hm);

	public ImageVO contentImageDown(int article_num);

	public void InsertImage(ImageVO image);

	// 해당 글에 달린 댓글의 개수
	public int getCommentCount(int article_num);

	// 나의 전체 이미지 개수
	public int getImageCount(String email);

	// 나의 전체 스크랩 개수
	public int getScrabCount(String email);

	// 나의 좋아요한 글 개수
	public int getLikeCountArticle(String email);

	// 나의 좋아요한 사진 개수
	public int getLikeCountImage(String email);

	// 내가 follow한 친구 수
	public int getFollowingCount(String email);

	// 나를 follow한 친구 수
	public int getFollowerCount(String email);

	// 동일한 태그를 갖는 게시글 수
	public int getTagRecommendCount(HashMap<String, Object> hm);

	// 동일한 브랜드 아이템을 갖는 게시글 수
	public int brandReqCount(HashMap<String, Object> hm);

	// 내 게시글 개수
	public int myArticleCount(String email);

	// 글 작성을 위한 함수
	public int writeArticle(ArticleVO article);

	// 글 작성을 위한 함수
	public void insertBrand(ItemVO itemVO);

	// 글 삭제를 위한 함수
	public void deleteArticle(int article_num);

	// 글에 첨부된 이미지들을 다루기 위한 함수
	public List<ImageVO> getImagenum(int article_num);

	// 좋아요가 눌렸는지 확인하는 함수들
	public List<String> checkFavoriteArticle(int article_num);

	public List<String> checkFavoriteImage(int image_num);

	// favorite field 값을 +-1 하는 함수 (좋아요/좋아요 취소 시)
	public void addFavoriteArticle(int article_num);

	public void subtractFavoriteArticle(int article_num);

	public void addFavoriteImage(int image_num);

	public void subtractFavoriteImage(int image_num);

	// 게시글, 이미지 각각에 대해 좋아요 누른 사람들을 목록에 추가하고 제거하고 좋아요 개수 가져오는 메소드
	public void insertlikeArticle(ArticleVO article);

	public void deletelikeArticle(ArticleVO article);

	public int selectlikeArticleNum(int article_num);

	public void insertlikeImage(ImageVO image);

	public void deletelikeImage(ImageVO image);

	public int selectlikeImageNum(int image_num);

	// 좋아요 누른 사람 목록을 보여주기 위한 함수
	public List<String> getArticleEmails(int article_num);

	public List<String> getImageEmails(int image_num);

	public String getName(String email);

	// 로그인했을 때 내 게시글을 보여주기 위한 함수
	public List<ArticleVO> showMyArticle(String email);

	public List<ArticleVO> showMyLikeArticle(String email);

	public List<ArticleImageVO> showMyLikeImage(String email);

	public List<ArticleVO> showMyScrab(String email);

	public List<ArticleVO> showArticle(String email);

	// 세부 내용을 보여주기 위한 함수
	public ArticleVO showContent(int article_num);

	// 브랜드를 보여주는 함수
	public ItemVO showItem(int article_num);

	// 글 세부내용 보기 화면에서 댓글과 관련된 함수들
	public List<CommentVO> showComment(int article_num);

	public void insertComment(CommentVO commentVO);

	public void deleteComment(int comment_num);

	// 좋아요 개수가 top 5인 이미지들
	public List<ImageVO> getbestImages();

	// 조건 검색을 위한 함수 (검색 결과를 시간 순으로 정렬)
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

	// 내가 쓴 글에 첨부된 이미지
	public List<ImageVO> showMyImage(int article_num);

	// 스크랩
	public void scrabInput(ArticleVO articleVO);

	// 카테고리
	public List<Object> category(HashMap<String, Object> hm);

	// 추천글(태그,브랜드 별 추천)
	public int getLatestArticleNum(String email);

	public ItemVO getbrand(int article_num);

	public int getGenderByArticleNum(int article_num);

	public List<ArticleVO> getrecommendarticle(HashMap<String, Object> hm);

	public String getTagInArticleTable(int article_num);

	public List<ArticleVO> getTagRecommend(HashMap<String, Object> hm);

}
