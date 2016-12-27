<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/header.jsp"%>
<script src="/js/jquery-1.11.0.min.js"></script>
<title>用户记录管理</title>
</head>
<body>
	<%
		List itemCategoryList = (List) request.getAttribute("list");
	%>
	<select name="category" class="select1" id="category">
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="3">没有符合条件的数据</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="itemCategoryList">
					<tr>
						<td>${list.name }</td>
						<td>${list.password }</td>
						<td>${list.usrl }</td>
						<td><a href="javascript:edit(${list.id })">编辑</a> 
						<a href="javascript:delete(${list.id })"></a></td>
					</tr>
				</c:forEach>
			</c:otherwise>

		</c:choose>

	</select>
<body>
</body>
</html>