<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Return Check</title>
</head>
<body>

	"${memberID}"님께서 반납하신 책 "${bookName}"이 성공적으로 반납되었습니다.
	<br />
	<br /> Please click button to go return request page.
	<br />
	<input type="button" value="go back"
		onclick="location.href='./request'">
	<br />


</body>
</html>