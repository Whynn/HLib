<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Home</title>
</head>
<body>
	<P>The time on the server is ${serverTime}.</P>
	<form>
		<input type="button" value="Return Request" onclick="location.href='./request'"><br />
		<input type="button" value="Select Good User Request" onclick="location.href='./select'"><br />
	</form>
</body>
</html>
