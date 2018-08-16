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
    <title>分类列表-合众饰品专卖</title>
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
    <script src="../../js/swiper.min.js"></script>
    <script>
        $(document).ready(function(){
            $(".des_icon").click(function(){
                $(this).toggleClass("asc_icon");
            });
            $(".drop_icon").click(function(){
                $(".drop_list").toggle();
                $(".drop_list li a").click(function(){
                    $(this).parents(".drop_list").hide();
                });
            });
            var mySwiper = new Swiper('.swiper-container',{
                slidesPerView :5,
                slidesPerGroup :5
            })
        });
        //定义了一个方法实现动画效果
        function donghua(obj){
            obj=$(obj);  //将普通的对象转换成 jquery对象
            //修改购物车数量的显示
            $(".hoverCart a").html(parseInt($(".hoverCart a").html())+1);/*测试+1*/
            //拿到样式类别为hoverCart的坐标
            var shopOffset = $(".hoverCart").offset();
            //复制图片的元素
            var cloneDiv = obj.parent().siblings(".goodsPic").clone();
            //获取图片的坐标
            var proOffset = obj.parent().siblings(".goodsPic").offset();
            //设置这个图片初始样式
            cloneDiv.css({ "position": "absolute", "top": proOffset.top, "left": proOffset.left });
            //将图片追加到类别为goodsPic的父元素上面
            obj.parent().siblings(".goodsPic").parent().append(cloneDiv);
            //开始一个移动的动画效果
            cloneDiv.animate({
                width:0,
                height:0,
                left: shopOffset.left,
                top: shopOffset.top,
                opacity:1
            },5000,function(){
                $(this).remove();
            });
        }
    </script>



    <script>
        //JAVASCRIPT方法的定义
        function chaShangpin(cid){
            var url="goodsinfobycategory"+cid;
            $.post(url,function(data){
                //这里的data参数就是控制器中输出的json字符串
                //        alert(data);
                //循环这个data的json数据。不断的拼接新的HTML代码。然后追加到一个类型为(class="productList")
                // 的标签下的ul标签下
                //var html=$(".productList ul").html();   //输出指定的某个元素的HTML标签
                //先清空掉UL里面的li元素。但是第一个li元素不能删除
                $(".productList ul li:gt(0)").remove()
                for(var i=0;i<data.length;i++){
                    var li=$("#moban"); //找到模版的LI标签
                    //找到这个li里面的H2标签,并且设置H2的HTML代码
                    li.find("H2").html("<a href='goodsinfo"+data[i].goodsId+"'>"+data[i].goodsName+"</a>");
                    //找到这个li里面的第一个A标签,并且设置他的href属性
                    li.find("a:eq(0)").attr("href","goodsinfo"+data[i].goodsId);
                    //找到这个li里面的第一个A标签里面的img标签，并且设置他的src属性
                    li.find("a:eq(0)").find("img").attr("src","upload/image/"+data[i].goodsImage);
                    //找到这里li里面的p标签里面的del标签。并设置他的html内容
                    li.find("p del").html(data[i].goodsPrice);
                    //找到这里li里面的p标签里面的strong标签。并设置他的html内容
                    li.find("p strong").html(data[i].goodsSellPrice);
                    //找到这里li里面的类型为addToCart的标签并为其添加了一个点击事件，当点击的时候调用一个叫做donghua的方法。把自己传入到方法中
                    li.find(".addToCart").attr("onclick","donghua(this)");
                    $(".productList ul").append("<li>"+li.html()+"</li>");
                }
            });
        }
    </script>
</head>
<body style="background:white;">
<!--header-->
<header>
    <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
    <h1>分类列表</h1>
</header>
<!-- category Swiper -->
<div class="swiper-container category_list">
    <ul class="swiper-wrapper">
        <c:forEach items="${catelist}" var="a">
            <li class="swiper-slide"><a href="javascript:chaShangpin( ${a.catId} )">${a.catName}</a></li>
        </c:forEach>
    </ul>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
</div>
<!--asc->1[升序asc_icon];des->0[降序des_icon]-->
<ul class="sift_nav">
    <li><a class="des_icon">价格</a></li>
    <li><a class="des_icon">销量优先</a></li>
    <li>
        <a class="nav_li drop_icon">筛选项目</a>
        <ul class="drop_list">
            <li><a>自定义</a></li>
            <li><a>自定义</a></li>
            <li><a>自定义</a></li>
            <li><a>自定义</a></li>
        </ul>
    </li>
</ul>
<!--productList-->
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
<!--floatCart-->
<div class="hoverCart">
    <a href="cart.jsp">0</a>
</div>
</body>
</html>
