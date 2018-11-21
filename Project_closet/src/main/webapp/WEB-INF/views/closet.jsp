<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데일리코디</title>
<link href="resources/css/closet.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/button.css" />
<link href="resources/css/main_content.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="resources/js/Etcjs.js"></script>
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="./resources/js/jquery-2.1.0.min.js"></script>
<script src="./resources/js/content_jquery.js" type="text/javascript"></script>
</head>
<body background="/closet/resources/img/main.jpg">
	<input type="hidden" id="email" value="${myemail}">
  
    <jsp:include page="/WEB-INF/views/main_content_header.jsp" flush="true" />
    
	<div id="content">
	<div id="main_section">
	<ul id="tabs">
	    <li><a href="#"  onclick="closetgil('${myemail}')" title="자신이 게시한 코디만 모두 볼 수 있습니다.">내가 쓴 글(${mywritecount})</a></li>
	    <li><a href="#"  onclick="myscrab('${myemail}')" title="스크랩한 게시글을 볼 수 있습니다.">스크랩(${myscrabcount})</a></li>
	    <li><a href="#"  onclick="following('${myemail}')" title="자신이 좋아하는 사람을 즐겨찾기 할 수 있습니다.">팔로잉(${myfollowingcount})</a></li>
	    <li><a href="#"  onclick="follower('${myemail}')" title="자신을 좋아하는 사람들을 볼 수 있습니다.">팔로워(${myfollowercount})</a></li>
	    <li><a href="#"  onclick="mylikeArticle('${myemail}')" title="내가 좋아하는 글을 볼 수 있습니다." id="longtab1">내가 좋아하는 글(${mylikecountArticle})</a></li>
	    <li><a href="#"  onclick="mylikeImage('${myemail}')" title="내가 좋아하는 사진을 볼 수 있습니다." id="longtab2">내가 좋아하는 사진(${mylikecountImage})</a></li>    
	</ul>
	
	
	<div id="content1"> 
	    <div id="tab1">
	    </div>
	<!--     <div id="tab2"> -->
	    	
	<!--     </div> -->
	<!--     <div id="tab3"> -->
	  	
	<!--     </div> -->
	<!--     <div id="tab4"> -->
	    
	<!--     </div> -->
	<!--        <div id="tab5"> -->
	    
	<!--     </div> -->
	</div>
	</div>
	<jsp:include page="/WEB-INF/views/content.jsp" flush="true" />
	</div>
</body>

<script>
	$(document).ready(function() {
		text=$('#email').val();
	
		window.onload=closetgil(text);
		
	});
	
	var check="true";
	function display(size,tabname){
		if(check=="true"){
		$("#"+tabname+size).css("display", "block");
		check="false";
		}else{
			$("#"+tabname+size).css("display", "none");
			check="true";
		}
	};
	function deleteArticle(article_num){
		$.ajax({
			url : "/closet/deleteArticle.main",
			type : "post",
			data : {
				"article_num" : article_num
			},
			success : function(data){
				window.location.reload();
			}
		});
	};

</script>

<style type="text/css">
#main_header_nav > #navigator{
	display: none;
}
#tabs li:nth-child(1) a,
#tabs li:nth-child(1) a::after{
	background: #fff;
}
/* 영준영준영준영준영준영준영준영준영준영준영준영준영준영준영준영준영준 */

#tabs{
  overflow: hidden;
  width: 100%;
  padding: 0;
  list-style: none;
  margin-top:150px;
}

#tabs li{
  float: left;
  margin: 0 .5em 0 0;
}

#tabs a{
  position: relative;
  background: #ddd;
  background-image: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#ddd));
  background-image: -webkit-linear-gradient(top, #fff, #ddd);
  background-image: -moz-linear-gradient(top, #fff, #ddd);
  background-image: -ms-linear-gradient(top, #fff, #ddd);
  background-image: -o-linear-gradient(top, #fff, #ddd);
  background-image: linear-gradient(to bottom, #fff, #ddd);  
  padding: .7em;
  float: left;
  text-decoration: none;
  color: #444;
  text-shadow: 0 1px 0 rgba(255,255,255,.8);
  -webkit-border-radius: 5px 0 0 0;
  -moz-border-radius: 5px 0 0 0;
  border-radius: 5px 0 0 0;
  -moz-box-shadow: 0 2px 2px rgba(0,0,0,.4);
  -webkit-box-shadow: 0 2px 2px rgba(0,0,0,.4);
  box-shadow: 0 2px 2px rgba(0,0,0,.4);
  width:110px;
}

#tabs #longtab1{
	width:140px;
}
#tabs #longtab2{
	width:150px;
}

#tabs a:hover,
#tabs a:hover::after,
#tabs a:focus,
#tabs a:focus::after{
  background: #fff;
}

#tabs a:focus{
  outline: 0;
}

#tabs a::after{
  content:'';
  position:absolute;
  z-index: 1;
  top: 0;
  right: -.5em;  
  bottom: 0;
  width: 1em;
  background: #ddd;
  background-image: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#ddd));
  background-image: -webkit-linear-gradient(top, #fff, #ddd);
  background-image: -moz-linear-gradient(top, #fff, #ddd);
  background-image: -ms-linear-gradient(top, #fff, #ddd);
  background-image: -o-linear-gradient(top, #fff, #ddd);
  background-image: linear-gradient(to bottom, #fff, #ddd);  
  -moz-box-shadow: 2px 2px 2px rgba(0,0,0,.4);
  -webkit-box-shadow: 2px 2px 2px rgba(0,0,0,.4);
  box-shadow: 2px 2px 2px rgba(0,0,0,.4);
  -webkit-transform: skew(10deg);
  -moz-transform: skew(10deg);
  -ms-transform: skew(10deg);
  -o-transform: skew(10deg);
  transform: skew(10deg);
  -webkit-border-radius: 0 5px 0 0;
  -moz-border-radius: 0 5px 0 0;
  border-radius: 0 5px 0 0;  
}

#tabs #current a,
#tabs #current a::after{
  background: #fff;
  z-index: 3;
}

/* ------------------------------------------------- */

 #content1 #main_img{ 
 	width: 208px; 
 	height: 250px; 
 }
 #pro{
 	width:40px;
 	height:40px;
 } 
 
 #profile img{
 	width: 100px; 
 	height: 100px; 
 }
#tab3 img{
	width: 80px;
	height: 80px;
}
#tab4 img{
	width: 80px;
	height: 80px;
}
#content1
{
    background: white;
    padding: 1em;
	height: 650px;
	overflow-y: scroll;
	margin-top:-15px;
	max-width:980px;
	position: relative;
	z-index: 2;	
    -moz-border-radius: 0 5px 5px 5px;
    -webkit-border-radius: 0 5px 5px 5px;
    border-radius: 0 5px 5px 5px;
    -moz-box-shadow: 0 -2px 3px -2px rgba(0, 0, 0, .5);
    -webkit-box-shadow: 0 -2px 3px -2px rgba(0, 0, 0, .5);
    box-shadow: 0 -2px 3px -2px rgba(0, 0, 0, .5);
}

#content1 h2, #content1 h3, #content1 p
{
    margin: 0 0 15px 0;
}

/* ------------------------------------------------- */

#about
{
    color: #999;
}

#about a
{
    color: #eee;
}

</style>

<script>
	  (function(){
		// Append a close trigger for each block
		$('.menu .content').append('<span class="close">x</span>');		
		// Show window
		function showContent(elem){
			hideContent();
			elem.find('.content').addClass('expanded');
			elem.addClass('cover');	
		}
		// Reset all
		function hideContent(){
			$('.menu .content').removeClass('expanded');
			$('.menu li').removeClass('cover');		
		}
		
		// When a li is clicked, show its content window and position it above all
		$('.menu li').click(function() {
			showContent($(this));
		});		
		// When tabbing, show its content window using ENTER key
		$('.menu li').keypress(function(e) {
			if (e.keyCode == 13) { 
				showContent($(this));
			}
		});

		// When right upper close element is clicked  - reset all
		$('.menu .close').click(function(e) {
			e.stopPropagation();
			hideContent();
		});		
		// Also, when ESC key is pressed - reset all
		$(document).keyup(function(e) {
			if (e.keyCode == 27) { 
			  hideContent();
			}
		});
		
	  })();
	</script>
	
<script>
$(document).ready(function() {
// 	closetgil($("#email").val());
	$("#content1 div").hide(); // Initially hide all content
	$("#content1 div:first").fadeIn(); // Show first tab content
    
    $('#tabs a').click(function(e) {    
        $("#content1 div").hide(); //Hide all content
        $('#' + $(this).attr('title')).fadeIn(); // Show content for current tab
    });
});
// function showmyimage(url,tabname){
// 	var html='';
// 	var entryList = new Array();
// 	var uniqueList = new Array();
// 	$.ajax({
// 		url : url,
// 		type : "post",
// 		data : {
// 		},
// 		success : function(data){
// 			$.each(data.articleList, function(entryIndex, entry){
// 				var formatted_date = new Date(entry.article_date);
// 				entryList[entryIndex]=formatted_date.toLocaleDateString();
// 			});
// 			uniqueList=$.unique(entryList);
			
// 			var size=uniqueList.length;
			
// 			for(; size>0;size--){
// 				html+="<a style='cursor: pointer;' onclick=\"display("+size+",'"+tabname+"')\"><h1>"+uniqueList[size-1]+"</h1></a><br>";
// 				html+="<div id='"+tabname+size+"' style='display:none;'>";
// 				$.each(data.articleList, function(entryIndex, entry){
// 					var formatted_date = new Date(entry.article_date).toLocaleDateString();
// 					if(uniqueList[size-1]==formatted_date)
// 					html+="<a style='cursor: pointer;' class='btn-example' onclick='popupcontent("+entry.article_num+","+entry.scrab_num+")'>"+
// 					"<img src='/closet/mainImageDown.main?article_num="+entry.article_num+"&scrab_num="+entry.scrab_num+"' id='main_img'></a><p>";
// 				});
// 				html+="</div>";
// 			}
// 			$('#'+tabname).html(html);
// 			check="true";
// // 				html+="<h1>"+formatted_date.toLocaleDateString()+"</h1><br>";
// // 				html+="<img src='/closet/mainImageDown.main?article_num="+entry.article_num+"&scrab_num="+entry.scrab_num+"' id='main_img'></a><p></td>";
// // 		});	
// 	  }
// 	});
// };
</script>	
</html>

