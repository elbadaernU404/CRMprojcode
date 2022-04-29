<%--
  Created by IntelliJ IDEA.
  User: elbadaernU9.9
  Date: 2020/6/23
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRM系统</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body >
<table id="dg1" title="My Employees" class="easyui-datagrid" style="width:550px;height:250px"id
       url="getAllEmployee"
       toolbar="#toolbar1"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="Id" width="50">id</th>
        <th field="Employeename" width="50">Employeename</th>
        <th field="Employeedept" width="50">Employeedept</th>
        <th field="Employeeemail" width="50">Employeeemail</th>
    </tr>
    </thead>
</table>
<div id="toolbar1">
<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newEmployee()">New Employee</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editEmployee()">Edit Employee</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyEmployee()">Remove Employee</a>
</div>


</body>
</html>

