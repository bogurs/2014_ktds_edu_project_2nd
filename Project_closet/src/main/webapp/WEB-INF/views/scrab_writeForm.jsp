<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/bpopup.css" rel="stylesheet" type="text/css" />
<link href="resources/css/scrab_writeForm.css" rel="stylesheet" type="text/css" />
<script src="./resources/js/scrab_writeForm.js" type="text/javascript"></script> 
</head>

<body>
<div style="width: 1200px; height: 600px; overflow: hidden;">
<ul id="helpWrite"><li><a style="cursor: pointer;" onclick="helpWrite()">작성도우미</a></li></ul>
<span class="b-close"><span>X</span></span>
	<form action="/closet/scrabInput.main" method="post" enctype="multipart/form-data">
		<table border="0" align="left" width="570px" height="600px" style="border-right: 3px solid #06f;">
			<tr align="left" valign="top" height="40px">
				<td colspan="2">
				<input type="hidden" value="${content.tab }" name="tab" id="tab">
				<c:if test="${content.tab == 0 }">
					<input id="normalcodi" type="radio" name="tab" value="0" checked="checked" disabled="disabled"/>
            		<input id="locationcodi" type="radio" name="tab" value="1" disabled="disabled"/>
            	</c:if>
            	<c:if test="${content.tab == 1 }">
            		<input id="normalcodi" type="radio" name="tab" value="0" disabled="disabled"/>
            		<input id="locationcodi" type="radio" name="tab" value="1" checked="checked" disabled="disabled"/>
            	</c:if>
            		<section class="buttons">
		                <label for="normalcodi">일상코디</label>
		                <label for="locationcodi">장소별코디</label>
		            </section>
		            <div id="line"><hr color="#06f"></div>
				</td>
			</tr>				
			<tr>				
				<td colspan="2">
				<div id="file-list" align="center" style="width:565px; height: 500px; overflow-y: scroll;">
					<c:forEach var="imageList" items="${imageList}">
							<img src="/closet/contentImageDown.main?image_num=${imageList.image_num}" width="250px" height="300px">	
					</c:forEach>
				</div>
				</td>
			</tr>
			<tr>
				<th width="100px">
					태그 <font color="#06f">|</font>
				</th>
				<td>
					<c:if test="${content.tag == null}">태그명이 없습니다.</c:if>
					<c:if test="${content.tag ne null}">${content.tag}</c:if>
				</td>
			</tr>
		</table>		
		<table border="0" align="right" width="580px" height="600px">
			<tr>
				<td width="110" height="60" rowspan="2" align="right"><img src='/closet/profileImageDown.etc?email=${content.email}'width='60' height='60'></td>
				<td height="30" colspan="3">
					<b>${content.name }</b><b><font color="#06f"> |</font></b>&nbsp;&nbsp;&nbsp;&nbsp;
					<b>맞춤대상 _</b>
					<c:if test="${content.gender == 0}">성별무관</c:if>
					<c:if test="${content.gender == 1}">남성의류</c:if>
					<c:if test="${content.gender == 2}">여성의류</c:if>
					<input type="hidden" value="${content.gender }" name="gender" id="gender">
				</td>
			</tr>
			<tr>
				<td height="30" colspan="3">${content.article_date }</td>
			</tr>
			<tr>
				<td align="right"><b>원본내용</b>  <font color="#06f"><b>|</b></font></td>
				<td height="30" colspan="3">${content.content }</td>
			</tr>
			<tr>
				<td width="80px" align="right" style="font-size:13pt;">
					<b>카테고리</b> <font color="#06f"><b>|</b></font>
				</td>
				<td>
				 <c:if test="${content.category == 0 }">COORDI</c:if>
				 <c:if test="${content.category == 1 }">OUTWEAR</c:if>
				 <c:if test="${content.category == 2 }">TOP</c:if>
				 <c:if test="${content.category == 3 }">BOTTOM</c:if>
				 <c:if test="${content.category == 4 }">SHOES</c:if>
				 <c:if test="${content.category == 5 }">ACCESSORY</c:if>
				 <input type="hidden" value="${content.category }" name="category" id="category">
				</td>	
				<td align="right" style="font-size:13pt;">
					<b>공개설정</b> <font color="#06f"><b>|</b></font>
				</td>
				<td>
					<c:if test="${content.scrabPrivate == 0 }">공개글입니다.</c:if>
					<c:if test="${content.scrabPrivate == 1 }">팔로우 공개글입니다.</c:if>
					<c:if test="${content.scrabPrivate == 2 }">내옷장 비공개글입니다.</c:if>
				</td>				
			</tr>	
			
<!-- 			- -->
						
			<tr>
				<td colspan="4"><hr color="#06f"></td>
			</tr>
			
<!-- 			- -->
			
			<tr>
				<td width="110" height="60" rowspan="2" align="right"><img src='/closet/profileImageDown.etc?email=${email}'width='60' height='60'></td>
				<td height="60" colspan="3" valign="bottom">
					<b>${name }</b><input type="hidden" value=${name } name="name" id="name">
					<input type="hidden" value=${email } name="email" id="email">
					<input type="hidden" value=${content.article_num } name="article_num" id="article_num">
				</td>
			</tr>
			<tr><td colspan="4"></td></tr>
			<tr>
				<td align="right"><b>글 내용</b></td>
				<td height="30" colspan="3"><textarea rows="6" cols="60" name="content"></textarea></td>
			</tr>
			<tr>	
				<td colspan="2"></td>
				<td align="right" style="font-size:12pt;">
					<b>공개설정</b>  
				</td>
				<td>
					<select name="scrabPrivate" style="font-size:11pt;">
						<option value="0" selected="1">공개하기</option>
						<option value="1">팔로워에만 공개</option>
						<option value="2">내 옷장에 올리기</option>
					</select>
				</td>				
			</tr>
			<tr>
				<td align="right" style="font-size:13pt;">
					<b>태그입력 </b>
				</td>
				<td colspan="3">
					<input type="text" id="tag" name="tag" style="font-size:11pt; width: 480px;" onFocus="clearText(this)" value="브랜드 명/ 코디 명/ 옷 종류 등을 적어주세요!(예: 스파브랜드, 캐쥬얼)">
				</td>
			</tr>			
			<tr>
				<td align="right" colspan="4">
					<input type="submit" value="스크랩하기" class="button blue one-corner">
				</td>
			</tr>			
		</table>	
	</form>	
</div>
</body>
</html>