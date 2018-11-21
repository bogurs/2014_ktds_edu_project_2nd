<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전국패션자랑</title>
<link href="resources/css/main_content.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resources/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="resources/css/jquery.autocomplete.css"/>

<script>   

</script>
</head>
<body>

   <!-- header -->
    <header id="main_header">
        <hgroup id="title">
            <h1><i><a href="/closet/main_content.etc" style="text-decoration:none; color: white;">코딩 COORD[ing]</a></i></h1>
        </hgroup>
        <nav id="nav_login">
            <ul>
                <li>${name}님 환영합니다.</li>
                 <input type="button" value="친구관리" onclick="javascript:window.open('fdmanageview.etc','cnjOpen','width=500,height=500')" class="button">    
                <li><input type="button" value="글쓰기" onclick="window.open('write.etc', '_blank', 'width=700, height=300, toolbar=no, menubar=no, titlebar=no, location=no');"></li>
                <li><input type="button" value="로그아웃" onclick="document.location.href='/closet/logout.etc'"></li>
            </ul>
        </nav>
    </header>
    
    <div id="menu_header" >
	<a href="/closet/closet.main" >내 옷장 | </a>
	<a href="/closet/follow.etc">팔로우 | </a>
	<a href="/closet/scrab.main">스크랩</a>
</div>
    <input type="hidden" id="email" value="${email}">
    <input type="hidden" id="name" value="${name}">
    
    <!-- content -->
    <div id="content" >
        <div id="left_slide">
           <ul class = "nice-menu">
          <li class = "orange"><a href = "">내 옷장</a></li>
          <li class = "red"><a href = "/closet/follow.etc">팔로우</a></li>
          <li class = "green"><a href = "">Portfolio</a></li>
          <li class = "blue"><a href = "">Blog</a></li>
          <li class = "bright"><a href = "">Contact</a></li>
          <li class = "red"><a href = "">What not?</a></li>
        </ul>
        </div>
        
        <br><div id="main_section">
           <input type="text" size="20" id="keyword" onFocus="clearText(this)" value="이름 또는 이메일"><input type="button" value="찾기" onclick="searchfriend()">
         <div id="ss"></div>
    
   <td>내친구목록</td>
   <br>
    <c:forEach var="Friend" items="${friendList}">
     <tr>
     <td>${Friend.fdname}&nbsp;&nbsp;&nbsp;${Friend.fdemail}</td><input type="button" value="친구 끊기" onclick="document.location.href='deletefriend.etc?seqno=${Friend.friend_seq_no}'">
      <br>
    </c:forEach>
         
        </div>

      <div id="right_slide">
         
      </div>
   </div>

</body>
</html>