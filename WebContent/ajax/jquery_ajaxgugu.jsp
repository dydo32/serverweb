<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#ajaxbtn").on("click", function() {
			var querydata = {
				"num" : $("#num").val()
			}
			$.ajax({
				url:"/serverweb/ajaxgugu",
				type:"get",
				data:querydata,
				dataType:"text",
				success:success_run,
				error:err_run
			}) 
		});
	});
	function success_run(txt){
		$("#result").html("<h2>"+txt+"</h2>");
	}
	function err_run(obj, msg, statusMsg){
		alert("�����߻�=>"+obj+","+msg+","+statusMsg);
	}
</script>
</head>
<body>
	<h1>Ajax�׽�Ʈ(JQuery...)</h1>
	<form name="myform">
		�����Է��ϱ�(2~9)
		<input type="text" name="num" id="num"/>
		<input type="button" id="ajaxbtn" value="���������"/>
	</form>
	<div id="result"></div>
</body>
</html>