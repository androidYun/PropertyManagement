<%--
  Created by IntelliJ IDEA.
  User: lang
  Date: 20/06/2019
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我知道了啊</title>
</head>
<body>
<div style="background-color: aqua">

    <form method="post" action="/xhs/file/imageUpdate" enctype="multipart/form-data">
        选择一个文件:
        <input type="file" name="uploadFile"  multiple/>

        <input type="number" name="propertyContentId" />
        <br/><br/>
        <input type="submit" value="上传" />
    </form>
    <a></a>

</div>
</body>
</html>
