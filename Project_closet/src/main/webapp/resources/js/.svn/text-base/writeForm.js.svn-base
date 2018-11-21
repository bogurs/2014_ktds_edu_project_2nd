$(document).ready(function() {
	function traverseFiles(files) {
		var fileInfo;
		$("#file-list").html("");
		for (var i = 0; i < files.length; i++) {
			var reader = new FileReader();
			reader.readAsDataURL(files[i]);
			reader.onload = function(e) {
				fileInfo = "<img src='"+e.target.result+"' width='270px' height='270px'/>";
				$("#file-list").prepend(fileInfo);
			};
			$("#file-list").append(fileInfo);
		}
	}
	$("#files-upload").change(function() {
		traverseFiles(this.files);							
	});		
	
//	$("#tagname").val().change(function() {
//		alert($("#tagname").val());
//	});
//	$("#brandNamediv #jacket").on("click", function() {
//		$("#brandNamediv #jacket")
//	});
});
	
	function codiselect(select) {
		if(select==1) $("#guideforcodiselect").html("일상코디를 자랑해보세요!");
		else $("#guideforcodiselect").html("장소별코디를 제안해보세요!");
	}
	
	function clearText(thefield){ 
        if (thefield.defaultValue==thefield.value) 
        	thefield.value = "";
    }
	
	function helpWrite(){ 
		var html="이것은 작성 가이드 입니다";
		$("#write-inform").append(html);
	}
	
	function addCategory(){
		$('#popup4').bPopup({
	       	loadUrl: "addCategory.main"
	    });
	}
	
	var addcountjacket=1;	var addcounttshirt=1;
	var addcountpants=1;	var addcountsneakers=1;
	var addcountsocks=1;	var addcountgirlshirt=1;
	var addcountgirlpants=1;	var addcountgirldress=1;
	var addcountsuit=1;	var addcountshirt=1;
	var addcountlongshirt=1;	var addcountpolotshirt=1;
	var addcounthoodie=1;	var addcounttanktop=1;
	var addcountgirlshort=1;	var addcountman_shoes=1;
	var addcountgirlheels=1;	var addcountbackpack=1;
	var addcountgirlhandback=1;	var addcountcap=1;
	var addcountflipflops=1;
	function addItem(item){
		if(item=="jacket"){
			addcountjacket++;
			var html = "<img src='resources/img/write_etc_jacket.jpg' width='30' height='20'><input type='text' value='겉옷"+addcountjacket+"' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('jacket')\"><br>";
			$("#jacket").append(html);  
		}else if(item=="tshirt"){
			addcounttshirt++;
			var html = "<img src='resources/img/write_etc_tshirt.jpg' width='30' height='20'><input type='text' value='상의"+addcounttshirt+"' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('tshirt')\"><br>";
			$("#tshirt").append(html);  
		}else if(item=="pants"){
			addcountpants++;
			var html = "<img src='resources/img/write_etc_pants.jpg' width='30' height='20'><input type='text' value='하의"+addcountpants+"' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('pants')\"><br>";
			$("#pants").append(html);  
		}else if(item=="sneakers"){
			addcountsneakers++;
			var html = "<img src='resources/img/write_etc_sneakers.jpg' width='30' height='20'><input type='text' value='신발"+addcountsneakers+"' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('sneakers')\"><br>";
			$("#sneakers").append(html);  
		}else if(item=="girlshirt"){
			addcountgirlshirt++;
			var html = "<img src='resources/img/write_girlshirt.jpg' width='30' height='20'><input type='text' value='상의"+addcountgirlshirt+"' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('girlshirt')\"><br>";
			$("#girlshirt").append(html);  
		}else if(item=="girldress"){
			addcountgirldress++;
			var html = "<img src='resources/img/write_girldress.jpg' width='30' height='20'><input type='text' value='원피스"+addcountgirldress+"' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('girldress')\"><br>";
			$("#girldress").append(html);  
		}else if(item=="girlpants"){
			addcountgirlpants++;
			var html = "<img src='resources/img/write_girlpants.jpg' width='30' height='20'><input type='text' value='하의"+addcountgirlpants+"' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('girlpants')\"><br>";
			$("#girlpants").append(html);  
		}else{
			addcountsocks++;
			var html = "<img src='resources/img/write_etc_socks.jpg' width='30' height='20'><input type='text' value='악세사리"+addcountsocks+"' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('socks')\"><br>";
			$("#socks").append(html);  
		}
	}
	$("#brandNamediv #suit").click(function(){
		var html = "<img src='resources/img/write_etc_suit.jpg' width='30' height='20'><input type='text' value='정장' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('suit')\"><br>";
		$("#addsuit").append(html);		addcountsuit++;	});
	$("#brandNamediv #shirt").click(function(){
		var html = "<img src='resources/img/write_etc_shirt.jpg' width='30' height='20'><input type='text' value='셔츠' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('shirt')\"><br>";
		$("#addshirt").append(html);		addcountshirt++;	});
	$("#brandNamediv #longshirt").click(function(){
		var html = "<img src='resources/img/write_etc_longshirt.jpg' width='30' height='20'><input type='text' value='긴셔츠' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('longshirt')\"><br>";
		$("#addlongshirt").append(html);		addcountlongshirt++;	});
	$("#brandNamediv #polotshirt").click(function(){
		var html = "<img src='resources/img/write_etc_polotshirt.jpg' width='30' height='20'><input type='text' value='폴로티' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('polotshirt')\"><br>";
		$("#addpolotshirt").append(html);		addcountpolotshirt++;	});
	$("#brandNamediv #hoodie").click(function(){
		var html = "<img src='resources/img/write_etc_hoodie.jpg' width='30' height='20'><input type='text' value='후드티' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('hoodie')\"><br>";
		$("#addhoodie").append(html);		addcounthoodie++;	});
	$("#brandNamediv #tanktop").click(function(){
		var html = "<img src='resources/img/write_etc_tanktop.jpg' width='30' height='20'><input type='text' value='탱크톱' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('tanktop')\"><br>";
		$("#addtanktop").append(html);		addcounttanktop++;	});
	$("#brandNamediv #girlshort").click(function(){
		var html = "<img src='resources/img/write_etc_girlshort.jpg' width='30' height='20'><input type='text' value='반바지' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('girlshort')\"><br>";
		$("#addgirlshort").append(html);		addcountgirlshort++;	});
	$("#brandNamediv #man_shoes").click(function(){
		var html = "<img src='resources/img/write_man_shoes.jpg' width='30' height='20'><input type='text' value='남성구두' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('man_shoes')\"><br>";
		$("#addman_shoes").append(html);		addcountman_shoes++;	});
	$("#brandNamediv #girlheels").click(function(){
		var html = "<img src='resources/img/write_girlheels.jpg' width='30' height='20'><input type='text' value='여성구두' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('girlheels')\"><br>";
		$("#addgirlheels").append(html);		addcountgirlheels++;	});
	$("#brandNamediv #backpack").click(function(){
		var html = "<img src='resources/img/write_etc_backpack.jpg' width='30' height='20'><input type='text' value='가방' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('backpack')\"><br>";
		$("#addbackpack").append(html);		addcountbackpack++;	});
	$("#brandNamediv #girlhandback").click(function(){
		var html = "<img src='resources/img/write_girlhandback.jpg' width='30' height='20'><input type='text' value='핸드백' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('girlhandback')\"><br>";
		$("#addgirlhandback").append(html);		addcountgirlhandback++;	});
	$("#brandNamediv #cap").click(function(){
		var html = "<img src='resources/img/write_etc_cap.jpg' width='30' height='20'><input type='text' value='모자' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('cap')\"><br>";
		$("#addcap").append(html);		addcountcap++;	});
	$("#brandNamediv #flipflops").click(function(){
		var html = "<img src='resources/img/write_etc_flipflops.jpg' width='30' height='20'><input type='text' value='슬리퍼' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='-' onclick=\"subItem('flipflops')\"><br>";
		$("#addflipflops").append(html);		addcountflipflops++;	});
	function subItem(item){
		if(item=="jacket"){
			$('#jacket img').filter(":last").remove();
			$('#jacket input:text').filter(":last").remove();
			$('#jacket input:button').filter(":last").remove();
			$('#jacket br').filter(":last").remove();
			addcountjacket--;
		}else if(item=="tshirt"){
			$('#tshirt img').filter(":last").remove();
			$('#tshirt input:text').filter(":last").remove();
			$('#tshirt input:button').filter(":last").remove();
			$('#tshirt br').filter(":last").remove();
			addcounttshirt--;
		}else if(item=="pants"){
			$('#pants img').filter(":last").remove();
			$('#pants input:text').filter(":last").remove();
			$('#pants input:button').filter(":last").remove();
			$('#pants br').filter(":last").remove();
			addcountpants--;
		}else if(item=="sneakers"){
			$('#sneakers img').filter(":last").remove();
			$('#sneakers input:text').filter(":last").remove();
			$('#sneakers input:button').filter(":last").remove();
			$('#sneakers br').filter(":last").remove();
			addcountsneakers--;
		}else if(item=="socks"){
			$('#socks img').filter(":last").remove();
			$('#socks input:text').filter(":last").remove();
			$('#socks input:button').filter(":last").remove();
			$('#socks br').filter(":last").remove();
			addcountsocks--;
		}else if(item=="girlshirt"){
			$('#girlshirt img').filter(":last").remove();
			$('#girlshirt input:text').filter(":last").remove();
			$('#girlshirt input:button').filter(":last").remove();
			$('#girlshirt br').filter(":last").remove();
			addcountgirlshirt--;
		}else if(item=="girldress"){
			$('#girldress img').filter(":last").remove();
			$('#girldress input:text').filter(":last").remove();
			$('#girldress input:button').filter(":last").remove();
			$('#girldress br').filter(":last").remove();
			addcountgirldress--;
		}else if(item=="girlpants"){
			$('#girlpants img').filter(":last").remove();
			$('#girlpants input:text').filter(":last").remove();
			$('#girlpants input:button').filter(":last").remove();
			$('#girlpants br').filter(":last").remove();
			addcountgirlpants--;
		}else if(item=="suit"){
			$('#addsuit img').filter(":last").remove();
			$('#addsuit input:text').filter(":last").remove();
			$('#addsuit input:button').filter(":last").remove();
			$('#addsuit br').filter(":last").remove();
			addcountsuit--;
		}else if(item=="shirt"){
			$('#addshirt img').filter(":last").remove();
			$('#addshirt input:text').filter(":last").remove();
			$('#addshirt input:button').filter(":last").remove();
			$('#addshirt br').filter(":last").remove();
			addcountshirt--;
		}else if(item=="longshirt"){
			$('#addlongshirt img').filter(":last").remove();
			$('#addlongshirt input:text').filter(":last").remove();
			$('#addlongshirt input:button').filter(":last").remove();
			$('#addlongshirt br').filter(":last").remove();
			addcountlongshirt--;
		}else if(item=="polotshirt"){
			$('#addpolotshirt img').filter(":last").remove();
			$('#addpolotshirt input:text').filter(":last").remove();
			$('#addpolotshirt input:button').filter(":last").remove();
			$('#addpolotshirt br').filter(":last").remove();
			addcountpolotshirt--;
		}else if(item=="hoodie"){
			$('#addhoodie img').filter(":last").remove();
			$('#addhoodie input:text').filter(":last").remove();
			$('#addhoodie input:button').filter(":last").remove();
			$('#addhoodie br').filter(":last").remove();
			addcounthoodie--;
		}else if(item=="tanktop"){
			$('#addtanktop img').filter(":last").remove();
			$('#addtanktop input:text').filter(":last").remove();
			$('#addtanktop input:button').filter(":last").remove();
			$('#addtanktop br').filter(":last").remove();
			addcounttanktop--;
		}else if(item=="girlshort"){
			$('#addgirlshort img').filter(":last").remove();
			$('#addgirlshort input:text').filter(":last").remove();
			$('#addgirlshort input:button').filter(":last").remove();
			$('#addgirlshort br').filter(":last").remove();
			addcountgirlshort--;
		}else if(item=="man_shoes"){
			$('#addman_shoes img').filter(":last").remove();
			$('#addman_shoes input:text').filter(":last").remove();
			$('#addman_shoes input:button').filter(":last").remove();
			$('#addman_shoes br').filter(":last").remove();
			addcountman_shoes--;
		}else if(item=="girlheels"){
			$('#addgirlheels img').filter(":last").remove();
			$('#addgirlheels input:text').filter(":last").remove();
			$('#addgirlheels input:button').filter(":last").remove();
			$('#addgirlheels br').filter(":last").remove();
			addcountgirlheels--;
		}else if(item=="backpack"){
			$('#addbackpack img').filter(":last").remove();
			$('#addbackpack input:text').filter(":last").remove();
			$('#addbackpack input:button').filter(":last").remove();
			$('#addbackpack br').filter(":last").remove();
			addcountbackpack--;
		}else if(item=="girlhandback"){
			$('#addgirlhandback img').filter(":last").remove();
			$('#addgirlhandback input:text').filter(":last").remove();
			$('#addgirlhandback input:button').filter(":last").remove();
			$('#addgirlhandback br').filter(":last").remove();
			addcountgirlhandback--;
		}else if(item=="cap"){
			$('#addcap img').filter(":last").remove();
			$('#addcap input:text').filter(":last").remove();
			$('#addcap input:button').filter(":last").remove();
			$('#addcap br').filter(":last").remove();
			addcountcap--;
		}else if(item=="flipflops"){
			$('#addflipflops img').filter(":last").remove();
			$('#addflipflops input:text').filter(":last").remove();
			$('#addflipflops input:button').filter(":last").remove();
			$('#addflipflops br').filter(":last").remove();
			addcountflipflops--;
		}
	}
	
	$("#gender").change(function() {
		addcountjacket=1;		addcounttshirt=1;
		addcountpants=1;		addcountsneakers=1;
		addcountsocks=1;		addcountgirlshirt=1;
		addcounttgirldress=1;		addcountgirlpants=1;
		addcountgirlheels=1;		addcountgirlhandback=1;		
		addcountsuit=1; addcountshirt=1;
		addcountlongshirt=1; addcountpolotshirt=1;
		addcounthoodie=1; addcounttanktop=1;
		addcountgirlshort=1; addcountman_shoes=1;
		addcountbackpack=1; addcountcap=1;
		addcountflipflops=1;
		if($("#gender").val()==2 || $("#gender").val()==1){
			var html = "<img src='resources/img/write_etc_jacket.jpg' width='30' height='20'><input type='text' value='겉옷' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('jacket')\"><div id='jacket'></div>";
			html += "<img src='resources/img/write_etc_tshirt.jpg' width='30' height='20'><input type='text' value='상의' name='tshirt' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('tshirt')\"><div id='tshirt'></div>";
			html += "<img src='resources/img/write_etc_pants.jpg' width='30' height='20'><input type='text' value='하의' name='pants' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('pants')\"><div id='pants'></div>";
			html += "<img src='resources/img/write_etc_sneakers.jpg' width='30' height='20'><input type='text' value='신발' name='sneakers' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('sneakers')\"><div id='sneakers'></div>";
			html += "<img src='resources/img/write_etc_socks.jpg' width='30' height='20'><input type='text' value='악세사리' name='socks' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('socks')\"><div id='socks'></div>";
			html += '<div id="addsuit"></div><div id="addshirt"></div><div id="addlongshirt"></div>'+
				'<div id="addpolotshirt"></div><div id="addhoodie"></div><div id="addtanktop"></div>'+
				'<div id="addgirlshort"></div><div id="addman_shoes"></div><div id="addgirlheels"></div>'+
				'<div id="addbackpack"></div><div id="addgirlhandback"></div><div id="addcap"></div>'+
				'<div id="addflipflops"></div>';
			$("#brandNamediv").html(html);
		}
		else{
			var html = "<img src='resources/img/write_etc_jacket.jpg' width='30' height='20'><input type='text' value='겉옷' name='jacket' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('jacket')\"><div id='jacket'></div>";
			html += "<img src='resources/img/write_girlshirt.jpg' width='30' height='20'><input type='text' value='상의' name='tshirt' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('girlshirt')\"><div id='girlshirt'></div>";
			html += "<img src='resources/img/write_girldress.jpg' width='30' height='20'><input type='text' value='원피스' name='dress' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('girldress')\"><div id='girldress'></div>";
			html += "<img src='resources/img/write_girlpants.jpg' width='30' height='20'><input type='text' value='하의' name='pants' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('girlpants')\"><div id='girlpants'></div>";
			html += "<img src='resources/img/write_etc_sneakers.jpg' width='30' height='20'><input type='text' value='신발' name='sneakers' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('sneakers')\"><div id='sneakers'></div>";
			html += "<img src='resources/img/write_etc_socks.jpg' width='30' height='20'><input type='text' value='악세사리' name='socks' onFocus='clearText(this)' style='font-size:12pt;''><input type='button' value='+' onclick=\"addItem('socks')\"><div id='socks'></div>";
			html += '<div id="addsuit"></div><div id="addshirt"></div><div id="addlongshirt"></div>'+
				'<div id="addpolotshirt"></div><div id="addhoodie"></div><div id="addtanktop"></div>'+
				'<div id="addgirlshort"></div><div id="addman_shoes"></div><div id="addgirlheels"></div>'+
				'<div id="addbackpack"></div><div id="addgirlhandback"></div><div id="addcap"></div>'+
				'<div id="addflipflops"></div>';
			$("#brandNamediv").html(html);
		}
	});
	