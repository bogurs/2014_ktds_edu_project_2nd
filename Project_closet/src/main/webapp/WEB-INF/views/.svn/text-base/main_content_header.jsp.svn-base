<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- header -->
<link href="resources/css/bpopup.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="resources/js/bpopup.js"></script>
<script src="resources/js/comment_jquery.js"></script>
<link href="resources/css/bpopup.css" rel="stylesheet" type="text/css" />
<script src="resources/js/Etcjs.js"></script>
<script>
function test(){
	 $('#popup0').bPopup({
	       	loadUrl: "test.etc"
	 });
}
function writeArticle(){
    $('#popup4').bPopup({
       	loadUrl: "writeForm.main"
    });
}
function scrab_writeForm(article_num, scrab_num){
    $('#popup3').bPopup({
       	loadUrl: "scrab_writeForm.main?article_num="+article_num+"&scrab_num="+scrab_num
    });
}
</script>

 <div id="popup0" class="popup-div popup-style">
   <span class="b-close"><span>X</span></span>
   <div class="content" style="height: auto; width: auto;">
      <div class="b-ajax-wrapper">
   </div></div></div>   

    <div id="popup1" class="popup-div popup-style">
   <span class="b-close"><span>X</span></span>
   <div class="content" style="height: auto; width: auto;">
      <div class="b-ajax-wrapper">
      <div id="gil1"></div></div></div></div>
      
    <div id="popup2" class="popup-div popup-style">
   <span class="b-close"><span>X</span></span>
   <div class="content" style="height: auto; width: auto;">
      <div class="b-ajax-wrapper">
      <div id="gil2"></div></div></div></div>
      
      <div id="popup3" class="popup-div popup-style">
   <span class="b-close"><span>X</span></span>
   <div class="content" style="height: auto; width: auto;">
      <div class="b-ajax-wrapper"></div></div></div>
<div id="popup4" class="popup-div popup-style">
	<span class="b-close"><span>X</span></span>
     <div class="content" style="height: auto; width: auto;">
      <div class="b-ajax-wrapper">
       </div>
   </div>
</div>
  <div id="popup5" class="popup-div popup-style">
   <span class="b-close"><span>X</span></span>
   <div class="content" style="height: auto; width: auto;">
      <div class="b-ajax-wrapper">
      <div id="gil5"></div></div></div></div>

<div id="headerContainer">
<div id="headerWrapper">
<div id="main_header">
<br>
	<a href="/closet/main_content.etc" class="main_logo_a"><img src="resources/img/daily.png" title="Daily Codi" style="width:350px; height:60px">
<!-- 	 <i class="main_logo" title="데일리코디">Daily Codi</i> -->
	</a>
	
	<div id="nav_login" style="height:60px">
	
		<table border="0" style="height:60px">
		
			<tr>
				<td><table border="0"><tr><td><img src='/closet/profileImageDown.etc?email=${email}' width='60' height='60' onclick="openprofile('${email}')" style="cursor:pointer"></td><td onclick="updateprofile()" style="cursor:pointer">${name}님환영합니다.</td></tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			
				<td valign="top"><input type="button" value="알림" onclick="javascript:test()" class="button"></td>
				<td valign="top"><input type="button" value="글쓰기" onclick="javascript:writeArticle()" class="button"></td>
				<td valign="top"><input type="button" value="로그아웃" onclick="document.location.href='/closet/logout.etc'" class="button"></td>
			</tr>
			
		</table>
		
	</div>
</div>
</div>

	<div id="main_header_nav">		
		<div id="navigator">
		<form action="/closet/search.main" name="searchForm" method="post">
			<table border="0">
				<tr>
					<td>
						<select id="searchOption" name="searchOption" onchange="javascript:state()">
							<option value="1" selected="selected">글 내용</option>
							<option value="2">글 작성자</option>
							<option value="3">댓글</option>
							<option value="4">카테고리</option>
							<option value="5">태그</option>
							<option value="6">성별</option>
							<option value="7">연령대</option>
						</select>
					</td>
					<td align="right">
						<table border="0">
							<tr>
								<td>
									<input type="text" id="searchContent" name="searchContent">								
									<select name="searchCategory" id="searchCategory">
										<option value="0" selected="selected">COORDI</option>
										<option value="1">OUTWEAR</option>
										<option value="2">TOP</option>
										<option value="3">BOTTOM</option>
										<option value="4">SHOES</option>
										<option value="5">ACCESSORY</option>
									</select>
									<select name="searchGender" id="searchGender">
										<option value="0" selected="selected">전체보기</option>
										<option value="1">성별무관</option>
										<option value="2">남성의류</option>
										<option value="3">여성의류</option>
									</select>							
									<select name="searchAge" id="searchAge">
										<option value="1" selected="selected">10대 이하</option>
										<option value="2">20대</option>
										<option value="3">30대</option>
										<option value="4">40대 이상</option>
									</select>
								</td>
								<td>
									<input type="submit" value="검색">
								</td>
							</tr>
						</table>
					</td>				
				</tr>
			</table>
		</form>
		</div>
		<div id="submenubar">
			<table border="0" style="border-collapse:collapse" >
				<tr style="padding-top:0px">
				<td><a href="/closet/main_content.etc" class="main_logo_a"><img src="resources/img/home1.png" onmouseover='this.src="resources/img/home2.png"' onmouseout='this.src="resources/img/home1.png"' width="40" height="40" ></td>
				<td><a href="/closet/closet.main?email=${email}" onmouseover="this.style.color='black'" onmouseout="this.style.color='white'">내 옷장</a></td>
				<c:if test="${myArticleCount>0}">
					<td><a href="/closet/recommend.main?tab=1&email=${email}" onmouseover="this.style.color='black'" onmouseout="this.style.color='white'">추천글</a></td>
				</c:if>
				</tr>
			</table>
		</div>
	</div>	
</div>