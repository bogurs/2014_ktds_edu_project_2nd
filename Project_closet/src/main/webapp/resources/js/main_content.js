   function state(){
      var form = document.searchForm;      
      // 글내용, 작성자, 댓글, 태그 - text box 보여줌
      if(form.searchOption.selectedIndex==0 || form.searchOption.selectedIndex==1 || form.searchOption.selectedIndex==2 || form.searchOption.selectedIndex==4){
         form.searchContent.style.display="block";
         form.searchCategory.style.display="none";
         form.searchGender.style.display="none";
         form.searchAge.style.display="none";
      }
      // 카테고리 - select box
      else if(form.searchOption.selectedIndex==3){
         form.searchContent.style.display="none";
         form.searchCategory.style.display="block";
         form.searchGender.style.display="none";
         form.searchAge.style.display="none";
      }
      // 성별 - select box
      else if(form.searchOption.selectedIndex==5){
   	  	 form.searchContent.style.display="none";
         form.searchCategory.style.display="none";
         form.searchGender.style.display="block";
         form.searchAge.style.display="none";
      }
      // 연령대 - select box
      else if(form.searchOption.selectedIndex==6){
   	  	 form.searchContent.style.display="none";
         form.searchCategory.style.display="none";
         form.searchGender.style.display="none";
         form.searchAge.style.display="block";
      }
   }
   
   // 최신순 보기 버튼을 클릭했을 때 컨트롤러단으로 요청을 보내주는 함수
   function orderByDate(){
	   var form = document.searchForm; 
	   if(form.searchOption.selectedIndex==0 || form.searchOption.selectedIndex==1 || form.searchOption.selectedIndex==2 || form.searchOption.selectedIndex==4)
		   window.location.href = "/closet/search.main?searchOption="+$('#searchOption').val()+"&searchContent="+$('#searchContent').val();
	   else if(form.searchOption.selectedIndex==3)
		   window.location.href = "/closet/search.main?searchOption="+$('#searchOption').val()+"&searchCategory="+$('#searchCategory').val();
	   else if(form.searchOption.selectedIndex==5)
		   window.location.href = "/closet/search.main?searchOption="+$('#searchOption').val()+"&searchGender="+$('#searchGender').val();
	   else if(form.searchOption.selectedIndex==6)
		   window.location.href = "/closet/search.main?searchOption="+$('#searchOption').val()+"&searchAge="+$('#searchAge').val();
   }
   
   // 인기순 보기 버튼을 클릭했을 때 컨트롤러단으로 요청을 보내주는 함수
   function orderByFavorite(){
	   var form = document.searchForm; 
	   if(form.searchOption.selectedIndex==0 || form.searchOption.selectedIndex==1 || form.searchOption.selectedIndex==2 || form.searchOption.selectedIndex==4)
		   window.location.href = "/closet/searchOrderbyHot.etc?searchOption="+$('#searchOption').val()+"&searchContent="+$('#searchContent').val();
	   else if(form.searchOption.selectedIndex==3)
		   window.location.href = "/closet/searchOrderbyHot.etc?searchOption="+$('#searchOption').val()+"&searchCategory="+$('#searchCategory').val();
	   else if(form.searchOption.selectedIndex==5)
		   window.location.href = "/closet/searchOrderbyHot.etc?searchOption="+$('#searchOption').val()+"&searchGender="+$('#searchGender').val();
	   else if(form.searchOption.selectedIndex==6)
		   window.location.href = "/closet/searchOrderbyHot.etc?searchOption="+$('#searchOption').val()+"&searchAge="+$('#searchAge').val();
   }

   // 글 좋아요 처리를 위한 함수
   function likeArticle(article_num, fdname, fdemail){
      if($("#"+article_num+"favoriteArticleBtn").val()=="좋아요"){
         $("#"+article_num+"favoriteArticleBtn").val("좋아요 취소");
      }
      else{
         $("#"+article_num+"favoriteArticleBtn").val("좋아요");
      }
      
      $.ajax({
         url : "/closet/likeArticle.main",
         type : "post",
         data : {
        	 "fdname" :fdname,
        	 "fdemail" :fdemail,
        	 "article_num" : article_num
         },
         success : function(data){
            $("#"+article_num).html(data.like_num+"명");
         }         
      });
   };
   
   // 글 삭제를 위한 함수
   function deleteArticle(article_num, status,email){
      $.ajax({
         url : "/closet/deleteArticle.main",
         type : "post",
         data : {
            "article_num" : article_num,
            "email" : email
         },
         success : function(data){
     
          window.location.reload();
         }
      });
   };
   
   // 글 좋아요 누른 사람 목록 가져오기
   function getNamesArticle(article_num){
      $.ajax({
         url : "/closet/getArticleNames.main",
         type : "post",
         data : {
            "article_num" : article_num
         },
         success : function(data){
            var htmlStr = "";
            $.each(data.nameList, function(entryIndex, entry) {
               htmlStr += entry;
               htmlStr += " ";
            });
            if(htmlStr.length!=0){
               $("#gil5").html(htmlStr);
                 $('#popup5').bPopup();
            }
         }
      });
   }
   
  function scrab_writeForm(article_num, scrab_num){
	    $('#popup4').bPopup({
	       	loadUrl: "scrab_writeForm.main?article_num="+article_num+"&scrab_num="+scrab_num
	    });
	}
   
   // content height 항상 재조정
   function funLoad() {
	  var table_length = document.getElementsByName("main_article").length;
	  var height=Math.ceil(table_length/3)*470;
	  height+=200;
      if(height>1000){
         $('#content').css({
            'height' : height + 'px'
         });
      }else{
         $('#content').css({
            'height' : '1000px'
         });
      }
   }
   window.onload = funLoad;
      
   
   
   
   $(document).ready(function() {
		//위치 API
		 var nav = null; 
		   if (nav == null) {
		       nav = window.navigator;
		   }
		   if (nav != null) {
		       var geoloc = nav.geolocation;
		       if (geoloc != null) {
		           geoloc.getCurrentPosition(successCallback);
		       }
		       else {
		           alert("geolocation not supported");
		       }
		   }
		   else {
		       alert("Navigator not found");
		   }
		 function successCallback(position)
		 {
		    weatherapi(position.coords.latitude,position.coords.longitude);
		 }
		 
     // 검색 후 검색조건을 유지하기 위한 처리
      var setOption = $('#setOption').val() - 1;
      if(setOption < 0)
         setOption = 0;
      document.searchForm.searchOption.options[setOption].selected = true;
      
      state();
      
      $('#searchContent').val($('#setContent').val());
      
      var setCategory = $('#setCategory').val();
      if(setCategory == '')
    	  setCategory = 0;
      document.searchForm.searchCategory.options[setCategory].selected = true;
      
      var setGender = $('#setGender').val();
      if(setGender == '')
    	  setGender = 0;
      document.searchForm.searchGender.options[setGender].selected = true;
      
      var setAge = $('#setAge').val() - 1;
      if(setAge < 0)
    	  setAge = 0;
      document.searchForm.searchAge.options[setAge].selected = true;
      
            
   }); 
   
   //날짜 

//   	gapTime = function () {return this.today.getTime() - this.getTime();};
//   Date.prototype.gapMin = function() {return Math.round(this.gapTime() / (1000*60));};
//   Date.prototype.gapHour = function() {return Math.round(this.gapTime() / (1000*60*60));};
//   Date.prototype.gapDay = function() {return Math.round(this.gapTime() / (1000*60*60*24));};
//   function dateFromISO8601(isostr) {var p = isostr.match(/\d+/g);return new Date(p[0], p[1] - 1, p[2], p[3], p[4], p[5]);}
   function timeHumanizer(save_date) {
	   var sys_date= new Date();
	   var gapTime=(sys_date.getTime()-save_date.getTime());
	   var gapMin=Math.round(gapTime/ (1000*60));
	   var  gapHour=Math.round(gapTime / (1000*60*60));
	   var gapDay=Math.round(gapTime / (1000*60*60*24));
	    var result = null;
	    ampm = '오전';
	    if (gapHour >= 12) {ampm = '오후';}
	    if (gapHour > 12) {gapHour = gapHour - 12;}
	    if (gapDay === 0) {result = "오늘 " + ampm;}
	    if (gapDay === 1) {result = "어제 " + ampm;}
	    if (gapDay > 1 & gapDay <= 10) {result = gapDay + "일 전 ";}
	    if (gapHour <= 12) {result = gapHour + "시간 전";}
	    if (gapMin <= 59) {result = gapMin+ "분 전";}
	    if (gapMin <= 5) {result = "방금";}
	    return result;
	}
   function result(save_date) {
	    var result = timeHumanizer(save_date);
	    if (result) return result;
   }
      //end
      
      //weather 입력 폼에 사진 올리면 실시간 갱신해서 사진 보여주기
      function weatherapi(latitude,longitude){
    	  var weather_s = '<table border="0" width="445" align="center">';
      $.ajax({ 	  
  	  	// 결과를 한글로 받을 수 있다.
  	  url : "http://api.wunderground.com/api/bac669145ccf605b/geolookup/conditions/lang:KR/q/"+latitude+","+longitude+".json",
  	  dataType : "jsonp",
  	  success : function(parsed_json) {
  	  	 // location
  	  	 var location = parsed_json.location;
  	  	 var observ =parsed_json.current_observation; 
  	  	 var fommated_date= new Date(observ.local_time_rfc822);
  	
  	   // 관측지에 대한 정보
   		// 날씨정보
  	  	 var icon_url='http://icons.wxug.com/i/c/a/'+observ.icon+'.gif';
  	  	weather_s +='<tr align="right"><th colspan="3">'+	fommated_date.toLocaleTimeString()+'최신자</th>'+
		'<tr align="center"><th>현재위치</th><th>현재날씨</th><th>어제날씨</th></tr>';
  	  	 weather_s+='<tr align="center">';
  	  	 weather_s+= '<td>'+location.city+'</td>';
  	 	 weather_s+= '<td><img src="'+icon_url+'"/><br>'+observ.weather+ " ("+observ.temp_c+'C)</td>';
  	  }
  	  });
      
      
      $.ajax({ 	  
    	  	// 결과를 한글로 받을 수 있다.
    	  url : "http://api.wunderground.com/api/bac669145ccf605b/yesterday/conditions/lang:KR/q/"+latitude+","+longitude+".json",
    	  dataType : "jsonp",
    	  success : function(parsed_json) {
    	  	 // location
    		  var observations=0;
    		  var fommated_date= new Date();
    		  if(16<=fommated_date.getHours()<21){
    			   observations=parsed_json.history.observations[16];}
    		  else{
    			  observations=parsed_json.history.observations[fommated_date.getHours()];
    		  }
    	   // 관측지에 대한 정보
     		// 날씨정보
    			 var icon_url='http://icons.wxug.com/i/c/a/'+observations.icon+'.gif';
    	  	 weather_s+= '<td><img src="'+icon_url+'"/><br>'+observations.conds+ " ("+observations.tempm+'C)</td>';
    	  	 weather_s += '</tr>';
    	  	 weather_s += '</table>';
    		 $("#weatherInform").html(weather_s);
    	  }
    	  }); 
   };


      