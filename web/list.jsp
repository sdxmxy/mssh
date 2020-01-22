<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
    将声明头更改为jsp 的声明头文件 ，并且增加一个标签库，
    控制标签可以完成输出流程控制，例如分支，循环等操作，也可以完成对集合的合并，排序等操作。（具体用法建议 百度）
--%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
</head>

<body>
<s:iterator value="list" var="p">
    <h1>${p.id}</h1>
    <h1>${p.name}</h1>
    <h1>${p.type}</h1>
</s:iterator>
</body>
</html>