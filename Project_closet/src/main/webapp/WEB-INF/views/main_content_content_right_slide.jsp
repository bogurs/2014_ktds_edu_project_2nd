<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/socket.io.js"></script>

	<div id="right_slide">  
	<div id="weatherInform"></div>
    <div id="weather_content"></div>   
   	  <table border="0"> 
     
    	<tr>
    		<td colspan="4" style="font-weight: 800">실시간 코디공유</td>
    	</tr>
               
    	<tr>
        	<td align="center">
        		<img src='/closet/profileImageDown.etc?email=${email}' width='40' height='40'>
        		<a href="javascript:openprofile('${email}')"></a><br>
        	</td>
            <td>${ name}</td>
            <td><textarea cols="35" rows="3" id="chat" onKeyPress='enter();'></textarea></td>
            <td><input type="button" value="send" id="sendBtn" /></td>
        </tr>
            </table> 
</div>
<style>
	#weather_content{
		overflow-y: scroll;
		width: 445px;
		height: 400px;
		background: #d0dcd0;
	}
	#time{
		width: 60px;
	}
</style>

<script>
//엔터시 버튼 클릭과 동일한 효과
function enter(){
	if(event.keyCode==13){
		$("#sendBtn").click();
	}

}
</script>
<script>


	$(document).ready(function() {
		var sessionemail = "${email}";
		var socket = io.connect("http://127.0.0.1:12345");
		socket.on('response', function(msg){	
			if(sessionemail==msg.email){
				var html="<table border='0'><tr><td><input type='text' id='time' value='방금' name='content' disabled='disabled'>";
		       	  html+="<td><textarea cols='33' rows='3'  disabled='disabled'>"+msg.content+"</textarea></td>";
			      html+="<td style='width:47px;'>"+msg.name+"</td>";
			      html+="<td align='center'><img src='/closet/profileImageDown.etc?email="+msg.email+"' width='30' height='30'> <a href='javascript:openprofile('${content.email}')></a></td></td></tr></table>";
			}else{
				var html="<table border='0'><tr><td align='center'><img src='/closet/profileImageDown.etc?email="+msg.email+"' width='30' height='30'> <a href='javascript:openprofile('${content.email}')></a></td>";
		       	  html+=" <td style='width:47px;'>"+msg.name+"</td>";
			      html+="<td><textarea cols='33' rows='3'  disabled='disabled'>"+msg.content+"</textarea></td>";
			      html+="<td><input type='text' id='time' value='방금' name='content' disabled='disabled'></td></tr></table>";
			}
			$("#weather_content").prepend(html);			
		});
		
		// 날씨 코디 정보 최신순, 추천순으로 글 가져오기
	      $.ajax({    	  
	               type : "POST",
	               url:"/closet/weatherStyleRead.etc",
	               async : true,
	               dataType : "json",
	               
	               success : function(data){
	            	   var html="";
	                  $.each(data.weatherStyleReadList, function(entryIndex, entry){
	                	
	                        var fommated_date= new Date(entry.write_date);
	                        if(sessionemail==entry.email){
	                        	html+="<table border='0'><tr><td><input type='text' id='time' cols='1' rows='1' value='"+result(fommated_date)+"'name='content' disabled='disabled'></td>";
		  	      		       	  html+="<td><textarea cols='33' rows='3' disabled='disabled'>"+entry.content+"</textarea></td>";
		  	      			      html+=" <td style='width:47px;'>"+entry.name+"</td>";
		  	      			      html+="<td align='center'><img src='/closet/profileImageDown.etc?email="+entry.email+"' width='30' height='30'> <a href='javascript:openprofile('${content.email}')></a></td></tr></table>";
	                        	
	                        }else{
	                        	html+="<table border='0'><tr><td align='center'><img src='/closet/profileImageDown.etc?email="+entry.email+"' width='30' height='30'> <a href='javascript:openprofile('${content.email}')></a></td>";
		  	      		       	  html+=" <td style='width:47px;'>"+entry.name+"</td>";
		  	      			      html+="<td><textarea cols='33' rows='3' disabled='disabled'>"+entry.content+"</textarea></td>";
		  	      			      html+="<td><input type='text' id='time' cols='1' rows='1' value='"+result(fommated_date)+"'name='content' disabled='disabled'></td></tr></table>";
	                        }
	                      
	                  });
	                  $("#weather_content").html(html);
	               },
	               error : function(xhr){
	                  alert("error html = " + xhr.statusText);
	               }
	      }); 

		$("#sendBtn").bind("click", function() {
			var content = $("#chat").val();
			var name = $("#name").val();
			var email = $("#email").val();
			socket.emit('msg', {"content":content, "name":name, "email":email});
			$("#chat").val('');
		});

	});
    
</script>
