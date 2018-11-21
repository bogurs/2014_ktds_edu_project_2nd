<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/writeForm.css" rel="stylesheet" type="text/css" />
<script src="./resources/js/writeForm.js" type="text/javascript"></script>
<script src="./resources/js/gil.js" type="text/javascript"></script>
<link href="resources/css/bpopup.css" rel="stylesheet" type="text/css" />
<link href="resources/css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div style="width: 1200px; height: 600px; overflow: hidden;">
<ul id="helpWrite"><li><a style="cursor: pointer;" onclick="helpWrite()">작성도우미</a></li></ul>
<span class="b-close"><span>X</span></span>
		<table border="0" align="left" width="570px" height="500px" style="border-right: 3px solid #06f;">
			<tr align="left" valign="top" height="40px">
				
					
				
			</tr>				
			<tr>				
				<td>
				<div id="file-list" align="center" style="width:565px; height: 464px; overflow: scroll;">
					<div id="write-inform" style="width:565px; height: 200px;"></div>
					사진을 등록하세요.
				</div>
				</td>
			</tr>
			<tr>
				<td align="center" height="40px">					
					<input id="files-upload" name="file" type="file" multiple accept="image/*">		
					<br>뽐내고 싶은 사진을 추가하세요! <font size="2"> *다수의 사진도 올릴 수 있습니다!</font>			
				</td>
			</tr>
		</table>		
		<table border="0" align="right" width="580px" height="500px">
			<tr>
				<td width="100" height="60" rowspan="2" align="right"><img src='/closet/profileImageDown.etc?email=${email }'width='60' height='60'></td>
				<td height="30" colspan="3">${name }&nbsp;&nbsp;<font color="#06f"><b>|</b></font>&nbsp; 
					
					<font size="2"> 어떤 성별에 어울리는 코디인가요?</font>
					<select name="gender" id="gender" style="font-size:12pt;">
						<option value="0">성별무관</option>
						<option value="1">남성의류</option>
						<option value="2">여성의류</option>
					</select>
				</td>
			</tr>
			<tr>
				<td height="30" colspan="3"><input id="keyword" type="text" value="내 코디를 여러 사람에게 자랑하세요!" onFocus="clearText(this)" style="width: 420px; font-size:12pt;"></td>
			</tr>
			<tr>
				<td colspan="4"><hr color="#06f"></td>
			</tr>
			<tr>
				<th style="font-size:11pt;">
					<b>글 입력</b>
				</th>
				<td colspan="2">
					<textarea rows="7" cols="25" name="content" id="content"></textarea>
				</td>
				<td align="center" style="border-left: 3px solid #06f;" rowspan="4" valign="top">
				<div style="overflow: scroll; width: 270px; height: 370px;">
					<b>브랜드명을 알려주세요.</b><br>
					<div id="brandNamediv">
					<img src="resources/img/write_etc_jacket.jpg" width="30" height="20"><input type="text" value="겉옷" onFocus="clearText(this)" style="font-size:12pt;"><input type="button" value="+" onclick="addItem('jacket')"><div id="jacket"></div>
					<img src="resources/img/write_etc_tshirt.jpg" width="30" height="20"><input type="text" value="상의" onFocus="clearText(this)" style="font-size:12pt;"><input type="button" value="+" onclick="addItem('tshirt')"><div id="tshirt"></div>
					<img src="resources/img/write_etc_pants.jpg" width="30" height="20"><input type="text" value="하의" onFocus="clearText(this)" style="font-size:12pt;"><input type="button" value="+" onclick="addItem('pants')"><div id="pants"></div>
					<img src="resources/img/write_etc_sneakers.jpg" width="30" height="20"><input type="text" value="신발" onFocus="clearText(this)" style="font-size:12pt;"><input type="button" value="+" onclick="addItem('sneakers')"><div id="sneakers"></div>
					<img src="resources/img/write_etc_socks.jpg" width="30" height="20"><input type="text" value="악세사리" onFocus="clearText(this)" style="font-size:12pt;"><input type="button" value="+" onclick="addItem('socks')"><div id="socks"></div>
					<div id="addCategoryInput"></div>
					</div>
					<div align="right"><input type="button" value="추가" onclick="javascript:addCategory()"></div>	
				</div>				
				</td>
			</tr>
			<tr>
				<td colspan="3"><hr color="#06f"></td>
			</tr>
			<tr>
				<th rowspan="2" style="font-size:11pt;"><b>설정</b></th>
				<td width="80px" align="right" style="font-size:12pt;">
				카테고리  
				</td>
				<td>
				<select name="category" style="font-size:11pt;">
						<option value="0">COORDI</option>
						<option value="1">OUTWEAR</option>
						<option value="2">TOP</option>
						<option value="3">BOTTOM</option>
						<option value="4">SHOES</option>
						<option value="5">ACCESSORY</option>
				</select>
				</td>				
			</tr>		
			<tr>
				<td align="right" style="font-size:12pt;">
					공개설정  
				</td>
				<td>
					<select name="scrabPrivate" style="font-size:11pt;">
						<option value="0" selected="1">공개하기</option>
						<option value="1">팔로워에만 공개</option>
						<option value="2">내 옷장에 올리기</option>
					</select>
				</td>				
			</tr>			
			<tr>
				<td colspan="4"><hr color="#06f"></td>
			</tr>
			<tr>
				<td align="right" style="font-size:11pt;">
					태그입력 
				</td>
				<td colspan="3">
					<input type="text" id="tag" name="tag" style="font-size:11pt; width: 500px;" onFocus="clearText(this)" value="브랜드 명/ 코디 명/ 옷 종류 등을 적어주세요!(예: 스파브랜드, 캐쥬얼)">
				</td>
			</tr>			
			<tr>
				<td align="right" colspan="4">
					<input type="submit" value="확인" class="button blue one-corner">
				</td>
			</tr>			
		</table>	
	</form>	
</div>
</body>

</html>