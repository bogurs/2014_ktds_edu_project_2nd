function traverseFiles (files) { 
	 alert(files);
	 var fileInfo;
    	$("#file-list").html(""); 
     for (var i=0; i<files.length; i++) {  
   	  var reader = new FileReader();
   	  reader.onload = function(e){
   	  fileInfo = '<img src="'+e.target.result+'">'; 
   	  $("#file-list").append(fileInfo); 
   	  };
   	  reader.readAsDataURL(files[i]);
 		fileInfo = "<il><div><strong>Name:</strong> "
                    + files[i].name + "</div>"; 
       fileInfo += "<div><strong>Size:</strong> "
                     + files[i].size + " bytes</div>"; 
       fileInfo += "<div><strong>Type:</strong> "
                     + files[i].type + "</div></il>"; 
       $("#file-list").append(fileInfo); 
     } 
   }; 

function contentShow(article_num){
	$.ajax({
		type : "POST",
		url:"./contentshow.main",
		async : true,
		dataType : "json",
		data:{
			article_num:article_num
		},
		success : function(data) {
			alert("success");
		},
		error : function(xhr) {
			alert("error html = asdf" + xhr.statusText);
		}			
	});
}

$(document).ready(function() {
	$("#writebtn").click(function() {
		$.ajax({
			type : "POST",
			url : "./contentwrite.main",
			async : true,
			dataType : "json",
			data : {
				content : $('#content1').val(),
			},
			success : function(data) {
				self.close();
			},
			error : function(xhr) {
				alert("error html=" + xhr.statusText);
			}
		});
	});
});