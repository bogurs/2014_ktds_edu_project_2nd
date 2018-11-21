<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./resources/js/jquery-2.1.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/button.css" />
<style type="text/css">
#main_weather{
	background-image:url(/closet/resources/img/main_content.jpg);
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	var time = 100;
    var idx = idx2 = 0;
    var slide_width = $("#slider").width();
    var slide_count = $("#slider li").size();
    $("#slider li:first").css("display", "block");
    if(slide_count > 1)
        $(".btn").css("display", "inline");
        
    $("#prev_btn").click(function() {
        if(slide_count > 1) {
            idx2 = (idx - 1) % slide_count;
            if(idx2 < 0)
                idx2 = slide_count - 1;
            $("#slider li:hidden").css("left", "-"+slide_width+"px");
            $("#slider li:eq("+idx+")").animate({ left: "+="+slide_width+"px" }, time, function() {
                $(this).css("display", "none").css("left", "-"+slide_width+"px");
            });
            $("#slider li:eq("+idx2+")").css("display", "block").animate({ left: "+="+slide_width+"px" }, time);
            idx = idx2;
        }
    });

    $("#next_btn").click(function() {
        if(slide_count > 1) {
            idx2 = (idx + 1) % slide_count;
            $("#slider li:hidden").css("left", slide_width+"px");
            $("#slider li:eq("+idx+")").animate({ left: "-="+slide_width+"px" }, time, function() {
                $(this).css("display", "none").css("left", slide_width+"px");
            });
            $("#slider li:eq("+idx2+")").css("display", "block").animate({ left: "-="+slide_width+"px" }, time);
            idx = idx2;
        }
    });
	
	var weather_num = $("input[name=weather_num]").val();
	var email = "${email}";
	$.ajax({
		url : "/closet/weatherStyleGetHit.etc",
		type : "post",
		data : {
			"weather_num" : weather_num,
			"email" : email
		},
		success : function(data){
			if(data.getHit == 0){//추천 하지 않은 글일 때
				$("input[name=hitDwBtn]").appendTo($('#hideHitButton'));
				$("input[name=hitUpBtn]").appendTo($('#showHitButton'));
			}else{//이미 추천한 글일 때
				$("input[name=hitUpBtn]").appendTo($('#hideHitButton'));
				$("input[name=hitDwBtn]").appendTo($('#showHitButton'));
			}			
		},
		error : function(error){
			alert("error : " + error);
		}
	});
	
	$("input[name=hitUpBtn]").on("click", function() {		
		var weather_num = $("input[name=weather_num]").val();
		var email = "${email}";
		$.ajax({
			url : "/closet/weatherStyleHitAdd.etc",
			type : "post",
			data : {
				"weather_num" : weather_num,
				"email" : email
			},
			success : function(data){
				window.location.reload();
			},
			error : function(error){
				alert("error : " + error);
			}
		});
	});
	
	$("input[name=hitDwBtn]").on("click", function() {		
		var weather_num = $("input[name=weather_num]").val();
		var email = "${email}";
		$.ajax({
			url : "/closet/weatherStyleHitSub.etc",
			type : "post",
			data : {
				"weather_num" : weather_num,
				"email" : email
			},
			success : function(data){
				window.location.reload();
			},
			error : function(error){
				alert("error : " + error);
			}
		});
	});
	
	$("input[name=closeBtn]").on("click", function() {		
		window.opener.location.reload();
		window.close();
	});
});
</script>
<style type="text/css">
#prev_btn {
	position: absolute;
	top: 250px;
	left: 100px;
}

#next_btn {
	position: absolute;
	top: 250px;
	right: 100px;
}

.btn {
	width: 2em;
	height: 280px;
	border: 0;
	background: #f5f6fa;
	display: none;
	margin-top: 60px;
}

#slider {
	position: relative;
	margin: 0 auto;
	padding: 0;
	list-style: none;
	width: 380px;
	height: 400px;
	overflow-x: hidden
}

#slider li {
	display: none;
	left: 0;
	top: 0
}

#slider img {
	width: 380px;
	height: 400px;
}
</style>
</head>
<body>
	<div id="main_weather">
	<table border="1" align="center" width="700" height="600">
		<c:forEach var="weatherStyleList" items="${weatherStyleList}">
		<input type="hidden" value="${weatherStyleList.weather_num}" name="weather_num">
			<tr height="50">
				<th>글번호</th>
				<td>${weatherStyleList.weather_num}</td>
				<th>제목</th>
				<td colspan="3">${weatherStyleList.title}</td>
			</tr>
			<tr height="50">
				<th>이름</th>
				<td>${weatherStyleList.name}</td>
				<th>추천수</th>
				<td>${weatherStyleList.hit}</td>
				<th>게시일</th>
				<td>${weatherStyleList.write_date}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td align="center" colspan="5"><img src="resources/img/left.jpg" style="width: 40px; height: 40px; cursor: pointer; left:180px" id="prev_btn" class="btn" /> 
				<img src="resources/img/right.jpg" style="width: 40px; height: 40px; cursor: pointer; right:100px" id="next_btn" class="btn" />
					<ul id="slider">
						<c:forEach var="imageList" items="${imageList}">
							<li>
								<img src="/closet/weatherStyleImageDown.etc?wtimage_num=${imageList.wtimage_num}">								
							</li>
						</c:forEach>
					</ul>
					<hr>${weatherStyleList.content}
				</td>
			</tr>
			<tr height="50">
				<th>이메일</th>
				<td colspan="5">${weatherStyleList.email}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<hr>
	
	<div align="center" id="showHitButton">
		<input type="button" value="추천" class="button orange rectangular" name="hitUpBtn">
	</div>
	<div align="right">
		<input type="button" value="close" class="button pink" name="closeBtn">
	</div>
	
	<div id="hideHitButton" style="display: none">
		<input type="button" value="추천 취소" class="button orange rectangular" name="hitDwBtn">
	</div>
	
</body>
</html>