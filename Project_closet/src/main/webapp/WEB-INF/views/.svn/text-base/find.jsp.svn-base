<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전국패션자랑</title>
<script type="text/javascript" src="resources/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="resources/css/jquery.autocomplete.css"/>
<link href="resources/css/fd_content.css" rel="stylesheet" type="text/css" />

<script>   
   function funLoad() {
      var height = parseInt($("#content > #main_section").height());
      if(height>976){
         $('#content').css({
            'height' : height + 'px'
         });
      }else{
         $('#content').css({
            'height' : '976px'
         });
      }
   }
   window.onload = funLoad;
   function searchfriend(){
      $.ajax({
         url:'searchid.etc',
         type:'POST',
         data:{
            keyword:$('#keyword').val()
         },
         success : function(data){
            var Tag = '<table border="1">';
             $.each(data.searchid,function(entryIndex, entry){   
                     var Tag = '<table border="1">';
                      $.each(data.searchid,function(entryIndex, entry){   
                            Tag+='<td>여기프로필사진자리</td>&nbsp;&nbsp;&nbsp;<td>'+entry.name+'</td>';  
                            Tag+="<input type='hidden' class='hidden' name='email' value='"+entry.email+"'>";
                            Tag+="<td><input type='button' onclick=reqfriend('"+entry.email+"','"+entry.name+"') value='친구요청'></td>";
                            Tag+="</tr>";         
                        });
                        Tag += '</table>';
                         $("#ss").html(Tag); 
                  
               });

               Tag += '</table>';
         }
      });
   }
   function reqfriend(fdemail,fdname){
      $.ajax({         
         url:'/closet/reqfriend.etc',
         type:'POST',
         data:{
            fdemail: fdemail,
            fdname: fdname
               },
         success : function(data){
            alert(data.status);
               },
         error : function(error){
             alert("error : " + error);
         }
      });
   }


   function clearText(thefield){ 
          if (thefield.defaultValue==thefield.value) 
          thefield.value = "" 
          } 
</script>
</head>
<body>
<div id="left_slide">

			<a href="/closet/closet.main">친구찾기</a>
			<br>
			<a href="/closet/follow.etc">내 친구</a>

</div>
     
        <div id="main_section">
           <input type="text" size="20" id="keyword" onFocus="clearText(this)" value="이름 또는 이메일"><input type="button" value="찾기" onclick="searchfriend()">
         <div id="ss"></div>
    
   <td>내친구목록</td>
   <br>
    <c:forEach var="Friend" items="${friendList}">
     <tr>
     <td>${Friend.fdname}&nbsp;&nbsp;&nbsp;${Friend.fdemail}</td>
     <br>
    </c:forEach>
       
        </div>
   </div>

</body>
</html>