<%--
  Created by IntelliJ IDEA.
  User: linhtran
  Date: 20/04/2017
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Succsess</title>
    <link href="<%=request.getContextPath()%>/public/css/mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
    <p>Hello : <%=request.getAttribute("user_name")%></p>
    <a href="xuly?action=logout"><button>Logout</button></a>
</body>
</html>
