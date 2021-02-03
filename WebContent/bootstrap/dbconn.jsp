<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource
		var = "dataSource"
		url = "jdbc:oracle:thin:@localhost:1521:orcl"
		driver = "oracle.jdbc.OracleDriver"
		user = "fadmin"
		password = "fadmin1234"
	/>
</body>
</html>