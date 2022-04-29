<%--
  Created by IntelliJ IDEA.
  Department: elbadaernU9.9
  Date: 2020/6/21
  Time: 17:45
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
<table id="dg" title="My Departments" class="easyui-datagrid" style="width:550px;height:250px"id
       url="getAllDepartment"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="Name" width="50">number</th>
        <th field="Departmentname" width="50">Departmentname</th>
        <th field="Departmentfunction" width="50">Departmentfunction</th>
    </tr>
    </thead>
</table>
<div ="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newDepartment()">New Department</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDepartment()">Edit Department</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyDepartment()">Remove Department</a>
</div>


</body>
</html>
