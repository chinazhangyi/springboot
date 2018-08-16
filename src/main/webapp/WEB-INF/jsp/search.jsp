<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <base href="<%=basePath %>"/>
    <title>搜索-合众饰品专卖</title>
    <meta name="keywords"  content="KEYWORDS..." />
    <meta name="description" content="DESCRIPTION..." />
    <meta name="author" content="HZIT" />
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name='apple-touch-fullscreen' content='yes'>
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="address=no">
    <link rel="icon" href="../../images/icon/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon-precomposed" sizes="57x57" href="../../images/icon/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="120x120" href="../../images/icon/apple-touch-icon-120x120-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="196x196" href="../../images/icon/apple-touch-icon-196x196-precomposed.png">
    <meta name="viewport" content="initial-scale=1, width=device-width, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="../../css/style.css" />
    <script src="../../js/jquery.js"></script>
    <script>
        $(document).ready(function(){
            $(".searchHistory dd:last a").click(function(){
                var clear=confirm("确定清除搜索记录吗?");
                if(clear==true){
                    $(this).parents(".searchHistory").find("dd").remove();
                    var memberId=${sessionScope.member.memberId}
                            $.post("deleteSearchinfoBymemberId",{ memberId:memberId}, function (result) {
                                console.log(result);
                                if (result!=0) {
                                    alert("删除成功")
                                } else{
                                    alert("删除失败")
                                }
                            });

                }
            });
        });
    </script>
</head>
<body>
<!--header-->
<header>
    <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
    <h1>搜索</h1>
</header>
<aside class="searchArea">
    <input type="text" placeholder="查找玻璃品..." id="input_search"/>
    <input type="button" value="&#63;" class="searchBtn" id="searchBtn"/>
</aside>
<dl class="searchHistory">
    <dt>历史搜索</dt>
    <dd id="searchHistory">
        <ul>
            <c:forEach items="${searchlist}" var="sl">
                <li><a class="historyClick" id="historyClick${sl.sId}" title="${sl.sId}">${sl.searchKey}</a></li>
            </c:forEach>
        </ul>
    </dd>
    <dd>
        <a>清空历史记录</a>
    </dd>
</dl>
<section class="productList">
    <ul>

        <li id="moban" style="display:none">
            <a href="product.jsp" class="goodsPic">
                <img src="../../upload/goods001.jpg"/>
            </a>
            <div class="goodsInfor">
                <h2>
                    <a href="product.jsp">水晶骷髅头 工艺品</a>
                </h2>
                <p>
                    <del>5.90</del>
                </p>
                <p>
                    <strong class="price">3.90</strong>
                </p>
                <a class="addToCart">&#126;</a>
            </div>
        </li>
    </ul>
    <a class="more_btn">加载更多</a>
</section>
</body>
</html>
<script>
    $("#searchBtn").on("click", function () {
        var searchContent=$("#input_search").val();
        var memberId=${sessionScope.member.memberId};

                $.post("addSearchinfo",{ memberId:memberId, searchKey:searchContent}, function (data) {
                    if (data!=null) {
                        $(".searchHistory ul").append("<li>"+"<a class='historyClick' id='historyClick"+data.sId+"'   title='"+data.sId+"'>"+data.searchKey+"</a></li>");

                    } else{
                        alert("保存查找记录失败")
                    }
                });

        $.post("findByGoodsNameLike",{goodsName:searchContent}, function (data) {
            $(".productList ul li:gt(0)").remove();
            for(var i =0;i<data.length;i++){
                var li =$("#moban");//找到模版的li标签
                //找到这个li里面的H2标签,并且设置H2的HTML代码 h2表示的是商品的名字
                li.find("H2").html("<a href='goodsinfo"+data[i].goodsId+"'>"+data[i].goodsName+"</a>");
                li.find("a:eq(0)").attr("href","goodsinfo"+data[i].goodsId);

                li.find("a:eq(0)").find("img").attr("src",data[i].goodsImage);

                li.find("p del").html(data[i].goodsOldPrice);

                li.find("p strong").html(data[i].goodsPrice);

                //li.find(".addToCart").attr("onclick","donghua(this)");

                $(".productList ul").append("<li>"+li.html()+"</li>");

            }

        });

    });

    $(".historyClick").click(function () {
        sId=$(this).attr("title");
        var searchContent=$("#historyClick"+sId).html();
        $.post("findByGoodsNameLike",{goodsName:searchContent}, function (data) {
            $(".productList ul li:gt(0)").remove();
            for(var i =0;i<data.length;i++){
                var li =$("#moban");//找到模版的li标签
                //找到这个li里面的H2标签,并且设置H2的HTML代码 h2表示的是商品的名字
                li.find("H2").html("<a href='goodsinfo"+data[i].goodsId+"'>"+data[i].goodsName+"</a>");
                li.find("a:eq(0)").attr("href","goodsinfo"+data[i].goodsId);

                li.find("a:eq(0)").find("img").attr("src",data[i].goodsImage);

                li.find("p del").html(data[i].goodsOldPrice);

                li.find("p strong").html(data[i].goodsPrice);

                //li.find(".addToCart").attr("onclick","donghua(this)");

                $(".productList ul").append("<li>"+li.html()+"</li>");

            }

        });
    });

</script>