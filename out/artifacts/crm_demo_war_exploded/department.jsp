<%--
  Created by IntelliJ IDEA.
  User: elbadaernU9.9
  Date: 2020/6/21
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>部门信息</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        var url;
        $(function(){
            $('#dg').datagrid({
                url:'getAllDepartment',
                columns:[[
                    {field:'number',title:'Number',width:100},
                    {field:'departmentname',title:'部门',width:100},
                    {field:'departmentfunction',title:'权限',width:100}
                ]] ,
                striped:'true',
                pagination:'true',
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:5,
                pageList: [3,5,10]

            });
        });


    </script>
</head>
<body>
<table id="dg">
    <div id="toolbar">
        <a href="javascript:void(0)" ></a>
        <a href="javascript:void(0)" ></a>
        <a href="javascript:void(0)" ></a>
    </div>

</table>


</body>
</html>
