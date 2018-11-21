 function deleteArticle(article_num, email){
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
  
  function deletelikeArticle(article_num, email){
	 $.ajax({
	     url : "/closet/deletelikeArticle.main",
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
	  
  function deletelikeImage(image_num, email){
	 $.ajax({
	     url : "/closet/deletelikeImage.main",
	     type : "post",
	     data : {
	        "image_num" : image_num,
	        "email" : email
	         },
	         success : function(data){
	     
	          window.location.reload();
	         }
      });
  };
function gocloset(email){
	location.href='closet.main?email='+email+'';	
}
function openprofile(email){
   $.ajax({
      url:'profileview.etc',
      type:'POST',
      data:{
         email:email
      },
      success : function(data){
         var html='';
         $.each(data.profile,function(entryIndex, entry){   
        		html += "<img src='/closet/profileImageDown.etc?email="+entry.email+"'withd='200' height='200'><br>";
                html += entry.name+'<br>';
                html += entry.email+'<br>';
//                html += "<input type='button' value='팔로우 신청' onclick=reqfriend('"+entry.email+"','"+entry.name+"')>";
                html += "<input type='button' value='옷장 구경' onclick=gocloset('"+entry.email+"')>";
                
       });
         $("#gil2").html(html);
         $('#popup2').bPopup();
      }   
   });
}

//function reqfriend(fdemail,fdname){
//    $.ajax({         
//       url:'/closet/addfollow.etc',
//       type:'POST',
//       data:{
//          fdemail: fdemail,
//          fdname: fdname
//             },
//       success : function(data){
//    	 
//    	   window.onload=following();
//    	   alert("신청완료!!");
//        
//             },
//       error : function(error){
//           alert("error : " + error);
//       }
//    });
// }
//
//function deletefollow(fdemail){
//	 $.ajax({         
//	       url:'/closet/deletefollow.etc',
//	       type:'POST',
//	       data:{
//	         fdemail: fdemail
//	         
//	             },
//	       success : function(data){
//	    	  
//	    
//	    	  alert("팔로잉 끊기완료!!");
//	          window.onload=following();
//	         
//	             },
//	       error : function(error){
//	           alert("error : " + error);
//	       }
//	    });
//	 }	

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
                    	
                           Tag+='<td> <a href=\"javascript:openprofile(\''+entry.email+'\')">';
                           Tag+='<img src="/closet/profileImageDown.etc?email='+entry.email+'"width="50" height="50">'+entry.name+'</td></a>';  
                           Tag+="<input type='hidden' class='hidden' name='email' value='"+entry.email+"'>";
                           
                           Tag+="</tr>";         
                       });
                       Tag += '</table>';
                    	
                        $("#gil1").html(Tag); 
                 
              });

              Tag += '</table>';
              $("#popup1").bPopup();
        }
     });
  }

 function following(email){
		$.ajax({ 
			type : 'post',
			url : 'follow.etc',
			async : true,
			data : {email : email 
				},
			error : function(xhr, status) {alert('Unknown error ' + status); },
			success : function(data) {
				$("#content1").html(data); 
				$("#tabs li:nth-child(1) a").css("background", "#ddd");
				$("#tabs li:nth-child(1) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(2) a").css("background", "#ddd");
				$("#tabs li:nth-child(2) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(3) a").css("background", "#fff");
				$("#tabs li:nth-child(3) a::after").css("background", "#fff");
				$("#tabs li:nth-child(4) a").css("background", "#ddd");
				$("#tabs li:nth-child(4) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(5) a").css("background", "#ddd");
				$("#tabs li:nth-child(5) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(6) a").css("background", "#ddd");
				$("#tabs li:nth-child(6) a::after").css("background", "#ddd");
				} 
			}); 
	}

 function follower(email){
		$.ajax({ 
			type : 'post',
			url : 'follower.etc',
			async : true,
			data : {email : email
				},
			error : function(xhr, status) {alert('Unknown error ' + status); },
			success : function(data) {
				$("#content1").html(data); 
				$("#tabs li:nth-child(1) a").css("background", "#ddd");
				$("#tabs li:nth-child(1) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(2) a").css("background", "#ddd");
				$("#tabs li:nth-child(2) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(3) a").css("background", "#ddd");
				$("#tabs li:nth-child(3) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(4) a").css("background", "#fff");
				$("#tabs li:nth-child(4) a::after").css("background", "#fff");
				$("#tabs li:nth-child(5) a").css("background", "#ddd");
				$("#tabs li:nth-child(5) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(6) a").css("background", "#ddd");
				$("#tabs li:nth-child(6) a::after").css("background", "#ddd");
				} 
			}); 
	}

 function clearText(thefield){ 
        if (thefield.defaultValue==thefield.value) 
        thefield.value = "" ;
        } 
 
 function closetgil(email){
	 $.ajax({ 
			type : 'post',
			url : 'closetgil.etc',
			async : true,
			data : {
				email: email
			},
			error : function(xhr, status) {alert('Unknown error ' + status); },
			success : function(data) {
				$("#content1").html(data); 
				$("#tabs li:nth-child(1) a").css("background", "#fff");
				$("#tabs li:nth-child(1) a::after").css("background", "#fff");
				$("#tabs li:nth-child(2) a").css("background", "#ddd");
				$("#tabs li:nth-child(2) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(3) a").css("background", "#ddd");
				$("#tabs li:nth-child(3) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(4) a").css("background", "#ddd");
				$("#tabs li:nth-child(4) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(5) a").css("background", "#ddd");
				$("#tabs li:nth-child(5) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(6) a").css("background", "#ddd");
				$("#tabs li:nth-child(6) a::after").css("background", "#ddd");
				} 
			}); 
 }
 
 function myscrab(email){
	 $.ajax({ 
			type : 'post',
			url : '/closet/myscrab.main',
			async : true,
			data : {
				email: email
			},
			error : function(xhr, status) {alert('Unknown error ' + status); },
			success : function(data) {
				$("#content1").html(data); 
				$("#tabs li:nth-child(1) a").css("background", "#ddd");
				$("#tabs li:nth-child(1) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(2) a").css("background", "#fff");
				$("#tabs li:nth-child(2) a::after").css("background", "#fff");
				$("#tabs li:nth-child(3) a").css("background", "#ddd");
				$("#tabs li:nth-child(3) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(4) a").css("background", "#ddd");
				$("#tabs li:nth-child(4) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(5) a").css("background", "#ddd");
				$("#tabs li:nth-child(5) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(6) a").css("background", "#ddd");
				$("#tabs li:nth-child(6) a::after").css("background", "#ddd");
				} 
			}); 
 }
 
 function mylikeArticle(email){
	 $.ajax({ 
			type : 'post',
			url : '/closet/mylikeArticle.main',
			async : true,
			data : {
				email: email
			},
			error : function(xhr, status) {alert('Unknown error ' + status); },
			success : function(data) {
				$("#content1").html(data); 
				$("#tabs li:nth-child(1) a").css("background", "#ddd");
				$("#tabs li:nth-child(1) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(2) a").css("background", "#ddd");
				$("#tabs li:nth-child(2) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(3) a").css("background", "#ddd");
				$("#tabs li:nth-child(3) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(4) a").css("background", "#ddd");
				$("#tabs li:nth-child(4) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(5) a").css("background", "#fff");
				$("#tabs li:nth-child(5) a::after").css("background", "#fff");
				$("#tabs li:nth-child(6) a").css("background", "#ddd");
				$("#tabs li:nth-child(6) a::after").css("background", "#ddd");
				} 
			}); 
 }
 
 function mylikeImage(email){
	 $.ajax({ 
			type : 'post',
			url : '/closet/mylikeImage.main',
			async : true,
			data : {
				email: email
			},
			error : function(xhr, status) {alert('Unknown error ' + status); },
			success : function(data) {
				$("#content1").html(data);
				$("#tabs li:nth-child(1) a").css("background", "#ddd");
				$("#tabs li:nth-child(1) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(2) a").css("background", "#ddd");
				$("#tabs li:nth-child(2) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(3) a").css("background", "#ddd");
				$("#tabs li:nth-child(3) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(4) a").css("background", "#ddd");
				$("#tabs li:nth-child(4) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(5) a").css("background", "#ddd");
				$("#tabs li:nth-child(5) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(6) a").css("background", "#fff");
				$("#tabs li:nth-child(6) a::after").css("background", "#fff");
				} 
			}); 
 }
 function tagReq(email){
	 $.ajax({ 
			type : 'post',
			url : '/closet/tagReq.main',
			async : true,
			data : {
				email: email
			},
			error : function(xhr, status) {alert('Unknown error ' + status); },
			success : function(data) {
				$("#content1").html(data); 
				$("#tabs li:nth-child(1) a").css("background", "#fff");
				$("#tabs li:nth-child(1) a::after").css("background", "#fff");
				$("#tabs li:nth-child(2) a").css("background", "#ddd");
				$("#tabs li:nth-child(2) a::after").css("background", "#ddd");
				} 
			});
 }
 
 function brandReq(email){
	 $.ajax({ 
			type : 'post',
			url : '/closet/brandReq.main',
			async : true,
			data : {
				email: email
			},
			error : function(xhr, status) {alert('Unknown error ' + status); },
			success : function(data) {
				$("#content1").html(data); 
				$("#tabs li:nth-child(1) a").css("background", "#ddd");
				$("#tabs li:nth-child(1) a::after").css("background", "#ddd");
				$("#tabs li:nth-child(2) a").css("background", "#fff");
				$("#tabs li:nth-child(2) a::after").css("background", "#fff");
				} 
			});
 }
 
 
 function updateprofile(){
     $('#popup3').bPopup({
        // loadUrl: "resources/test.html?email=${email}" //Uses jQuery.load()
        		loadUrl: "updateprofileview.etc" //Uses jQuery.load()
     });
    
}
 