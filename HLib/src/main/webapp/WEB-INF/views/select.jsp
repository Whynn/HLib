<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- print List of Good Users -->
	<table>
		<c:forEach items="${members}" var="result" varStatus="status">
			<tr>
				<td><c:out value="${status.count}"></c:out></td>
				<td><c:out value="${members.memberID}"></c:out></td>
				<td><c:out value="${members.AllPoint}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>