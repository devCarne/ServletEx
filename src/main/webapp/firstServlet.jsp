<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String) request.getAttribute("name");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ListControllerPage</h1>
<hr>
hello~ <%=name%><br>
hello~ ${name}
</body>
</html>
