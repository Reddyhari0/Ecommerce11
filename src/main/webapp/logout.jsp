<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		session.invalidate();
		response.sendRedirect("index.jsp?msg=You Have Been Logged Out Successfully");
%>
</body>
</html>