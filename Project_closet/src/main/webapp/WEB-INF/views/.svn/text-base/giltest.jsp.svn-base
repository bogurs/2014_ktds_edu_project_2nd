<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script>
$(document).ready(function(){	
$("#keyword").blur(function(){
var email=$("#keyword").val();
var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;   
if(regex.test(email) === false) {  
    $("#gil").css("color","red").html("유효한 이메일 형식이 아닙니다.");  
} else {  
	 $("#gil").css("color","blue").html("사용가능");  
}
});
});
</script>
<body>
<input type="text" id="keyword">
<input type="button" onclick="gil()">
<div id="gil"></div>

</body>
</html>