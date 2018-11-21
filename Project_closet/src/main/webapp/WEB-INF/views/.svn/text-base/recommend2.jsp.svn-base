<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>데일리코디</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="resources/css/main_content.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/recommend.css" />
<script src="resources/js/recommend.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/button.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="resources/js/dimmedpopup.js"></script>
<script src="resources/js/comment_jquery.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var tabchoose="${tabchoose }";
	if(tabchoose==1){
		$("#tabmenu1").attr('checked', true);
		$("#brandList").hide();
	}else{
		$("#tabmenu2").attr('checked', true);
		$("#tagList").hide();
	}
});
</script>
</head>
<body>

<!-- main_content_header -->
   <jsp:include page="/WEB-INF/views/main_content_header.jsp" flush="true" />

	<jsp:include page="/WEB-INF/views/content.jsp" flush="true" />
	
   <div id="content">
	   <div id="main_section">
		   	<div id="tabmenu">
		   		<input id="tabmenu1" type="radio" name="tabmenu" value="1" onclick="document.location.href='recommend.main?tab=1&email=${email}'"/>
            	<input id="tabmenu2" type="radio" name="tabmenu" value="2" onclick="document.location.href='recommend.main?tab=2&email=${email}'"/>
            	<section class="tabbuttons">
		            <label for="tabmenu1">태그</label>
		            <label for="tabmenu2">브랜드</label>
		        </section>
		   	</div>
		   	<div id="tabcontent">
				<!-- 태그명에 따른 추천 -->
				<div id="tagList">
					<c:if test="${empty tagList}">
			         <br>
			         <b>게시글이 없습니다.</b><hr>
			        </c:if>
			        
			      <c:if test="${tagList!=null}">
					<c:forEach var="tagList" items="${tagList}">
						<input type="hidden" id="article_num" value="${tagList.article_num}">
			            <input type="hidden" id="scrab_num" value="${tagList.scrab_num}">
			            <table border="2" width="300" name="main_article">
			               <tr>
			                  <td align="center" id="table_one"><img src='/closet/profileImageDown.etc?email=${tagList.email}' width='60' height='60'></td><td id="table_one"><a href="javascript:openprofile('${tagList.email}')" id="${tagList.email}" style="text-decoration:none"><font size="5" color="white"><strong>${tagList.name}</strong></font></a><br>
			                     <font size="3" color="white"><c:out value="${tagList.article_date}" /></font></td>
			               </tr>
			               <tr>
			                  <td colspan='2' align="center" ><a style="cursor: pointer;" class="btn-example" onclick="popupcontent(${tagList.article_num},${tagList.scrab_num})">
			                  <img src="/closet/mainImageDown.main?article_num=${tagList.article_num}&scrab_num=${tagList.scrab_num}" id="main_img"></a></td>
			               </tr>
			               <tr>
			                  <td align="right" colspan='2'>이 글을 좋아요 한 사람:<a href="javascript:getNamesArticle('${tagList.article_num}')"id="${tagList.article_num}" style="text-decoration: none;"><c:out value="${tagList.favorite}"/>명</a>
			               </tr>
			               <tr>
			                  <td colspan='2'><input type="button" value='${tagList.btnVal}' id="${tagList.article_num}favoriteArticleBtn"
			                     onclick="likeArticle(${tagList.article_num},'${tagList.name}','${tagList.email}')"> 
			                  
			                     <input type="button" value="스크랩하기" onClick="javascript:scrab_writeForm(${tagList.article_num},${tagList.scrab_num });">
			                  </td>
			               </tr>
			            </table>
					</c:forEach>
				</c:if>
				</div>
				
				<!-- 브랜드명에 따른 추천 -->
				<div id="brandList">
				<c:if test="${empty brandList}">
			         <br>
			         <b>게시글이 없습니다.</b><hr>
	      		</c:if>

		      	<c:if test="${brandList!=null}">
		         <c:forEach var="brandList" items="${brandList}">
						<input type="hidden" id="article_num" value="${brandList.article_num}">
			            <input type="hidden" id="scrab_num" value="${brandList.scrab_num}">
			            <table border="2" width="300" name="main_article">
			               <tr>
			                  <td align="center" id="table_one"><img src='/closet/profileImageDown.etc?email=${brandList.email}' width='60' height='60'></td><td id="table_one"><a href="javascript:openprofile('${brandList.email}')" id="${brandList.email}" style="text-decoration:none"><font size="5" color="white"><strong>${brandList.name}</strong></font></a><br>
			                     <font size="3" color="white"><c:out value="${brandList.article_date}" /></font></td>
			               </tr>
			               <tr>
			                  <td colspan='2' align="center" ><a style="cursor: pointer;" class="btn-example" onclick="popupcontent(${brandList.article_num},${brandList.scrab_num})">
			                  <img src="/closet/mainImageDown.main?article_num=${brandList.article_num}&scrab_num=${brandList.scrab_num}" id="main_img"></a></td>
			               </tr>
			               <tr>
			                  <td align="right" colspan='2'>이 글을 좋아요 한 사람:<a href="javascript:getNamesArticle('${brandList.article_num}')"id="${brandList.article_num}" style="text-decoration: none;"><c:out value="${brandList.favorite}"/>명</a>
			               </tr>
			               <tr>
			                  <td colspan='2'><input type="button" value="${brandList.btnVal}" id="${brandList.article_num}favoriteArticleBtn"
			                     onclick="likeArticle(${brandList.article_num},'${brandList.name}','${brandList.email}')"> 
			                  
			                     <input type="button" value="스크랩하기" onClick="javascript:scrab_writeForm(${brandList.article_num},${brandList.scrab_num });">
			                  </td>
			               </tr>
			            </table>
					</c:forEach>
      			</c:if>  
					
				</div>
		   	</div>
	   </div>
   </div>
   
</body>

</html>