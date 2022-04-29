<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/15 0015
  Time: 下午 3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="easyui/themes/bootstrap/easyui.css">
  <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
  <link rel="stylesheet" type="text/css" href="./easyui/demo/demo.css">
  <script type="text/javascript" src="easyui/jquery.min.js"></script>
  <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
  <style>
    .westname
    {
      text-decoration:none;
    }
  </style>
  <script type="text/javascript">
      $(function(){
          $('.westname').click(function(){
              var name = this.innerHTML;
              var url = this.href;
              //通过获取的名字创建选项卡
              crateTabs(name,url);
              //让超链接不跳转
              return false;
          });

      });

      //创建tabs的函数
      function crateTabs(name,url){
          if($('#tt').tabs('exists',name)){
              $('#tt').tabs('select',name);
          }else{
              $('#tt').tabs('add',{
                  title:name,
                  content:createUrl(url),
                  closable:true
              });
          }
      }
      //使用iframe转化里面的数据使之返回的是url里面的数据
      function createUrl(url){
          return "<iframe src='"+url+"' style='border:0px;width:100%;height:95%;'></iframe>";
      }

  </script>

</head>
<body>
<div id="cc" class="easyui-layout" data-options="fit:true">
  <div data-options="region:'north',title:'CRM管理系统',split:true" style="height:100px;background-color: #0081c2">

    <font size="6" color=white><div>
             <span>
                   <script type="text/javascript">
                     var date = new Date();
                     document.write(date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日" + " 星期" + "日一二三四五六".charAt(date.getDay()));
                   </script>
             </span>
    </div></font>

    <%--<img src="img/2.png" width="100% "height="100%"/>--%>
  </div>

  <div data-options="region:'west',title:'系统菜单',split:true" style="width:240px;">
    <div id="aa" class="easyui-accordion"  data-options="fit:true">
      <div title="客户管理" data-options="iconCls:'icon-reload',selected:true" style="overflow: auto; padding: 10px;background-color: #DCDCE2">
        <a href="customer.jsp" class="westname" >客户管理</a>
        <br><a href="department.jsp" class="westname" >部门信息</a></br>
        <a href="employee.jsp" class="westname" >员工管理</a>
      </div>
      <div title="数据管理" data-options="iconCls:'icon-reload'" style="padding: 10px;background-color: #DCDCE2">
        <a href="linkMen.html" class="westname">字典目录</a>
        <br><a href="linkMen.html" class="westname">字典明细</a></br>
      </div>
      <div title="员工管理" data-options="iconCls:'icon-reload'" style="padding: 10px;background-color: #DCDCE2">
        <a href="#" class="westname">员工管理</a>
      </div>
      <div title="订单管理" data-options="iconCls:'icon-reload'" style="padding: 10px;background-color: #DCDCE2">
        <a href="#" class="westname">订单管理</a>
      </div>
      <div title="地址管理" data-options="iconCls:'icon-reload'" style="padding: 10px;background-color: #DCDCE2">
        <a href="#" class="westname">地址管理</a>
      </div>
    </div>
  </div>

  <div data-options="region:'center',title:''" style="padding:5px;background:#eee;">
    <div id="tt" class="easyui-tabs" data-options="fit:true">
      <div align="center" title="主页" data-options="closable:true" style="overflow: auto; padding: 20px; display: none;background-color: white;">
        <form id="bdfm" target="_blank" name="bdfm" method="get" action="http://www.baidu.com/s">
          <table>
            <tr>
              <td>
                <a href="http://www.baidu.com">
                  <img src="img/baidu.png"/>
                </a>
              </td>
              <td><br/><input type="text" id="search1" name="word"/></td>
              <td><br/><input type="submit" value="搜索" /></td>
            </tr>
          </table>
        </form>
        <img src="img/1.png" alt="some_text">
      </div>
    </div>
  </div>
</div>

</body>
</html>


