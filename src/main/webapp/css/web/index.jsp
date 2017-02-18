<%@ page import="com.table.house.entity.House" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: gbq
  Date: 2017/2/18
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房源</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0" width="100%" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold;">
        <th>新闻编号</th><th>新闻标题</th><th>发布人</th><th>来源</th><th>发布时间</th><th width="100" colspan="2">操作</th></tr>
    <%
        //循环显示数据
        List<House> houseList=(List<House>)request.getAttribute("houseList"); // 取request里面的对象队列
        if(houseList.size()!=0){
            for (House aHouseList : houseList) {
                pageContext.setAttribute("house", aHouseList);
                //保存到页面pageContext里面方便下面进行EL表达式调用
    %>
    <tr>
        <td hidden>${house.id }</td>
        <td><img src="${house.image }" width="20%" height="100px" alt="房子图片" /></td>%
        <td>${house.title }</td>
        <td>${house.location }</td>
        <td>${house.cost }</td>
    </tr>
    <%
        }
    }else{
    %>
    <tr><td colspan="6">数据库中没有数据！</td></tr>
    <%
        }
    %>
</table>
</body>
</html>
