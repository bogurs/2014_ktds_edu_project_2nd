<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Daily Codi</title>
<link href="resources/css/main_content.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/button.css" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/main_content.js"></script>

</head>

<body>
<!-- 기본 값 심기 -->
<input type="hidden" id="email" name="email" value="${email}">
<input type="hidden" id="name" name="name" value="${name}">
<input type="hidden" id="setOption" name="setOption" value="${search.searchOption}">
<input type="hidden" id="setContent" name="setContent" value="${search.searchContent}">
<input type="hidden" id="setCategory" name="setCategory" value="${search.searchCategory}">
<input type="hidden" id="setGender" name="setGender" value="${search.searchGender}">
<input type="hidden" id="setAge" name="setAge" value="${search.searchAge}">
<input type="hidden" id="html" name="html" value="${html}">

   <!-- main_content_header -->
   <jsp:include page="/WEB-INF/views/main_content_header.jsp" flush="true" />

   <!-- main_content_content -->
   <div id="content">
 

      <jsp:include page = "/WEB-INF/views/main_content_content_main_section.jsp" flush="true"/>
      <jsp:include page = "/WEB-INF/views/main_content_content_right_slide.jsp" flush="true"/>
      
   </div>
   <jsp:include page="/WEB-INF/views/content.jsp" flush="true" />
</body>
</html>