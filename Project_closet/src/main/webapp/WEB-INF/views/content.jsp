<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="resources/js/comment_jquery.js"></script>
<script src="resources/js/dimmedpopup.js"></script>
</head>
<body>

   <!-- 스크랩을 위한 값 심기 -->
   <div class="layer" >
      <div class="bg"></div>
         <div id="layer2" class="pop-layer"> 
               <div class="pop-container"  >
                  <div id="pop-conts" >
     
				  </div>	
            	  </div>
            	 
            <!--// content-->
         </div>
    </div>
	<div id="input2">
		<table border="1">
			<tr>
				<td><input type="text" id="content" disabled="disabled">
				</td>
			</tr>
		</table>
	</div>
</body>
<style type="text/css">

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
   width: 480px;
   height: 600px;
   overflow-x: hidden
}

#slider li {
   display: none;
   position: absolute;
   left: 0;
   top: 0
}

#slider img {
   width: 480px;
   height: 500px
}

#input2 {
	position: absolute;
	left: 0px;
	top: 0px;
	display: none;
}
.layer {display:none; position:fixed; _position:absolute; top:0; left:0; width:100%; height:100%; z-index:100;}
.layer .bg {position:absolute; top:0; left:0; width:100%; height:100%; background:#000; opacity:.5; filter:alpha(opacity=50);}
.layer .pop-layer {display:block;}
.pop-layer {display:none; position: absolute; top: 50%; left: 50%; width: 1200px; height:600px;  background-image:url('resources/img/main.jpg'); border: 5px solid #1DE9C0; z-index: 10;} 
.pop-layer .pop-container {padding: 20px 25px;}
.pop-layer p.ctxt {color: #666; line-height: 25px;}
.pop-layer .btn-r {width:100px; height:100px; left:500px; top:300px}
.cbtn {position: absolute; right: 5px; top: 5px; padding: 5px; display: inline-block; cursor: pointer;}   
.cbtn:hover {border: 1px solid #091940; background-color:red; color:#fff;}
</style>
</head>
</html>