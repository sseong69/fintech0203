<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">회원정보</h1>
		
		</div>
	
	</div>
	<div class="container" align="center">
		<%
			String gubun = request.getParameter("gubun");
		
			if(gubun.equals("LoginError")){
				out.println("<h2 class='alert alert-danger'>아이디나 비밀번호를 확인하세요!</h2>");
			} else if(gubun.equals("insert")){
				out.println("<h2 class='alert alert-danger'>회원가입을 축하드립니다!</h2>");
			} else if(gubun.equals("update")){
				out.println("<h2 class='alert alert-danger'>정상적으로 회원정보를 수정하였습니다!</h2>");
			} else if(gubun.equals("delete")){
				out.println("<h2 class='alert alert-danger'>정상적으로 회원정보를 삭제하였습니다!</h2>");
			}
		%>
	</div>
</body>
</html>