<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目 - 异清轩博客管理系统</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$(".parent").click(function(){		
        var id = $(this).attr("rel"); //对应id
            $.ajax({
                type: "POST",
                url: "/admin/scCategory",
                data: {
					'id' : id,
					},
                cache: false, //不缓存此页面   
                success: function (data) {
                	var html="";
                	for (var i = 0 ; i < data.length ; i++){
                		var href = "/admin/delScCategory?id=" + data[i].id;
                		
                		html+="<tr>"+
                		"<td>"+ data[i].name +"</td>"+
                		"<td>"+ data[i].alias +"</td>"+
                		"<td>"+ data[i].pname +"</td>"+
                		"<td><a>修改</a>&nbsp;<a href='" + href + "'>删除</a></td>"
                		+"</tr>"
                	}
                	$("#categorySc").html(html);
                }
            });
            $('#seeComment').modal('show');
	});
	
	$(".delParentcategory").click(function(){
		 var id = $(this).attr("rel");
		 if(confirm("确认删除吗?")){
		 $.ajax({
             type: "POST",
             url: "/admin/delPcategory",
             data: {
					'id' : id,
					},
             cache: false, //不缓存此页面   
             success: function (data) {
            	 	window.location.href=(data);
             	}            
		});
		}
	});
	
	
});
</script>

<body class="user-select">
<section class="container-fluid">
  <header>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="/">YlsatCMS</a> </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="">消息 <span class="badge">1</span></a></li>
            <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">admin <span class="caret"></span></a>
              <ul class="dropdown-menu dropdown-menu-left">
                <li><a title="查看或修改个人信息" data-toggle="modal" data-target="#seeUserInfo">个人信息</a></li>
                <li><a title="查看您的登录记录" data-toggle="modal" data-target="#seeUserLoginlog">登录记录</a></li>
              </ul>
            </li>
            <li><a href="login" onClick="if(!confirm('是否确认退出？'))return false;">退出登录</a></li>
            <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>
          </ul>
          <form action="" method="post" class="navbar-form navbar-right" role="search">
            <div class="input-group">
              <input type="text" class="form-control" autocomplete="off" placeholder="键入关键字搜索" maxlength="15">
              <span class="input-group-btn">
              <button class="btn btn-default" type="submit">搜索</button>
              </span> </div>
          </form>
        </div>
      </div>
    </nav>
  </header>
  <div class="row">
    <aside class="col-sm-3 col-md-2 col-lg-2 sidebar">
      <ul class="nav nav-sidebar">
        <li><a href="/admin/index">报告</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="/admin/article">文章</a></li>
        <li><a href="/admin/notice">公告</a></li>
        <li><a href="/admin/comment">评论</a></li>
        <li><a data-toggle="tooltip" data-placement="top" title="网站暂无留言功能">留言</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li class="active"><a href="/admin/category">栏目</a></li>
        <li><a class="dropdown-toggle" id="otherMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">其他</a>
          <ul class="dropdown-menu" aria-labelledby="otherMenu">
            <li><a href="/admin/flink">友情链接</a></li>
            <li><a href="/admin/loginlog">访问记录</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a class="dropdown-toggle" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">用户</a>
          <ul class="dropdown-menu" aria-labelledby="userMenu">
            <li><a href="#">管理用户组</a></li>
            <li><a href="/admin/manage-user">管理用户</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="/admin/loginlog">管理登录日志</a></li>
          </ul>
        </li>
        <li><a class="dropdown-toggle" id="settingMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">设置</a>
          <ul class="dropdown-menu" aria-labelledby="settingMenu">
            <li><a href="/admin/setting">基本设置</a></li>
            <li><a href="/admin/readset">用户设置</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">安全配置</a></li>
            <li role="separator" class="divider"></li>
            <li class="disabled"><a>扩展菜单</a></li>
          </ul>
        </li>
      </ul>
    </aside>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
      <div class="row">
        <div class="col-md-5">
          <h1 class="page-header">添加</h1>
          <form action="/addCategory" method="post" autocomplete="off">
            <div class="form-group">
              <label for="category-name">栏目名称</label>
              <input type="text" id="category-name" name="name" class="form-control" placeholder="在此处输入栏目名称" required autocomplete="off">
              <span class="prompt-text">这将是它在站点上显示的名字。</span> </div>
            <div class="form-group">
              <label for="category-alias">栏目别名</label>
              <input type="text" id="category-alias" name="alias" class="form-control" placeholder="在此处输入栏目别名" required autocomplete="off">
              <span class="prompt-text">“别名”是在URL中使用的别称。</span> </div>
            <div class="form-group">
              <label for="category-fname">父节点</label>
              <select id="category-fname" class="form-control" name="pid">
                <option value="0" selected>无</option>
                <c:forEach var="category" items="${pagination.list }" >
                <option value="${category.id }">${category.name }</option>
                </c:forEach>
              </select>
              <span class="prompt-text">栏目是有层级关系的，您可以有一个“音乐”分类目录，在这个目录下可以有叫做“流行”和“古典”的子目录。</span> </div>
            <div class="form-group">
              <label for="category-describe">描述</label>
              <textarea class="form-control" id="category-describe" name="description" rows="4" autocomplete="off"></textarea>
              <span class="prompt-text">描述会出现在网页的description属性中。</span> </div>
            <button class="btn btn-primary" type="submit" name="submit">添加新栏目</button>
          </form>
        </div>
        <div class="col-md-7">
          <h1 class="page-header">管理 <span class="badge">3</span></h1>
          <div class="table-responsive">
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th><span class="glyphicon glyphicon-paperclip"></span> <span class="visible-lg">序号</span></th>
                  <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">名称</span></th>
                  <th><span class="glyphicon glyphicon-list-alt"></span> <span class="visible-lg">别名</span></th>
                  <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
                </tr>
              </thead>
              <tbody>
              <c:set value="0" var="count"></c:set>
              <c:forEach var="category" items="${pagination.list }" varStatus="vs">
              	<tr>
                  <td>${vs.count}</td>
                  <td>${category.name }</td>
                  <td>${category.alias }</td>
                  <td>
                  	<a href="/admin/update-category">修改</a> 
                  	<a class="parent" rel="${category.id }">子栏目</a>
                  	<a class="delParentcategory" rel="${category.id }">删除</a>
                  	</td>
                </tr>
              </c:forEach>
                               
                
              </tbody>
            </table>
            
     <div class="modal fade" id="seeComment" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  	  	<div class="modal-dialog" role="document">
      	<div class="modal-content">
        <div class="modal-header">
          	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          	<h4 class="modal-title" >查看子节点</h4>
        </div>
        <div class="modal-body">
          	<table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">名称</span></th>
                  <th><span class="glyphicon glyphicon-list-alt"></span> <span class="visible-lg">别名</span></th>
                  <th><span class="glyphicon glyphicon-link"></span> <span class="visible-lg">父节点</span></th>
                  <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
                </tr>
              </thead>
              <tbody id="categorySc">
              	 
              </tbody>
            </table>	
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">朕已阅</button>
        </div>
      </div>
  </div>
</div>

            <span class="prompt-text"><strong>注：</strong>删除一个栏目也会删除栏目下的文章和子栏目,请谨慎删除!</span> </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!--个人信息模态框-->
<div class="modal fade" id="seeUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <form action="" method="post">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" >个人信息</h4>
        </div>
        <div class="modal-body">
          <table class="table" style="margin-bottom:0px;">
            <thead>
              <tr> </tr>
            </thead>
            <tbody>
              <tr>
                <td width="20%">姓名:</td>
                <td width="80%"><input type="text" value="王雨" class="form-control" name="truename" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td width="20%">用户名:</td>
                <td width="80%"><input type="text" value="admin" class="form-control" name="username" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td width="20%">电话:</td>
                <td width="80%"><input type="text" value="18538078281" class="form-control" name="usertel" maxlength="13" autocomplete="off" /></td>
              </tr>
              <tr>
                <td width="20%">旧密码:</td>
                <td width="80%"><input type="password" class="form-control" name="old_password" maxlength="18" autocomplete="off" /></td>
              </tr>
              <tr>
                <td width="20%">新密码:</td>
                <td width="80%"><input type="password" class="form-control" name="password" maxlength="18" autocomplete="off" /></td>
              </tr>
              <tr>
                <td width="20%">确认密码:</td>
                <td width="80%"><input type="password" class="form-control" name="new_password" maxlength="18" autocomplete="off" /></td>
              </tr>
            </tbody>
            <tfoot>
              <tr></tr>
            </tfoot>
          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!--个人登录记录模态框-->
<div class="modal fade" id="seeUserLoginlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" >登录记录</h4>
      </div>
      <div class="modal-body">
        <table class="table" style="margin-bottom:0px;">
          <thead>
            <tr>
              <th>登录IP</th>
              <th>登录时间</th>
              <th>状态</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>::1:55570</td>
              <td>2016-01-08 15:50:28</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:64377</td>
              <td>2016-01-08 10:27:44</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:64027</td>
              <td>2016-01-08 10:19:25</td>
              <td>成功</td>
            </tr>
            <tr>
              <td>::1:57081</td>
              <td>2016-01-06 10:35:12</td>
              <td>成功</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<!--微信二维码模态框-->
<div class="modal fade user-select" id="WeChat" tabindex="-1" role="dialog" aria-labelledby="WeChatModalLabel">
  <div class="modal-dialog" role="document" style="margin-top:120px;max-width:280px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
      </div>
      <div class="modal-body" style="text-align:center"> <img src="/res/images/weixin.jpg" alt="" style="cursor:pointer"/> </div>
    </div>
  </div>
</div>
<!--提示模态框-->
<div class="modal fade user-select" id="areDeveloping" tabindex="-1" role="dialog" aria-labelledby="areDevelopingModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="areDevelopingModalLabel" style="cursor:default;">该功能正在日以继夜的开发中…</h4>
      </div>
      <div class="modal-body"> <img src="/res/images/baoman/baoman_01.gif" alt="深思熟虑" />
        <p style="padding:15px 15px 15px 100px; position:absolute; top:15px; cursor:default;">很抱歉，程序猿正在日以继夜的开发此功能，本程序将会在以后的版本中持续完善！</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<!--右键菜单列表-->
<div id="rightClickMenu">
  <ul class="list-group rightClickMenuList">
    <li class="list-group-item disabled">欢迎访问异清轩博客</li>
    <li class="list-group-item"><span>IP：</span>172.16.10.129</li>
    <li class="list-group-item"><span>地址：</span>河南省郑州市</li>
    <li class="list-group-item"><span>系统：</span>Windows10 </li>
    <li class="list-group-item"><span>浏览器：</span>Chrome47</li>
  </ul>
</div> 
</body>

</html>