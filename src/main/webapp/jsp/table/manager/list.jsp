<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="/css/jqGrid/ui.jqgrid.css" rel="stylesheet" type="text/css">
    <link href="/css/jqGrid/jquery-ui.structure.min.css" rel="stylesheet" type="text/css">
    <link href="/css/jqGrid/jquery-ui.theme.min.css" rel="stylesheet" type="text/css">
    <link href="/css/jqGrid/jquery-ui.min.css" rel="stylesheet" type="text/css">
    <script src="/js/jquery-1.11.0.min.js"></script>
    <script src="/js/jqGrid/grid.locale-en.js"></script>
    <script src="/js/jqGrid/jquery.jqGrid.min.js"></script>
    <script src="/js/jqGrid/jquery-ui.min.js"></script>
    <title>用户列表</title>
</head>
<body>
<table id="user"></table>
<div id="pager"></div>
<input type="BUTTON" id="add" value="add" style="margin-right: 100px"/>
<input type="BUTTON" id="edit" value="编辑" style="margin-right: 100px"/>
<input type="BUTTON" id="delete" value="删除" style="margin-right: 100px"/>
</body>
<script type="text/javascript" src="/jsp/table/manager/list.js"></script>
</html>