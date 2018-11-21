$(document).ready(function() {
	$("#openWriteForm").click(function() {
		$.ajax({
			type : "POST",
			url : "./contentwrite.etc",
			async : true,
			dataType : "json",
			data : {
				content : $('#content1').val()
			},
			success : function(data) {
				var html = "<table border='1'>";
				$.each(data.contentList2, function(entryIndex, entry) {
					var formatted_date = new Date(entry.article_date);
					
					html += '<tr><td>' + entry.name + '</td>';
					html += '<td>' + entry.content + '</td>';
					html += '<td>' + formatted_date.toLocaleDateString() + '</td></tr>';
				});

				html += '</table>';

				$("#content1_show").html(html);
			},
			error : function(xhr) {
				alert("error html=" + xhr.statusText);
			}
		});
	});
});