<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Daily Codi</title>
<link href="resources/css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/button.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- <script src="resources/js/join.js"></script> -->
<script src="resources/js/jquery.validate.js"></script>

<script>
var passcheck=false;
var idcheck=false;

	
function enter(){
	if(event.keyCode==13){
		$("#enter").click();
	}
}

function gojoin() {
	var name = $("input[name=name]").val();
	var email = $("input[name=email]").val();
	var pass = $("input[name=pass]").val();
	var year = $("select[name=year]").val();
	var month = $("select[name=month]").val();
	var day = $("select[name=day]").val();
	var gender = $("input:radio[name=gender]:checked").val();
	$.ajax({
		url : "/closet/join.etc",
		type : "post",
		data : {
			"name" : name,
			"email" : email,
			"pass" : pass,
			"year" : year,
			"month" : month,
			"day" : day,
			"gender" : gender
		},
		success : function(data){
			if(data.result == true){
				alert("가입완료");
				location.href = "/closet/main_content.etc";
			} else{
				alert("가입실패");
			}
		},
		error : function(error){
			alert("error : " + error);
		}
	});
}


	$(document).ready(function() {		
		$("#email").keyup(function(){
			$.ajax({
					type:'POST',
					url:'searchId.etc',
					data: {
						   email:$('#email').val()		
					},
						success : function(data){
						
							if(data.status==1){	
								$("#status1").css("color","red").html("존재 ID");  
							}
							else if(data.status==0){ $("#status1").html("");  
							idcheck=true;}
						}
				
			});		
		});

		
		
		$("input[name=loginBtn]").on("click", function() {
			var email = $("input[name=login_email]").val();
			var pass = $("input[name=login_pass]").val();
			$.ajax({
				url : "/closet/login.etc",
				type : "post",
				data : {					
					"email" : email,
					"pass" : pass,
				},
				success : function(data){
					if(data.login_error == 1){
						alert("아이디를 입력하세요.");
					} else if(data.login_error == 2){
						alert("비밀번호를 입력하세요.");						
					} else if(data.login_error == 3){
						alert("비밀번호가 틀립니다.");
						$("#login_pass").html("");
					} else if(data.login_error == 4){
						alert("존재하지 않는 아이디입니다.");
						window.location.reload();
					} else{
						location.href = "/closet/main_content.etc";
					}
				},
				error : function(error){
					alert("error : " + error);
				}
			});
		});
	});

	 $(document).ready(function(){
		  $("#gojoin").validate({
              rules: {
                  	name : {
                      required: true,
                   },
                   pass : {
                      required: true,
                      equalTo: "#pass2"
                  },
                  email:{
                	  required:true,
                	  email:true,
                  },
              
                  

              },
              messages: {
                  name : {
                      required: "입력바람",
                 },
                   pass : {
                	 required: "입력바람",
                	 equalTo:"불일치"
                      
                  },
              	email:{
              		required:"입력바람",
              		email:"형식 안맞음",
              	}


          }
      });
  });
</script>
</head>

<body>

	<!-- header -->	
	<div id="headerWrapper">
    <div id="main_header">   
    <br>     
	       <a href="/closet/main.etc" class="main_logo_a">
	        <img src="resources/img/daily.png" style="width:350px; height:60px">
	       </a>        
        <div id="nav_login">
        
        	<table border="0">
        		<tr>
        			<td>아이디(이메일)</td>
        			<td>비밀번호</td>
        			<td rowspan="2"><input type="button" value="로그인" name="loginBtn" class="button" id='enter'></td>
        		</tr>
        		<tr>
        			<td><input type="text" name="login_email"></td>
        			<td><input type="password" name="login_pass" id="login_pass" onKeyPress='enter();'></td>
        		</tr>
        	</table>          
        </div>        
    </div>
    </div>
 
 	<!-- content -->
 	<div id="content" >
 	
 		<div id="contentWrapper">
 		<div id="contentWrapperUnder">
        
        <div id="main_section">
        <div id="main_sectionUnder">
        <div id="advice">내 옷장을 친구들과 공유하세요.</div>
        <img src="/closet/resources/img/closet.jpg" width=370px height=480px;>
        </div>
        </div>
        
        <div id="main_aside">
           <h1>회원가입</h1>
           
           <form action="javascript:gojoin()" id="gojoin">
          <table border="0" width="560px">
           <tr>
           	<th align="left"style="width: 140px;">이름 : </th>
           	<td colspan="2"><input type="text" name="name" id="name" style="width:190px; height:30px; font-size:15pt;"></td>
           </tr>
           
           <tr>
           	<th align="left">이메일 : </th>
           	<td><input type="text" name="email" id="email" style="width:190px; height:30px; font-size:15pt;"></td><td><div id="status1"></div></td>
           	<td><div id="errorEmail"></div></td>
           </tr> 
                  
           
           <tr>
           	<th align="left">비밀번호 : </th>
           	<td colspan="2"><input type="password" name="pass" id="pass1"style="width:190px; height:30px; font-size:15pt;"></td>         	
           </tr>
           
           <tr>
           <th align="left">비밀번호 재입력 : </th>
           	<td><input type="password" name="pass1" id="pass2" style="width:190px; height:30px; font-size:15pt;"></td><td><div id="status2"></div></td>     
           	<td><div id="differPass"></div></td>   	
           </tr>           
                      
           <tr>
           <th align="left">생일 :</th>
           <td colspan="3">
	           	<select name="year" id="year" style="width:80px; height:25px; font-size:15pt;">
	           		<jsp:include page = "/WEB-INF/views/select_year.jsp" flush="true"/> 
	           	</select>
	           	           	<select name="month" id="month" style="width:80px; height:25px; font-size:15pt;">
	           		<jsp:include page = "/WEB-INF/views/select_month.jsp" flush="true"/> 
          	 	</select>
          	 
	           	<select name="day" id="day" style="width:80px; height:25px; font-size:15pt;">
	           		<jsp:include page = "/WEB-INF/views/select_day.jsp" flush="true"/> 
	           	</select>
	           	<div id="dddd"></div>
           	</td>
           </tr>
           
           <tr>
           	
           </tr>
           
           <tr>
           	<td colspan="3" align="center">
	           	<input type="radio" name="gender" value="1" style="width:80px; height:25px;"><font size=5pt>남성</font>
	           	<input type="radio" name="gender" value="2" style="width:80px; height:25px;"><font size=5pt>여성</font>
           	</td>
           </tr>
           
           <tr>
           	<td colspan="3" align="right">
	          <input type="submit" value="가입하기" name="joinBtn" id="gojoin">
<!-- 	           class="button red shield" -->
	        </td>
           </tr>
          </table>
         </form>
           
           <br>
           <hr>
        </div>
      </div>
    </div>
        
    </div>
    
    <!-- footer -->
    <div id="main_footer">
        <h3>한국어</h3>
        <hr/>
        <address>데일리코디 ⓒ 2014. / Daily Codi ⓒ 2014. </address>
    </div>
 
 
</body>
</html>