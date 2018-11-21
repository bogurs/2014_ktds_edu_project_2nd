<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="resources/js/bpopup.js"></script>
<script src="resources/js/Etcjs.js"></script>
<link href="resources/css/bpopup.css" rel="stylesheet" type="text/css" />
<script>
//엔터시 버튼 클릭과 동일한 효과
function enter(){
	if(event.keyCode==13){
		$("#enter").click();
	}
}

</script>
</head>
      <div id="popup5" class="popup-div popup-style">
   <span class="b-close"><span>X</span></span>
   <div class="content" style="height: auto; width: auto;">
      <div class="b-ajax-wrapper">
         <div id='gil'></div>   </div>
         </div>  </div>

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
 	<c:forEach var="profile" items="${profile}">
 	<c:if test="${id==profile.email}">
  <input type="text" size="20" id="keyword" onFocus="clearText(this)" value="이름 또는 이메일" onKeyPress='enter();'><input type="button" value="찾기" onclick="searchfriend()" id="enter">
   	</c:if>
   	</c:forEach>
   <div id="ss"></div>

   <br>
   <td>내친구목록</td>
   <br>
      
    <c:forEach var="Friend" items="${friendList}">
     <table border="2"  style="float:left; margin:0.2em; border-style:outset; BORDER-COLLAPSE:collapse">
   
     <tr>
     <td width=100><img src="/closet/profileImageDown.etc?email=${Friend.fdemail}" style="width:100px; height:100px"></td>
     <td width=60 align=center>${Friend.fdname}</td><td width=200 align=center>${Friend.fdemail}</td>
<%--      <td><input type="button" value="친구끊기" onclick="document.location.href='deletefriend.etc?seqno=${Friend.friend_seq_no}'"></td> --%>
         <td><a href ="/closet/closet.main?email=${Friend.fdemail}"><input type="button" value="옷장구경" ></a></td>
   
      
      
    </c:forEach>
        </table>
      
      
</body>
</html>