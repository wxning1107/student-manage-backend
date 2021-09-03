<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/favicon.ico">
        <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/offcanvas/">

        <title>Off Canvas Template for Bootstrap</title>

        <!-- Bootstrap core CSS -->
        <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/examples/offcanvas/offcanvas.css" rel="stylesheet">

        <style>
            .container{
                width: 1000px;
                padding: 0px 15px;
                margin: 0 auto;
            }
            .window{
                height: 200px;
                overflow: hidden;
                /*position: relative;*/
            }
            .window img{
                width: 600px;
                height: 200px;
                top: 0px;
                left: 0px;
            }
            #pagination{
                position:absolute;left:40%;
            }
        </style>
        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" href="css/cart.css">
    <script src="javascript/cart.js"></script>
</head>
<body>

<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">假宝</a>
        </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="home.jsp">购物首页</a></li>
                    <li><a class="active" href="/page?pageNum=1">购物车</a></li>
                    <li><a href="#">我的订单</a></li>
                </ul>
            </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->



    <div class="container">
        <form action="" method="get">
           <c:forEach items="${billList}" var="bill" varStatus="g">
        <div class="shop" id="idData">
            <div class="header">
                <input type="checkbox" class="shop_checkbox">
                <span class="shop_icon"></span>
                <span class="shop_name">店铺</span>
                <span class="wangwang_icon"></span>
            </div>
        <div class="items">
            <div class="item">
                <div><input class="item_checkbox" type="checkbox" name="" id=""></div>
                <script>
                    <%
                    ArrayList<Bill> bills=null;
                    request.setAttribute("bills",bills);
                    %>
                </script>
                <div>
                    <img class="item_img" src="${bill.goodspicture}">
                </div>
                <div class="item_name"><!--item_name是底部促销图标-->
                    <div>${bill.goodsname}</div>
                    <div class="promotion_icons"><span><img src="image/a.png"></span>
                        <span><img src="image/b.png"></span>
                        <span><img src="image/c.png"></span></div>
                </div>
                <div class="sku"></div>
                <div class="price">
                    <div class="price_1">￥299.0</div>
                    <div class="price_2" data-price="${bill.goodsprice}">${bill.goodsprice}</div>
                </div>
                <div class="num_control">
                    <span class="num_minus">-</span><input class="num" type="text" value="${bill.count}"><span class="num_plus">+</span>
                </div>
                <div class="item_price_total">
                    <span>${bill.goodsprice}</span>
                </div>
                <div class="operation">
                    <div><a href="/pay?jump=0&goodsprice=${bill.goodsprice}&count=${bill.count}">添加结算列表</a></div>
                    <div><a href="/delete?goodsname=${bill.goodsname}">删除</a></div>
                </div>
            </div>
        </div>
        </div>
            </c:forEach>
        </form>


        <div class="checkout">
            <div><input type="checkbox"><span>全选</span></div>
            <div>已选商品<span class="checked_num" ></span>件</div>
            <div>合计（不含运费）<span class="total_price">0.00</span> </div>
            <div class="checkout_button"><a href="/pay?jump=1">结算</a></div>
        </div>
    </div>
    <%--<button onclick="changePage(-1);">上一页</button>--%>
    <%--<button onclick="changePage(1);">下一页</button>--%>
    <%--当前第  页 ， 共  页 ， 共  条记录--%>
<div id="pagination">
    <nav class="pagePosition">
        <form action="/page" method="get" id="jump"></form>
        <ul class="pagination pagination-sm">
            <li><span  class="preBtn">上一页</span> </li>
            <li><a href="/page?pageNum=1">1</a></li>
            <li><a href="/page?pageNum=2">2</a> </li>
            <li><a href="/page?pageNum=3">3</a> </li>
            <li><a href="/page?pageNum=4">4</a> </li>
            <li><a href="/page?pageNum=5">5</a> </li>
            <li><a href="/page?pageNum=6">6</a> </li>
            <li><span class="nextBtn">下一页</span> </li>
            <li><input type="text" class="pageNum" id="pageNum" name="pageNum" value="1"></li>
        </ul>
    </nav>
</div>
</body>
</html>























