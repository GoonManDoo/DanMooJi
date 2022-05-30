<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>회원 목록</h1></div>
	<div>
		<c:forEach items="${students }" var ="student">
			${student.id } : 
			${student.name }
			${student.password } : 
			${student.address } : 
			${student.tel } :
			${student.birthday } : 
			${student.age } : <br> 
		</c:forEach>
	</div>
	<a href="studentJoinForm.do">회원가입</a>
</div>

</body>
</html>