<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="boardparser"></div>
	<div id="cntparser"></div>
	<script type="text/javascript">
		var board = '{"board":'
					+'[{'
					+'"no":"1",'
					+'"title":"json연습",'
					+'"date":"2018/01/01",'
					+'"content":"json어렵다",'
					+'"writer":"kim",'
					+'"category":["it","math"],'
					+'"reply":[{"reno":"1","content":"어렵다ㅠㅠ","date":"2018/05/01","writer":"kim123"},'
					+'{"reno":"2","content":"하다보니 조금","date":"2018/05/10","writer":"kim777"}]'
					+'}]}';
		
		var obj = JSON.parse(board);
		mydata = obj.board[0].no+","+obj.board[0].title
		+","+obj.board[0].date+","+obj.board[0].content
		+","+obj.board[0].writer+","+obj.board[0].category;
		mycnt = obj.board[0].reply[0].reno+","+obj.board[0].reply[0].content
		+","+obj.board[0].reply[0].date+","+obj.board[0].reply[0].writer;
		document.getElementById("boardparser").innerHTML = mydata;
		document.getElementById("cntparser").innerHTML = mycnt;
		
	</script>
</body>
</html>