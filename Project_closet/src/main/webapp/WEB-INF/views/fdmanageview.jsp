<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/fd_content.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div id="left_slide">

			<a href="/closet/closet.main">친구찾기</a>
			<br>
			<a href="/closet/follow.etc">내 친구</a>

</div>
<div id="main_section">
 
  </div>
  	 <c:forEach var="Friend" items="${friendList}">
  	<tr>
  	<td>${Friend.name}</td><input type="button" value="수락" onclick="document.location.href='addfriend.etc?fdname=${Friend.name}&fdemail=${Friend.email}&seqno=${Friend.fdmanage_seq_no}'"/>
  	<input type="button" value="거절" onclick="document.location.href='deletereq.etc?seqno=${Friend.fdmanage_seq_no}'"/>
  	</tr>
  	<br>
    </c:forEach>
</body>
</html>