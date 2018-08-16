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
 <title>找回密码-合众饰品专卖</title>
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
</head>
<body>
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>找回密码</h1>
</header>
<ul class="formarea">
 <li>
  <label class="lit">账号：</label>
  <input type="text" placeholder="手机号码" class="textbox" id="phone"/>
 </li>
 <li style="padding:0;"><a class="checkCode">获取手机校验码</a></li>
 <li>
  <label class="lit">校验码：</label>
  <input type="text" placeholder="六位校验码" class="textbox" />
 </li>
 <li>
  <label class="lit">新密码：</label>
  <input type="password" placeholder="设置新密码" class="textbox" id="newpw"/>
 </li>
 <li>
  <label class="lit">确认密码：</label>
  <input type="password" placeholder="确认新密码" class="textbox"id="surepw"/>
 </li>
 <li>
  <input type="button" value="立即修改"id="surexiugai"/>
 </li>
</ul>
<!--fixedNav:footer-->
<div style="height:1.2rem;"></div>
<nav>
 <a href="index" class="homeIcon">首页</a>
 <a href="category" class="categoryIcon">分类</a>
 <a href="cart" class="cartIcon">购物车</a>
 <a href="user" class="userIcon">我的</a>
</nav>
</body>
</html><script>
 $("#surexiugai").on("click", function () {
  console.log("loading");
  var phone=$("#phone").val();
  var newpw=$("#newpw").val();
  var surepw=$("#surepw").val();
  //ajax方式提交表单
  $.post("forgetpwd",{password:newpw,telphone:phone}, function (result) {
   console.log(result);
   if (result != 2&&newpw==surepw) {
    alert("找回成功")
    location.href = "login";
   }

   else if(result==2){
    alert("请输入正确的手机号")
   }
   else if(result!=2&&newpw!=surepw){
    alert("前后密码不一致")
   }
  })
 });
</script>

