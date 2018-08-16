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
    <title>合众饰品专卖</title>
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
    <script src="../../js/swiper.min.js"></script>

    <script>

    </script>



    <script>
        $(document).ready(function () {



            var mySwiper = new Swiper('.slide', {
                autoplay: 5000,
                visibilityFullFit: true,
                loop: true,
                pagination: '.pagination'
            });
            //飞入动画，具体根据实际情况调整
            $(".addToCart").click(function () {
                var v = $(this);

                $.post("putcart" +$(this).attr("title") , function () {
                    donghua(v);
                });


            });

        });
        function donghua(obj) {
            $(".hoverCart a").html(parseInt($(".hoverCart a").html()) + 1);
            /*测试+1*/
            var shopOffset = $(".hoverCart").offset();
            var cloneDiv = obj.parent().siblings(".goodsPic").clone();
            var proOffset = obj.parent().siblings(".goodsPic").offset();
            cloneDiv.css({"position": "absolute", "top": proOffset.top, "left": proOffset.left});
            obj.parent().siblings(".goodsPic").parent().append(cloneDiv);
            cloneDiv.animate({
                width: 0,
                height: 0,
                left: shopOffset.left,
                top: shopOffset.top,
                opacity: 1
            }, "slow");
        };

    </script>
</head>
<body>
<!--header-->
<header>
    <a href="location.jsp" class="location">深圳市</a>

    <h1>合众饰品专卖</h1>
    <a href="search" class="rt_searchIcon">&#37;</a>
</header>
<!--slide-->
<div class="slide">
    <div class="swiper-wrapper">
        <%--循环顶部图片--%>
        <c:forEach items="${alist}" var="a">
            <div class="swiper-slide">
                <a href="${a.advLinkUrl}">
                    <img src="${a.advPicUrl}"/>
                </a>
            </div>
        </c:forEach>

    </div>
    <div class="pagination"></div>
</div>
<!--Tab:productList-->
<dl class="tab_proList">
    <dd>
        <ul>
            <c:forEach items="${glist}" var="g">
                <li>
                    <div class="productArea">
                        <a href="product?id=${g.goodsId}" class="goodsPic">
                            <img src="${g.goodsImage}"/>
                        </a>

                        <div class="goodsInfor" >
                            <h2>
                                <a href="product.jsp">${g.goodsName}</a>
                            </h2>

                            <p>
                                <del>${g.goodsOldPrice}</del>
                            </p>
                            <p>
                                <strong class="price">${g.goodsPrice}</strong>
                            </p>
                            <a class="addToCart" title="${g.goodsId}">&#126;</a>
                        </div>
                    </div>
                    <aside>
                        <a class="like_icon" id="${g.goodsId}" title="${g.goodsId}">${g.goodsCollectNum}</a>
                        <a class="comment_icon" id="comment_icon${g.goodsId}" title="${g.goodsId}">${g.commentNum}</a>
                        <a class="deal_icon" id="deal_icon${g.goodsId}" title="${g.goodsId}">${g.thumbsUpNum}</a>
                    </aside>
                </li>
            </c:forEach>

        </ul>
    </dd>
</dl>
<!--floatCart-->
<div class="hoverCart">
    <a href="getcart">0</a>
</div>
<!--fixedNav:footer-->
<div style="height:1.2rem;"></div>
<nav>
    <a href="index" class="homeIcon">首页</a>
    <a href="category" class="categoryIcon">分类</a>
    <a href="getcart" class="cartIcon">购物车</a>
    <a href="user" class="userIcon">我的</a>
</nav>
</body>
</html>
<script>
    $(".like_icon").click(function () {
        goodsId=$(this).attr("title");
        var memberId=${sessionScope.member.memberId}
                $.post("addCollection",{goodsId:goodsId, memberid:memberId}, function (result) {
                    console.log(result);
                    var a= $("#"+goodsId).html();
                    if (result!=0) {
                        a=parseInt(a)+1;
                        $("#"+goodsId).html(a);
                        $.post("addgoods_collect_num",{ goodsid:goodsId}, function (data) {
                            console.log(data);
                            if (data!=0) {
                                alert("收藏次数加一")
                            } else{
                                alert("收藏次数不变")
                            }
                        });
                        alert("收藏成功")
                    } else{
                        a=parseInt(a)-1;
                        $("#"+goodsId).html(a);

                        $.post("cutgoods_collect_num",{goodsid:goodsId}, function (data) {
                            console.log(data);
                            if (data!=0) {

                                alert("收藏次数减一")
                            } else{
                                alert("收藏次数不变")
                            }
                        });
                        alert("取消收藏")
                    }
                });

    });

    $(".comment_icon").click(function () {
        goodsId=$(this).attr("title");
        $.post("comments",{goodsId:goodsId},function (result) {
        if(result==1) {
            location.href = "comment";
        }
    });
    });

    var ifDian=1;
    $(".deal_icon").on("click", function () {

        var goodsId=$(this).attr("title");
        ifDian=parseInt(ifDian)+1;
        if(ifDian%2==0) {
            $.post("addthumbs_up_num", {goodsid: goodsId}, function (result) {
                console.log(result);
                var b = $("#deal_icon" + goodsId).html();
                if (result != 0) {
                    b = parseInt(b) + 1;
                    $("#deal_icon" + goodsId).html(b);
                    alert("点赞成功，点赞次数加一")
                } else {
                    alert("点赞次数不变")
                }
            });
        }
        else{
            $.post("cutthumbs_up_num", {goodsid: goodsId}, function (result) {
                console.log(result);
                var b = $("#deal_icon" + goodsId).html();
                if (result != 0) {
                    b = parseInt(b)-1;
                    $("#deal_icon" + goodsId).html(b);
                    alert("取消点赞成功，点赞次数加一")
                } else {
                    alert("点赞次数不变")
                }
            });
        }
    });

</script>