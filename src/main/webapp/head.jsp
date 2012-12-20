<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>ateyes ssh</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/bootstrap/css/bootstrap-responsive.min.css" >
    
    <style type="text/css">
    body {
        padding-top: 60px;
    }
    </style>
</head>
<body>


<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
  <div class="container">
    <a class="brand" href="#">ateyes ssh</a>
    <div class="nav-collapse collapse">
      <ul class="nav">
          <% Integer active = Integer.parseInt(request.getParameter("active")); %>
        <li class="<% if (active == 1) out.print("active"); %>"><a href="/">首页</a></li>
        <li class="<% if (active == 2) out.print("active"); %>"><a href="#about">购买流程</a></li>
        <li class="<% if (active == 3) out.print("active"); %>"><a href="#contact">windows 教程</a></li>
        <li class="<% if (active == 3) out.print("active"); %>"><a href="#contact">mac 教程</a></li>
      </ul>
      <form class="navbar-form pull-right" action="/login" method="post">
        <input class="span2" type="text" name="username" placeholder="用户名">
        <input class="span2" type="password" name="passwd" placeholder="密码">
        <button type="submit" class="btn">登陆</button>
      </form>
    </div><!--/.nav-collapse -->
  </div>  
  </div>
</div>



