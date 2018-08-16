<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <base href="<%=basePath %>"/>
    <title>购物车-合众饰品专卖</title>
    <meta name="keywords" content="KEYWORDS..."/>
    <meta name="description" content="DESCRIPTION..."/>
    <meta name="author" content="HZIT"/>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name='apple-touch-fullscreen' content='yes'>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="address=no">
    <link rel="icon" href="../../images/icon/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon-precomposed" sizes="57x57"
          href="../../images/icon/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="120x120"
          href="../../images/icon/apple-touch-icon-120x120-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="196x196"
          href="../../images/icon/apple-touch-icon-196x196-precomposed.png">
    <meta name="viewport" content="initial-scale=1, width=device-width, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="../../css/style.css"/>
    <script src="../../js/jquery.js"></script>




    <script>
        $(document).ready(function(){
            var totlemoney=0 ;
            var arrays =[];
            var size =new Array();
            $(".priceArea strong").each(function(i,o){

                arrays.push($(o).text());

            }) ;

            $(".goodsInfor span").each(function(i,o){

                size.push($(o).text());

            }) ;

            var tem;
            var num=0
            for(var i =0;i<arrays.length;i++){
                tem=arrays[i]*size[i];
                var number = parseFloat(tem);
                totlemoney=totlemoney+number;
                num=num+parseInt(size[i]);
            }
            $(".btmNav li a em").html(num);
            $(".btmNav li a:eq(1)").html("合计 ￥："+totlemoney);
        });
    </script>

    <script>
        //商品的增加与减少

    </script>

    <script>




        $(document).ready(function () {

            //show or hide:delBtn
            $(".edit").toggle(function () {
                $(this).parent().siblings("dd").find(".delBtn").fadeIn();
                $(this).html("完成");
                $(".numberWidget").show();
                $(".priceArea").hide();
            }, function () {
                $(this).parent().siblings("dd").find(".delBtn").fadeOut();
                $(this).html("编辑");
                $(".numberWidget").hide();
                $(".priceArea").show();
            });
            //minus
            $(".minus").click(function () {
                console.log("sdas");
                $.post("changecart"+$(this).attr("title"),{count:-1},function(data){

                    $(".btmNav li a em").html(data.num);
                    $(".btmNav li a:eq(1)").html("合计 ￥："+data.totalmoney);

                })
                var currNum = $(this).siblings(".number");
                if (currNum.val() <= 1) {
                    $(this).parents("dd").remove();
                    nullTips();
                } else {
                    currNum.val(parseInt(currNum.val()) - 1);
                }
            });
            //plus
            $(".plus").click(function () {
                $.post("changecart"+$(this).attr("title"),{count:1},function(data){
                    $(".btmNav li a em").html(data.num);
                    $(".btmNav li a:eq(1)").html("合计 ￥："+data.totalmoney);
                })
                var currNum = $(this).siblings(".number");
                currNum.val(parseInt(currNum.val()) + 1);
            });
            //delBtn
            $(".delBtn").click(function () {
                $(this).parent().remove();
                nullTips();
                $.post("deletecart"+$(this).attr("title"),function(data){
                    $(".btmNav li a em").html(data.num);
                    $(".btmNav li a:eq(1)").html("合计 ￥："+data.totalmoney);

                })
            });
            //isNull->tips
            function nullTips() {
                if ($(".cart dd").length == 0) {
                    var tipsCont = "<mark style='display:block;background:none;text-align:center;color:grey;'>购物车为空！</mark>"
                    $(".cart").remove();
                    $("body").append(tipsCont);
                }
            }
        });
    </script>
</head>
<body>
<!--header-->
<header>
    <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>

    <h1>购物车</h1>
</header>
<dl class="cart">
    <dt>
        <label><input type="checkbox"/>全选</label>
        <a class="edit">编辑</a>
    </dt>

    <c:forEach items="${cart}" var="c">
        <dd>
            <input type="checkbox" />
            <a href="product.jsp" class="goodsPic"><img src="${c.value.goodsinfo.goodsImage}"/></a>

            <div class="goodsInfor">
                <h2>
                    <a href="product.jsp">${c.value.goodsinfo.goodsSubtitle}</a>
                    <span>${c.value.size}</span>
                </h2>

                <div class="priceArea">
                    <strong>${c.value.goodsinfo.goodsPrice}</strong>
                    <del>${c.value.goodsinfo.goodsOldPrice}</del>
                </div>

                <div class="numberWidget">
                    <input type="button" value="-" class="minus" title="${c.value.goodsinfo.goodsId}"/>
                    <input type="text" value="${c.value.size}" disabled class="number"/>
                    <input type="button" value="+" class="plus" title="${c.value.goodsinfo.goodsId}"/>
                </div>
            </div>
            <a class="delBtn" title="${c.value.goodsinfo.goodsId}">删除</a>
        </dd>

    </c:forEach>




</dl>
<!--bottom nav-->
<div style="height:1rem;"></div>
<aside class="btmNav">
    <ul>
        <li><a class="cart_icon"><em>0</em></a></li>
        <li><a>合计 ￥：0</a></li>
        <li><a href="confirm_order">立即下单</a></li>
    </ul>
</aside>
</body>
</html>
