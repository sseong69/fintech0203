<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="dbconn.jsp" %>
	<%
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
	%>
	
	<sql:query var="resultSet" dataSource="${dataSource}">
		select * from member where id = ? and password = ?
		
		<sql:param value="<%=id %>"/>
		<sql:param value="<%=passwd %>"/>
	</sql:query>
	<%-- select문 수행후 리턴되는 행의 수 --%>
	<c:if test="${resultSet.rowCount > 0}">
		<%
			//정상 로그인인 경우 입력받은 아이디를 세션속성 아이디로 지정
			session.setAttribute("sessionId",id);
		%>
		<%-- 강제로 메뉴로 이동시킨다 --%>
		<c:redirect url="menu.jsp"/>
	</c:if>
	<c:if test="${resultSet.rowCount == 0}">
		<%-- 회원테이블에 없는 사용자면 오류메시지를 보여준다. --%>
		<c:redirect url="resultMember.jsp?gubun=LoginError"/>
	</c:if>
	
</body>
</html>