<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원데이터</title>
</head>
<body>

<h2>작성한 내용</h2>
<hr>

	<table border="1">
		<tr>
			<td bgcolor="lightblue">이름</td>
			<td>${v.name}</td>
		</tr>
		<tr>
			<td bgcolor="lightblue">아이디</td>
			<td>${v.id}</td>
		</tr>
		<tr>
			<td bgcolor="lightblue">비밀번호</td>
			<td><input type="password" value="${v.password}" disabled></td>
		</tr>
		<tr>
			<td bgcolor="lightblue">권한</td>
			<td>${v.role}</td>
		</tr>
	</table>

<br>
<a href="login.jsp">로그인하러가기</a>

</body>
</html>