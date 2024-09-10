<%--
  Created by IntelliJ IDEA.
  User: yejinkim
  Date: 2024/09/05
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TodoList</title>
</head>
<body>
    <h1> Todo List page </h1>
<%--    ${dtolist}--%>
<%--    ${dtolist[0].tno} --- ${dtolist[0].title} --- ${dtolist[0].dueDate}--%>
<%--    <h3>${1+2+3}</h3>--%>
<%--    <h3>${"AAA" += "BBB"}</h3>--%>
<%--    <h3>${"AAA".equals("aaa")}</h3>--%>
<ul>
    <c:forEach items="${dtolist}" var="dto">
        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE": "NOT YET"}</span>
        </li>

    </c:forEach>

</ul>
<form action="/logout" method="post">
    <button>LOGOUT</button>
</form>
</body>
</html>
