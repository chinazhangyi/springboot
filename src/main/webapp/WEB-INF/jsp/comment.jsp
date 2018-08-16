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
 <title>点评-合众饰品专卖</title>
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
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>点评</h1>
</header>
<div class="comment_input">
 <textarea placeholder="输入评论内容..."  id="comment_content"></textarea>
 <input type="button" value="评论"   id="comment_input"/>
</div>
<div class="comment_cont">
 <ul>
  <c:forEach items="${commentlist}" var="c">
   <li>
    <div class="user_infor">
     <span class="user_pic"><img src="${c.scommMemberavatar}"/></span>
    <span class="rt_infor">
     <em>${c.scommMembername}</em>
     <time>${c.scommTime}</time>
    </span>
    </div>
    <div class="comment_cont_txt">${c.scommContent}</div>
   </li>
  </c:forEach>
 </ul>
</div>
</body>
</html>
<script>
 $("#comment_input").on("click", function () {
  var goodsId=${sessionScope.goodsinfo.goodsId}
  var content=$("#comment_content").val();
  var memberId=${sessionScope.member.memberId};
  var memberName="${sessionScope.member.memberName}";
          $.post("goodsCommentInsert",{goodisId:goodsId,scommMemberid:memberId,scommContent:content,memberName:memberName}, function (result) {
           console.log(result);
           if (result) {
            alert("评论成功")
            window.location.reload();
           } else{
            alert("评论失败")
           }
          });

  $.post("addcomment_num",{ goodsid:goodsId}, function (result) {
   console.log(result);
   if (result!=0) {
    alert("评论次数次数加")
    window.location.reload();
   } else{
    alert("评论次数次数不变")
   }
  });
 });
</script>