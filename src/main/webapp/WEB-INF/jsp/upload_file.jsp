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
    <title>上传-合众饰品专卖</title>
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
    <script src="../../js/ajaxform.js"></script>
</head>
<body>
<!--header-->
<header>
    <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
    <h1>上传创意作品</h1>
</header>
<div class="upload_file">
    <ul>
        <li>
            <form id="pic"  action="uploadimage" method="post" enctype="multipart/form-data">
                <label id="file_pic">
                    <input  type="file" name="fs" style="display:none;"/>
                    <img src="../../images/uploadImg.png" id="img"/>
                </label>
            </form>
        </li>
        <li>
            <label>标题：</label>
            <input type="text" placeholder="作品标题..." id="input_title"/>
        </li>
        <li>
            <label>内容：</label>
            <textarea placeholder="作品概要..." id="input_content"></textarea>
        </li>
        <li>
            <label>作者：</label>
            <input type="text" placeholder="作者..." value="${sessionScope.member.memberName}"/>
        </li>
        <li><input type="button" value="提交作品" id="input_submit"/></li>
    </ul>
</div>
<script>
var showImg = document.querySelector("#file_pic");
var getImg = document.querySelector("input[type='file']");
if(typeof FileReader==='undefined'){
showImg.innerHTML = "抱歉，你的浏览器不支持!";
getImg.setAttribute('disabled','disabled');
}else{
getImg.addEventListener('change',readFile,false);
}
function readFile(){
var file = this.files[0];
if(!/image\/\w+/.test(file.type)){
alert("请上传图片！");
return false;
}
var reader = new FileReader();
reader.readAsDataURL(file);
reader.onload = function(e){
    //showImg.innerHTML ='<img src="'+this.result+'"/>' ;
    $("#img").attr("src",this.result);
}
}
</script>
</body>
</html>
<script>

    $("#input_submit").on("click", function () {
        var title=$("#input_title").val();
        var content=$("#input_content").val();
        var  memberId="${sessionScope.member.memberId}";
        $("#pic").ajaxSubmit({
            success:function(data){
                $.post("addGooods", {goodsSubtitle: title, goodsDescription: content, memberId: memberId, goodsImage:data},
                        function (result) {
                            console.log(result);
                            if (result != 0) {
                                alert("发布成功")
                                window.location.reload();
                            } else {
                                alert("发布失败")
                            }
                        });
            }
        });


    })
</script>