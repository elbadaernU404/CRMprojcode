<%--
  Created by IntelliJ IDEA.
  User: elbadaernU9.9
  Date: 2020/6/23
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工管理</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        var url;
        $(function(){
            $('#dg1').datagrid({
                url:'getAllEmployee',
                columns:[[
                    {field:'id',title:'工号',width:100},
                    {field:'employeename',title:'姓名',width:100},
                    {field:'employeedept',title:'部门',width:100},
                    {field:'employeeemail',title:'联系邮箱',width:100}
                ]] ,
                striped:'true',
                pagination:'true',
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:5,
                pageList: [3,5,10]

            });
        });
        function newEmployee(){$('#winAdda').window('open');}


        function save(){
            //提交表单数据
            $('#formAdda').form('submit', {
                url:"saveEmployee"
            });
            alert('保存成功');
            //关闭窗口
            $("#winAdda").window("close");
            //表格重新加载
            $("#dg1").datagrid("reload");
        }
        function search(){
            //提交表单数据
            $('#formAddaa').form('submit', {
                url:"EmployeeSearch"
            });
            alert('查询成功');
            //关闭窗口
            $("#winAddaa").window("close");
        }
        function deleteEmployee() {
            var row = $('#dg1').datagrid('getSelected');
            if (row) {
                $.messager.confirm("系统提示", "确定开除此员工?", function (r) {
                    if (r) {
                        $.post('employeeDelete', {id: row.id}, function (result) {
                            if (result.success) {
                                $.messager.alert("系统提示", "成功!");
                                $("#dg1").datagrid("reload");
                            } else {
                                $.messager.alert("系统提示", result.errorMsg);
                            }
                        }, 'json');
                    }
                });
            }
        }

        function editEmployee(){
            var row=$('#dg1').datagrid('getSelected');
            if(row){
                $("#dlg1").dialog('open').dialog('setTitle','编辑员工');
                $('#formAdda2').form('load',row);
                url='employeeSave?id='+row.id;
            }
        }

        function searchEmployee(){$('#winAddaa').window('open');}
        function saveEmployee(){
            $('#formAdda2').form('submit',{
                url:url,
                onSubmit:function(){
                    return $(this).form('validate');
                },

            });
            $.messager.alert("系统提示","保存成功");
            $('#dlg1').dialog('close');
            $("#dg1").datagrid("reload");
        }

    </script>
</head>
<body>
<table id="dg1">
    <div id="toolbar1">
        <a href="javascript:void(0)" class="easyui-linkbutton"  plain="true" onclick="newEmployee()">添加员工</a>
        <a href="javascript:void(0)" class="easyui-linkbutton"  plain="true" onclick="editEmployee()">管理员工</a>
        <a href="javascript:void(0)" class="easyui-linkbutton"  plain="true" onclick="deleteEmployee()">开除员工</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchEmployee()">Search</a>
    </div>

</table>

<!-- 添加客户的表单，默认是隐藏的 -->
<div id="winAdda" class="easyui-window" title="添加员工" style="width:600px;height:400px"
     data-options="iconCls:'icon-save',modal:true,closed:true">
    <form id="formAdda" method="post">
        <TABLE  cellSpacing=0 cellPadding=5  border=0>
            <br>
                <td>姓名：</td>
                <td>
                    <INPUT class=textbox  style="WIDTH: 120px" maxLength=30 name="employeename">
                </td>
                <td>部门：</td>
                <td>
                    <INPUT class=textbox  style="WIDTH: 120px" maxLength=30 name="employeedept">
                </td>
                <td>邮箱：</td>
                <td>
                    <INPUT class=textbox  style="WIDTH: 120px" maxLength=30 name="employeeemail">
                </td>
            </TR>

            <tr>
                <td rowspan=2>
                    <button id="employeeBtn" type="button" onclick="save()">保存</button>
                </td>
            </tr>
        </TABLE>
    </form>
</div>
<!-- 编辑客户的表单，默认是隐藏的 -->
<div id="dlg1" class="easyui-window" title="编辑员工" style="width:600px;height:400px"
     data-options="iconCls:'icon-save',modal:true,closed:true">
    <form id="formAdda2" method="post">
        <TABLE  cellSpacing=0 cellPadding=5  border=0>
            <TR>
                <td>姓名：</td>
                <td>
                    <INPUT class=textbox  style="WIDTH: 120px" maxLength=30 name="employeename">
                </td>
                <td>部门：</td>
                <td>
                    <INPUT class=textbox  style="WIDTH: 120px" maxLength=30 name="employeedept">
                </td>
                <td>邮箱：</td>
                <td>
                    <INPUT class=textbox  style="WIDTH: 120px" maxLength=30 name="employeeemail">
                </td>
            </TR>

            <tr>
                <td rowspan=2>
                    <button id="employeeBtn2" type="button" onclick="saveEmployee()">保存</button>
                </td>
            </tr>
        </TABLE>
    </form>
</div>




<div id="winAddaa" class="easyui-window" title="搜索员工" style="width:600px;height:400px"
     data-options="iconCls:'icon-save',modal:true,closed:true">
    <form id="formAddaa" method="post">
        <TABLE  cellSpacing=0 cellPadding=5  border=0>
            <br>
            <td>姓名：</td>
            <td>
                <INPUT class=textbox  style="WIDTH: 120px" maxLength=30 name="employeename">
            </td>

            </TR>

            <tr>
                <td rowspan=2>
                    <button id="employeeBtn3" type="button" onclick="search()">搜索</button>
                </td>
            </tr>
        </TABLE>
    </form>
</div>

</body>
</html>

