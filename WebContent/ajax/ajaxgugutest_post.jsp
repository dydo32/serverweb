<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<script type="text/javascript">
	var xhr
	function runAjax() {
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = readyCallback;
		
		//post방식으로 ajax요청하기
		xhr.open("POST","/serverweb/ajaxgugu_post.do",true);
		//post방식인 경우 open메소드에 파라미터를 정의하지 않고 send메소드에 정의해서
		//request body에 파라미터가 저장되어 요청될 수 있도록 처리한다.
		//그런데......
		//request헤더의 속성을 변경
		//key=value로 인코딩을 적용
		//ajax통신할때도 submit버튼을 누를때처럼 파라미터를 name=value로 구분해서
		//map의 형태로 변환할 수 있도록 지정
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("num="+myform.num.value);
	}
	function readyCallback() {
		if(xhr.readyState==4&&xhr.status==200){
			document.getElementById("result").innerHTML = xhr.responseText;
		}
	}
	</script>
</head>
<body>
	<h1>Ajax테스트</h1>
	<form name="myform">
		숫자입력하기(2~9)
		<input type="text" name="num"/>
		<input type="button" onclick="runAjax()" value="구구단출력"/>
	</form>
	<div id="result"></div>
</body>
</html>