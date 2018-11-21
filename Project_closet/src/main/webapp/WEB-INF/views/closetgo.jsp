<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="resources/js/bpopup.js"></script>
<script src="resources/js/Etcjs.js"></script>
<link href="resources/css/bpopup.css" rel="stylesheet" type="text/css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
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
<body>
<table>

<c:forEach var="profile" items="${profile}">
<table border="2"  style="margin:0.2em; border-style:outset; BORDER-COLLAPSE:collapse">
<tr>
<span id="profile">

<td rowspan="2"><img src="/closet/profileImageDown.etc?email=${profile.email}" style="width:100px; height:100px"></td>

<td style="height: 30px;">이름</td>
<td>한마디</td>
<td>스펙</td>


</span>
<span id="follow">
<c:if test="${id!=profile.email}">


<c:if test="${statusnum==2}">
<td rowspan="2"><input type="button" value="팔로우 하기" onclick="document.location.href='/closet/addfollow.etc?fdemail=${profile.email}&fdname=${profile.name}'"></td>
</c:if>
<c:if test="${statusnum==1}">
<td rowspan="2"><input type="button" value="팔로우 끊기"  onclick="document.location.href='/closet/deletefollow.etc?fdemail=${profile.email}'"></td>
</c:if>

</c:if>
<c:if test="${id==profile.email}">
<td rowspan="2"><input type="button" value="내 프로필 관리"  onclick="updateprofile()"></td>
</c:if>
</span>
</tr>
<tr>
	<td valign="top"><br>${profile.name}</td>
	<c:if test="${profile.status==null}"><td valign="top"><br>등록된 한마디가 없습니다.</td></c:if>
<c:if test="${profile.status!=null}"><td valign="top"><br>${profile.status}</td></c:if>
<c:if test="${profile.kg==null or profile.cm==null}"><td valign="top"><br>비밀^^</td></c:if>
<c:if test="${profile.cm!=null and profile.kg!=null}"><td valign="top"><br>${profile.cm}<br>${profile.kg}</td></c:if>

</tr>
</table>


</c:forEach>

</table>
<hr>
<br>
 <c:if test="${empty articleList}">
         <br>
         <b>게시글이 없습니다.</b>
      </c:if>

      <c:if test="${articleList!=null}">
         <c:forEach var="content" items="${articleList}">
            <input type="hidden" id="article_num" value="${content.article_num}">
            <input type="hidden" id="scrab_num" value="${content.scrab_num}">
            <table align="center" border="2" Bordercolor=#1DE9C0 style="border-style:outset;border-color:#1DE9C0; float:left; margin:0.5em; z-index:15; BORDER-COLLAPSE:collapse">
               <tr>
                  <td align="center" id="table_one"><img src='/closet/profileImageDown.etc?email=${content.email}' style="height: 40px; width: 40px"></td>
                  <td id="table_one"><a href="javascript:openprofile('${content.email}')"id="${content.email}" style="text-decoration:none"><font size="4" color="white"><strong>${content.name}</strong></font></a><br>
                     <font size="2" color="white"><c:out value="${content.article_date}" /></font></td>
               </tr>
               <tr>
                  <td colspan='2' align="center"><a style="cursor: pointer;" class="btn-example" onclick="popupcontent(${content.article_num},${content.scrab_num})">
                  <img src="/closet/mainImageDown.main?article_num=${content.article_num}&scrab_num=${content.scrab_num}" id="main_img"></a></td>
               </tr>
              
               <tr>
                  <td colspan='2'>
                     	<input type="button" value="삭제" onclick="deleteArticle(${content.article_num},'${content.email}')" style="float: right">
                  </td>
               </tr>
            </table>
            
         </c:forEach>
      </c:if>  
<div id="popup1" class="popup-div popup-style">
   <span class="b-close"><span>X</span></span>
   <div class="content" style="height: auto; width: auto;">
      <div class="b-ajax-wrapper">
         <div id='gil'></div>
      </div>
   </div>
</div>
<div id="popup4" class="popup-div popup-style">
   <span class="b-close"><span>X</span></span>
   <div class="content" style="height: auto; width: auto;">
      <div class="b-ajax-wrapper">
         <div id='gil'></div>
      </div>
   </div>
</div>      
</body>
</html>