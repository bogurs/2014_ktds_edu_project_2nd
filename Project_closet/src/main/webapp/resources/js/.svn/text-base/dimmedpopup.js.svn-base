function popupcontent(article_num,scrab_num){
   $.ajax({
      type : "post",
      url : "/closet/content.main",
      async : true,
      dataType : "json",
      data : {
         "article_num" : article_num,
         "scrab_num" : scrab_num
	   },   
	   success : function(data){
//		   alert($("#tab").val());
//           alert($("#gender").val());
	          var html ="<table border=0 width=400 height=400 style='float:left'>";
	     	  html += "<tr><td align='center'><a style='cursor: pointer;' class='btn-example'  onclick='prev_btn()'><img src='resources/img/left.jpg' style='width: 40px; height: 40px; cursor: pointer;' id='pre' class='btn'/></a></td>";
	          html +="<td align='center'><ul id='slider'>";

	          
	     	  $.each(data.popupimageList, function(entryIndex, entry){   
		           html +="<li><img src='/closet/contentImageDown.main?image_num="+entry.image_num+"'><br><br><hr color='#0ECFB5'>";
		           if(data.sessionid != data.id){
		        	   html +="<input type='button' value='스크랩하기' onclick=\"javascript:scrab_writeForm("+ data.popupcontent.article_num+","+data.popupcontent.scrab_num+");\">";
		           }
		           html +="<input type='button' value='"+entry.btnVal+"' id='"+entry.image_num+"favoriteImgBtn' onclick=likeImage("+entry.image_num+",'"+data.popupcontent.name+"','"+data.popupcontent.email+"','"+data.popupcontent.article_num+"')>";
		           html +="이 사진을 좋아요 한 사람: <a href='javascript:getNamesImage("+entry.image_num+")' id="+entry.image_num+">"+entry.favorite+"명</a></li>";
	           });
	           html +="<td align='center'><a style='cursor: pointer;' class='btn-example'  onclick='next_btn()'><img src='resources/img/right.jpg' style='width: 40px; height: 40px; cursor: pointer; ' id='next' class='btn' /></a></td>";
	           html +="</li></ul></tr></table>";
	           
	           html +="<table border=0 width=550 height=400 style='float:right; BORDER-COLLAPSE:collapse; table-layout:fixed'>";
	           var formatted_date = new Date(data.popupcontent.article_date);
	           if(data.brand.jacket==null) data.brand.jacket="";
	           if(data.brand.tshirt==null) data.brand.tshirt="";
	           if(data.brand.pants==null) data.brand.pants="";
	           if(data.brand.sneakers==null) data.brand.sneakers="";
	           if(data.brand.socks==null) data.brand.socks="";
	           if(data.popupcontent.content==null) data.popupcontent.content="";
	           if(data.popupcontent.tag==null) data.popupcontent.tag=""; 
	           html += "<tr><td align='right 'height=50><img src='/closet/profileImageDown.etc?email="+data.popupcontent.email+"'width='60' height='60'></td><td>"+data.popupcontent.name+"<br>"+formatted_date.toLocaleString()+"</td></tr>";
	           html +="<tr><td colspan='2'><hr color='#0ECFB5'></td></tr>";
	           html +="<input type=hidden value="+data.popupcontent.article_num+" name='article_num'>";
	           html +="<input type=hidden value="+data.popupcontent.tab+" id='tab' name='tab'>";
	           html +="<input type=hidden value="+data.popupcontent.gender+" id='gender' name='gender'>";
	           
	           
	           html +="<tr><td width='50%' height=150 style='border-right: 3px solid #0ECFB5;'><img src='resources/img/write_etc_jacket.jpg' width=30 height=30> 겉옷 : "+data.brand.jacket+"<br>" +
	           		"<img src='resources/img/write_etc_tshirt.jpg' width=30 height=30> 상의 : "+data.brand.tshirt+"<br>" +
	           		"<img src='resources/img/write_etc_pants.jpg' width=30 height=30> 하의 : "+data.brand.pants+"<br>" +
	           		"<img src='resources/img/write_etc_sneakers.jpg' width=30 height=30> 신발 : "+data.brand.sneakers+"<br>" +
	           		"<img src='resources/img/write_etc_socks.jpg' width=30 height=30> 악세 : "+data.brand.socks+"</td>"
	           html +="<td align='center' width='50%'>"+data.popupcontent.content+"</td></tr>";
	           html +="<tr><td colspan='2'><hr color='#0ECFB5'></td></tr>";
	           html +="<tr><td colspan='2'>태그 : "+data.popupcontent.tag+"</td></tr>";
	           html +="<tr><td colspan='2'><hr color='#0ECFB5'></td></tr>";
	           html +="<tr><td colspan='2' height=50px;><div id='comment_show'></div></td></tr>";
	          
	           html +="<tr><td colspan='2' height=2px;><input type='text' id='comment_content' name='comment' style='width:90%' onKeyPress='enter();' value='댓글을 달아보세요.' onFocus='clearText(this)'>&nbsp<input type='button' id='enter' onclick=writebtn("+data.popupcontent.article_num+",'"+data.popupcontent.name+"','"+data.popupcontent.email+"') value='등록' ></td></tr>";
	           html +="<span class='cbtn'>X</span></table>";
	           $("#pop-conts").html(html);
	           
	           commentbutton(data.popupcontent.article_num);
	           
	           layer_open('layer2');
	           $("#slider li:first").css("display", "block");
	           if($("#slider li").size()> 1)$(".btn").css("display", "inline");
	     },
	     error : function(xhr) {
	    	 alert("error html=" + xhr.statusText);
	     }
   });      
};

function coordiType() {
	var html="";
	if($("#tab").val()==0){
		html+="<intput type='text' value='일반코디'><br>";
	}
	if($("#tab").val()==1){
		html+="<intput type='text' value='장소코디'><br>";
	}
}

//function addItem() {
//	if($("#gender").val()==1 || $("#gender").val()==2) {
//		var html="";
//		html+=
//	}
//}

//테스트박스
function clearText(field)
{
  if(field.defaultValue==field.value)
   field.value="";
}

//엔터시 버튼 클릭과 동일한 효과
function enter(){
	if(event.keyCode==13){
		$("#enter").click();
	}
}
     
var time = 5;
var idx = idx2 = 0;
function prev_btn() {
    if($("#slider li").size() > 1) {
        idx2 = (idx - 1) % $("#slider li").size();
        if(idx2 < 0)idx2 = $("#slider li").size() - 1;
        $("#slider li:hidden").css("left", "-"+$("#slider").width()+"px");
        $("#slider li:eq("+idx+")").animate({ left: "+="+$("#slider").width()+"px" }, time, function() {
            $(this).css("display", "none").css("left", "-"+$("#slider").width()+"px");
        });
        $("#slider li:eq("+idx2+")").css("display", "block").animate({ left: "+="+$("#slider").width()+"px" }, time);
        idx = idx2;
    }
}
function next_btn() {
    if($("#slider li").size() > 1) {
       idx2 = (idx + 1) % $("#slider li").size();
        $("#slider li:hidden").css("left", $("#slider").width()+"px");
        $("#slider li:eq("+idx+")").animate({ left: "-="+$("#slider").width()+"px" }, time, function() {
            $(this).css("display", "none").css("left", $("#slider").width()+"px");
        });
        $("#slider li:eq("+idx2+")").css("display", "block").animate({ left: "-="+$("#slider").width()+"px" }, time);
        idx = idx2;
       }
   }
function layer_open(el){
      var temp = $('#' + el);
      var bg = temp.prev().hasClass('bg');   //dimmed 레이어를 감지하기 위한 boolean 변수
      if(bg){
         $('.layer').fadeIn();   //'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다. 
      }else{
         temp.fadeIn();
      }

      // 화면의 중앙에 레이어를 띄운다.
      if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
      else temp.css('top', '0px');
      if (temp.outerWidth() < $(document).width() ) temp.css('margin-left', '-'+temp.outerWidth()/2+'px');
      else temp.css('left', '0px');

      temp.find('.cbtn').click(function(e){
         if(bg){
            $('.layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다.
         }else{
            temp.fadeOut();
         }
         e.preventDefault();
      });

      $('.layer .bg').click(function(e){   //배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
         $('.layer').fadeOut();
         e.preventDefault();
         idx=0;
      });
   }      

function likeImage(image_num,fdname,fdemail,article_num){
   if($("#"+image_num+"favoriteImgBtn").val()=="좋아요"){
      $("#"+image_num+"favoriteImgBtn").val("좋아요 취소");
   }
   else{
      $("#"+image_num+"favoriteImgBtn").val("좋아요");
   }
   
   $.ajax({
      url : "/closet/likeImage.main",
      type : "post",
      data : {
         "image_num" : image_num,
         "fdname" : fdname,
         "fdemail" : fdemail,
         "article_num":article_num
      },
      success : function(data){
         $("#"+image_num).html(data.like_num+"명");
         
//         var html = "<table width=40 height=40 border=0 style='vertical-align:middle;'>";
//         $.each(data.imageList, function(entryIndex, entry){   
//            html +=   "<tr><td align='center'><a style='cursor: pointer;' class='btn-example' onclick='popupcontent(${image.article_num},0)'>";
//            html +=   "<img src='/closet/contentImageDown.main?image_num="+entry.image_num+"' id='main_img'></a></td></tr></table>";
//         });
//         
//         $("#right_slide .content").html(html);
      }
   });
};   

function getNamesImage(image_num){
   $.ajax({
      url : "/closet/getImageNames.main",
      type : "post",
      data : {
         "image_num" : image_num
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
};