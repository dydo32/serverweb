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
		
		//post������� ajax��û�ϱ�
		xhr.open("POST","/serverweb/ajaxgugu_post.do",true);
		//post����� ��� open�޼ҵ忡 �Ķ���͸� �������� �ʰ� send�޼ҵ忡 �����ؼ�
		//request body�� �Ķ���Ͱ� ����Ǿ� ��û�� �� �ֵ��� ó���Ѵ�.
		//�׷���......
		//request����� �Ӽ��� ����
		//key=value�� ���ڵ��� ����
		//ajax����Ҷ��� submit��ư�� ������ó�� �Ķ���͸� name=value�� �����ؼ�
		//map�� ���·� ��ȯ�� �� �ֵ��� ����
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
	<h1>Ajax�׽�Ʈ</h1>
	<form name="myform">
		�����Է��ϱ�(2~9)
		<input type="text" name="num"/>
		<input type="button" onclick="runAjax()" value="���������"/>
	</form>
	<div id="result"></div>
</body>
</html>