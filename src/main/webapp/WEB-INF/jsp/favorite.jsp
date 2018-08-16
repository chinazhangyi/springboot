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
 <title>我喜欢-合众饰品专卖</title>
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



   //飞入动画，具体根据实际情况调整
   $(".addToCart").click(function(){
    $.post("putcart"+$(this).attr("title"),function(){});
    $(".hoverCart a").html(parseInt($(".hoverCart a").html())+1);/*测试+1*/
    var shopOffset = $(".hoverCart").offset();
    var cloneDiv = $(this).parent().siblings(".goodsPic").clone();
    var proOffset = $(this).parent().siblings(".goodsPic").offset();
    cloneDiv.css({ "position": "absolute", "top": proOffset.top, "left": proOffset.left });
    $(this).parent().siblings(".goodsPic").parent().append(cloneDiv);
    cloneDiv.animate({
     width:0,
     height:0,
     left: shopOffset.left,
     top: shopOffset.top,
     opacity:1
    },"slow");
   });
  });
 </script>


</head>
<body style="background:white;">
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>我喜欢</h1>
</header>
<section class="productList">
 <ul>
  <c:forEach items="${goodsinfolist}" var="gl">
   <li>
    <a href="product.jsp" class="goodsPic">
     <img src="${gl.goodsImage}"/>
    </a>
    <div class="goodsInfor">
     <h2>
      <a href="product.jsp">${gl.goodsName}</a>
     </h2>
     <p>
      <del>${gl.goodsOldPrice}</del>
     </p>
     <p>
      <strong class="price">${gl.goodsPrice}</strong>
     </p>
     <a class="addToCart" title="${gl.goodsId}">&#126;</a>
    </div>
   </li>
  </c:forEach>
 </ul>
 <a class="more_btn">加载更多</a>
</section>
<!--floatCart-->
<div class="hoverCart">
 <a href="getcart">0</a>
</div>
</body>
</html>
