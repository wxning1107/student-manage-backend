
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewpoort" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" href="css/login">
    <title>系统登录—购物车系统</title>
    <script type="text/javascript"></script>
</head>
<body class="login_bg" >

<%--<%--%>
    <%--request.getSession().setAttribute("sum",0);--%>
<%--%>--%>
<form action="/login.do" method="get" class="login">
    <p>你的假宝</p>
    <div>${error}</div>
        <input type="text" name="userCode" placeholder="用户名"/><br>
        <input type="password" name="userPassword" placeholder="密码"/><br>
         <input type="hidden" name="kind" value="0">
        <input type="submit" class="btn" value="登 录" />
        <a href="home.jsp">注册</a>
</form>
</body>
</html>
