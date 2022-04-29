<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/20 0020
  Time: 上午 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>客户管理</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        var url;
        $(function(){
            $('#dg').datagrid({
                url:'getAllUser',
                columns:[[
                    {field:'id',title:'id',width:100},
                    {field:'name',title:'用户名',width:100},
                    {field:'password',title:'密码',width:100}
                ]] ,
                striped:'true',
                pagination:'true',
                pagePosition:'bottom',
                pageNumber:1,
                pageSize:5,
                pageList: [3,5,10]

            });
        });

        function newUser(){$('#winAdd').window('open');}

        function save(){
            //提交表单数据
            $('#formAdd').form('submit', {
                url:"saveUser"
            });
            alert('保存成功');
            //关闭窗口
            $("#winAdd").window("close");
            //表格重新加载
            $("#dg").datagrid("reload");
        }

        function deleteUser() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $.messager.confirm("系统提示", "您确定要删除这条记录吗?", function (r) {
                    if (r) {
                        $.post('userDelete', {id: row.id}, function (result) {
                            if (result.success) {
                                $.messager.alert("系统提示", "已成功删除这条记录!");
                                $("#dg").datagrid("reload");
                            } else {
                                $.messager.alert("系统提示", result.errorMsg);
                            }
                        }, 'json');
                    }
                });
            }
        }

        function editUser(){
            var row=$('#dg').datagrid('getSelected');
            if(row){
                $("#dlg").dialog('open').dialog('setTitle','编辑用户');
                $('#formAdd2').form('load',row);//把表单数据带过来进行填充
                url='userSave?id='+row.id;
            }
        }
        function saveUser(){
            $('#formAdd2').form('submit',{
                url:url,
                onSubmit:function(){
                    return $(this).form('validate');
                },

            });
            $.messager.alert("系统提示","保存成功");
            $('#dlg').dialog('close');
            $("#dg").datagrid("reload");
        }

    </script>
</head>
<body>
<table id="dg">
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUser()">删除用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="doSearch()">Search</a>
    </div>

</table>
<!-- 添加客户的表单，默认是隐藏的 -->
<div id="winAdd" class="easyui-window" title="添加客户" style="width:600px;height:400px"
     data-options="iconCls:'icon-save',modal:true,closed:true">
    <form id="formAdd" method="post">
        <TABLE  cellSpacing=0 cellPadding=5  border=0>
            <TR>
                <td>用户名：</td>
                <td>
                    <INPUT class=textbox  style="WIDTH: 180px" maxLength=50 name="name">
                </td>
                <td>密码 ：</td>
                <td>
                    <INPUT class=textbox  dstyle="WIDTH: 180px" maxLength=50 name="password">
                </td>
            </TR>

            <tr>
                <td rowspan=2>
                    <button id="customerBtn" type="button" onclick="save()">保存</button>
                </td>
            </tr>
        </TABLE>
    </form>
</div>
<!-- 编辑客户的表单，默认是隐藏的 -->
<div id="dlg" class="easyui-window" title="编辑客户" style="width:600px;height:400px"
     data-options="iconCls:'icon-save',modal:true,closed:true">
    <form id="formAdd2" method="post">
        <TABLE  cellSpacing=0 cellPadding=5  border=0>
            <TR>
                <td>用户名：</td>
                <td>
                    <INPUT class=textbox  style="WIDTH: 180px" maxLength=50 name="name">
                </td>
                <td>密码 ：</td>
                <td>
                    <INPUT class=textbox  dstyle="WIDTH: 180px" maxLength=50 name="password">
                </td>
            </TR>

            <tr>
                <td rowspan=2>
                    <button id="customerBtn2" type="button" onclick="saveUser()">保存</button>
                </td>
            </tr>
        </TABLE>
    </form>
</div>

</body>
</html>
