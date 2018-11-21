	function commentbutton(article_num){
		$.ajax({
			type : "POST",
			url : "./commentRead.main",
			async : true,
			dataType : "json",
			data : {
				article_num : article_num
			},
			success : function(data) {
				
				var html = "<div style='width:550px; height:230px; overflow:auto; overflow-x:hidden; BORDER-COLLAPSE:collapse;'><table border=0 width=530px >"
//		        html += '<tr><td width=20>작성자</td><td>내용</td><td>날짜</td><td width=5>삭제</td>';
		            
				$.each(data.commentList, function(entryIndex, entry) {
					var formatted_date = new Date(entry.comment_date);
					
					html += '<tr><td width=40>' + entry.email + '</td>';
					html += '<td width=240>' + entry.comment_content + '<br><font size="2pt">' + formatted_date.toLocaleDateString() + '</font></td>';
//					html += '<td width=200>' + formatted_date.toLocaleDateString() + '</td>';
					if(data.sessionemail == entry.email)
						html += '<td width=1>' + '<input type="button" value="X" onclick="commentDelete(' + entry.comment_num+ ',' + entry.article_num + ')">' + '</td></tr>';
					else
						html += '<td></td></tr>';
					html +='<tr><td colspan=3><hr></td></tr>'
				});
				html += '</table></div>';

				$("#comment_show").html(html);
			},
			error : function(xhr) {
				alert("error html=" + xhr.statusText);
			}
		});
}

	function writebtn(article_num,name,email){
			$.ajax({
			type : "POST",
			url : "./commentWrite.main",
			async : true,
			dataType : "json",
			data : {
				article_num : article_num,
				name : name,
				email : email,
				comment_content : $('#comment_content').val()			
			},
			success : function(data) {
				commentbutton(article_num);
				$("#comment_content").val("");
			},
			error : function(xhr) {
				alert("error html=" + xhr.statusText);
			}
		});
	}

function commentDelete(comment_num,article_num){
	$.ajax({
		type : "POST",
		url:"./commentDelete.main",
		async : true,
		dataType : "json",
		data:{
			comment_num:comment_num,
			article_num:article_num
		},
		success : function(data) {
			commentbutton(article_num);
		},
		error : function(xhr) {
			alert("error html=" + xhr.statusText);
		}
	});
}