<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="resources/js/bpopup.js"></script>
<script src="resources/js/main_content.js"></script>
<script src="resources/js/comment_jquery.js"></script>
<link href="resources/css/bpopup.css" rel="stylesheet" type="text/css" />
<script src="resources/js/Etcjs.js"></script>

<style type="text/css">

#table_one{
background: #1cd8c9; /* Old browsers */
background: -moz-linear-gradient(top,  #1cd8c9 0%, #79e5d5 100%, #7db9e8 100%, #2989d8 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#1cd8c9), color-stop(100%,#79e5d5), color-stop(100%,#7db9e8), color-stop(100%,#2989d8)); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top,  #1cd8c9 0%,#79e5d5 100%,#7db9e8 100%,#2989d8 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top,  #1cd8c9 0%,#79e5d5 100%,#7db9e8 100%,#2989d8 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top,  #1cd8c9 0%,#79e5d5 100%,#7db9e8 100%,#2989d8 100%); /* IE10+ */
background: linear-gradient(to bottom,  #1cd8c9 0%,#79e5d5 100%,#7db9e8 100%,#2989d8 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1cd8c9', endColorstr='#2989d8',GradientType=0 ); /* IE6-9 */
}
  
</style>
<!-- <div id="popup1" class="popup-div popup-style"> -->
<!--    <span class="b-close"><span>X</span></span> -->
<!--    <div class="content" style="height: auto; width: auto;"> -->
<!--       <div class="b-ajax-wrapper"> -->
<!--          <div id='gil'></div> -->
<!--       </div> -->
<!--    </div> -->
<!-- </div> -->

<!-- <div id="popup2" class="popup-div popup-style"> -->
<!--      <div class="content" style="height: auto; width: auto;"> -->
<!--       <div class="b-ajax-wrapper"> -->
<!--        </div> -->
<!--    </div> -->
<!-- </div> -->
<!-- <div id="popup3" class="popup-div popup-style"> -->
<!-- 	<span class="b-close"><span>X</span></span> -->
<!--      <div class="content" style="height: auto; width: auto;"> -->
<!--       <div class="b-ajax-wrapper"> -->
<!--        </div> -->
<!--    </div> -->
<!-- </div> -->
<div id="popup4" class="popup-div popup-style">
	<span class="b-close"><span>X</span></span>
     <div class="content" style="height: auto; width: auto;">
      <div class="b-ajax-wrapper">
       </div>
   </div>
</div>

<div id="main_section">
	<c:if test="${order == 0}">
	   		<input type="button" value="최신순" class="button" disabled="disabled" style='cursor:auto;'>
	   		<input type="button" value="인기순" onclick="orderByFavorite()" class="button1" style='cursor:pointer;'>
	</c:if>
	<c:if test="${order == 1}">
	   		<input type="button" value="최신순" onclick="orderByDate()" class="button1" style='cursor:pointer;'>
	   		<input type="button" value="인기순" class="button" disabled="disabled" style='cursor:auto;'>
	</c:if>
	<div id="showInform" style="height: auto; width: auto;">
	</div>
	<hr>  
 
 	<div id="main_articles">
      <c:if test="${empty articleList}">
         <br>
         <b>게시글이 없습니다.</b>
      </c:if>

      <c:if test="${articleList!=null}">
         <c:forEach var="content" items="${articleList}">
            <input type="hidden" id="article_num" value="${content.article_num}">
            <input type="hidden" id="scrab_num" value="${content.scrab_num}">
            <table border="2" width="300" name="main_article">
               <tr>
                  <td align="center" id="table_one"><img src='/closet/profileImageDown.etc?email=${content.email}' width='60' height='60'></td><td id="table_one"><a href="javascript:openprofile('${content.email}')" id="${content.email}" style="text-decoration:none"><font size="5" color="white"><strong>${content.name}</strong></font></a><br>
                     <font size="3" color="white"><c:out value="${content.article_date}" /></font></td>
               </tr>
               <tr>
                  <td colspan='2' align="center" ><a style="cursor: pointer;" class="btn-example" onclick="popupcontent(${content.article_num},${content.scrab_num})">
                  <img src="/closet/mainImageDown.main?article_num=${content.article_num}&scrab_num=${content.scrab_num}" id="main_img"></a></td>
               </tr>
               <tr>
                  <td align="right" colspan='2'>이 글을 좋아요 한 사람:<a href="javascript:getNamesArticle('${content.article_num}')"id="${content.article_num}" style="text-decoration: none;"><c:out value="${content.favorite}"/>명</a>
               </tr>
               <tr>
                  <td colspan='2'><input type="button" value="${content.btnVal}" id="${content.article_num}favoriteArticleBtn"
                     onclick="likeArticle(${content.article_num},'${content.name}','${content.email}')"> 
                     
                     <c:if test="${content.email != email }">
                     <input type="button" value="스크랩하기" onClick="javascript:scrab_writeForm(${content.article_num},${content.scrab_num });">
                     </c:if>
                     
                     <c:if test="${id==content.email}">
                     	<input type="button" value="삭제" onclick="deleteArticle(${content.article_num},'${content.email}')" style="float: right">
                     </c:if>
                  </td>
               </tr>
            </table>
            
         </c:forEach>
      </c:if> 
    </div>
</div>