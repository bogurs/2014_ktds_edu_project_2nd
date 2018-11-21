<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${articleList!=null}">
	<c:forEach var="content" items="${articleList}">
		<table align="center" border="1" width=235>
			<tr>
				<td align="center"><c:out value="${content.name}" /><br>
					<c:out value="${content.article_date}" /></td>
			</tr>
			<tr>
				<td align="center"><a style="cursor: pointer"onClick="javascript:window.open('content.main?article_num=${content.article_num}&scrab_num=${content.scrab_num}','cnjOpen','width=800,height=800')">
						<img src="/closet/mainImageDown.main?article_num=${content.article_num}&scrab_num=${content.scrab_num}"id="closet_img">
				</a></td>
			</tr>
			<tr>
				<td align="right">이 글을 좋아요한 사람: <a href="#"><c:out
							value="${content.favorite}" />명</a></td>
			</tr>
			<tr>
				<td><input type="button" value="${content.btnVal}"
					id="${content.article_num}favoriteBtn"
					onclick="likeArticle(${content.article_num}, ${content.email})">
					<input type="button" value="스크랩하기"
					onClick="javascript:window.open('scrab_writeForm.main?article_num=${content.article_num}&scrab_num=${content.scrab_num }','cnjOpen','width=800,height=800')">
					<input type="button" value="삭제"
					onclick="deleteArticle(${content.article_num})"
					style="float: right"></td>
			</tr>
		</table>
		<br>
	</c:forEach>
</c:if>