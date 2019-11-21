<%--
  Created by IntelliJ IDEA.
  User: 23208
  Date: 2019/11/21
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>图片上传页面</title>
    <style>
        .box {
            width: 100px;
            height: 100px;
            position: relative;
        }
        .box img {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
        }
        .file-input {
            position: absolute;
            top: 0;
            left: 0;
            width: 100px;
            height: 100px;
            z-index: 9999;
            opacity: 0;
            cursor: pointer;
        }
        .btn {
            width: 60px;
            height: 30px;
            margin-top: 30px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<form action="/api/upload" method="post" enctype="multipart/form-data">
    <div class="box">
        <input type="file" name="filename" class="file-input" multiple>
        <img src="http://img0.imgtn.bdimg.com/it/u=2318040445,1627411019&fm=26&gp=0.jpg" alt="">
    </div>
    <input type="submit" value="上传" class="btn">
</form>
<p>${msg}</p>
</body>
</html>
