<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
   $(document)
         .ready(
               function() {
                  function traverseFiles(files) {
                     var fileInfo;
                     $("#file-list").html("");
                     for (var i = 0; i < files.length; i++) {
                        var reader = new FileReader();
                        reader.readAsDataURL(files[i]);
                        reader.onload = function(e) {
                           fileInfo = "<img src='"+e.target.result+"' width='200px' height='200px'/>";
                           $("#file-list").prepend(fileInfo);
                        };
//                         fileInfo = "<br><br>" + "Name: "
//                               + files[i].name + "<br><br>";
                        $("#file-list").append(fileInfo);
                     }
                  }
                  $("#files-upload").change(function() {
                     traverseFiles(this.files);
                  });
               });
   //  function cancel(name){
   //      var id='#'+name+'';
   //     alert(id);
   //     $(id).remove();
   // }
</script>
<title>Insert title here</title>
</head>
<body>
<form action="/closet/updateprofile.etc" method="post" enctype="multipart/form-data">
 <span class="b-close"><span>X</span></span>


<c:forEach var="profile" items="${profile}">
<td align="center" colspan="2">
               <input id="files-upload" name="file" type="file" multiple accept="image/*">
               <div id="file-list"align="center">
               <img src='/closet/profileImageDown.etc?email=${profile.email}'width='200' height='200'>
               </div>
</td>


<div id="profile" align="center">
<table>
<tr><td>이름 : <input type="text" value="${profile.name}" disabled="disabled" ></td></tr>
<tr><td>email : <input type="text" value="${profile.email}" disabled="disabled"></td></tr>
<tr><td>cm / kg : <input type="text" name="cm"  style="width:40px">&nbsp;/&nbsp;<input type="text" name="kg"style="width:40px"></td></tr>
<tr><td>상태 메세지 : <textarea cols=15 rows=2 id="status" name="status"></textarea></td></tr>
<tr><td><input type="submit" value="수정"></td></tr>
</table>
</div>
</c:forEach>
</form>
</body>  

</html>