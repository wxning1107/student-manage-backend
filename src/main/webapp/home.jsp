<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="register/html; charset=gb2312">
    <title>注册</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        html {
            height: 100%;
            width: 100%;
            overflow: hidden;
            margin: 0;
            padding: 0;
            background: url(image/bg2.png) no-repeat 0px 0px;
            background-repeat: no-repeat;
            background-size: 100% 100%;
            -moz-background-size: 100% 100%;
        }
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100%;
        }
        #loginDiv {
            width: 37%;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 450px;
            background-color: rgba(75, 81, 95, 0.3);
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.5);
            border-radius: 5px;
        }
        p,
        .sexDiv {
            margin-top: 10px;
            margin-left: 20px;
            color: azure;
        }
        .sexDiv>input{
            width: 30px;
            height: 17px;
        }
        input {
            margin-left: 15px;
            border-radius: 5px;
            border-style: hidden;
            height: 30px;
            width: 140px;
            background-color: rgba(216, 191, 216, 0.5);
            outline: none;
            color: #f0edf3;
            padding-left: 10px;
        }
        .button {
            border-color: cornsilk;
            background-color: rgba(100, 149, 237, .7);
            color: aliceblue;
            border-style: hidden;
            border-radius: 5px;
            width: 100px;
            height: 31px;
            font-size: 16px;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            margin-top: 20px;
            color: #f0edf3;
        }
    </style>
</head>

<body>
<div id="loginDiv">
    <form action="/register" method="get">
        <h1>学生和老师查询</h1>
        <div>${error}</div>
        <p>用户账号:<input name="userCode" id="userCode" type="text" autofocus required></p>
        <div class="sexDiv">
            用户性别:
            <input class="userSex" name="gender" value="男" type="radio">男
            <input class="userSex" name="gender" value="女" type="radio">女
            <label id="sex_trip"></label>
        </div>
        <p>收货地址:<input name="birthday" id="birthday" type="text" autofocus required></p>
        <p> 电话号码:<input name="phone" cols="30" id="phone" required rows="10" type="text"></p>

        <p style="text-align: center;">
            <input type="submit" class="button" value="提交">
            <input type="reset" class="button" value="重置">
        </p>
    </form>
</div>

</body>
