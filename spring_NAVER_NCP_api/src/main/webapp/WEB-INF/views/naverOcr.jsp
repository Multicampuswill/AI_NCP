<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Ocr판독후 보여지는 화면입니다.!!!<br>
<img src="resources/upload/${savedName}" width="350" height="400"><br>
<c:forEach var="x" items="${list}">
- ${x} <br>
</c:forEach>
</body>
</html>