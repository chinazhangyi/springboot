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
<title>作品列表-合众饰品专卖</title>
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
  $(".des_icon").click(function(){
	  $(this).toggleClass("asc_icon");
	  });
  $(".drop_icon").click(function(){
	  $(".drop_list").toggle();
	  $(".drop_list li a").click(function(){
		  $(this).parents(".drop_list").hide();
		  });
	  });
   //飞入动画，具体根据实际情况调整
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
</head>
<body style="background:white;">
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>我的作品</h1>
</header>
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
   <c:forEach items="${searchlist}" var="sl">
   <li>
    <a href="product.jsp" class="goodsPic">
     <img src="${sl.goodsImage}"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="product.jsp">${sl.goodsName}</a>
     </h2>
     <p>
      <del>${sl.goodsOldPrice}</del>
     </p>
     <p>
      <strong class="price">${sl.goodsPrice}</strong>
     </p>
     <a class="addToCart">&#126;</a>
    </div>
   </li>
   </c:forEach>
  </ul>
  <a class="more_btn">加载更多</a>
</section>
<!--floatCart-->
<div class="hoverCart">
 <a href="cart.jsp">0</a>
</div>
</body>
</html>
