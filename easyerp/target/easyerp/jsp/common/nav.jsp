<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"  isELIgnored="false" %>
<%@include file="../common/taglib.jsp"%>

<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span><span
				class="icon-bar"></span><span class="icon-bar"></span><span
				class="icon-bar"></span>
		</button>
		<c:url value="/loginAction!welcome.do" var="welcome"></c:url>
		<a class="navbar-brand" href="${welcome }">订单管理系统</a>
	</div>

	<div class="collapse navbar-collapse"
		 id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<c:url value="/loginAction!homePage.do" var="homepage"></c:url>
			<li id ="home"><a href="${homepage }">首页</a></li>
			<li class="dropdown" id ="customer">
			    <a href="#" class="dropdown-toggle"
				   data-toggle="dropdown">客户<strong class="caret"></strong></a>
				<ul class="dropdown-menu">
					<c:url value="/customerManageAction!query.do" var="cquery"></c:url>
					<li><a href="${cquery }">客户信息查询</a></li>
					
					<c:url value="/customerManageAction!addUI.do" var="caddui"></c:url>
					<li><a href="${caddui }">新增客户</a></li>
					
					<li class="divider"></li>
					<c:url value="/customerAction!getCustomerAll.do" var="getcustomer"></c:url>
					<li><a href="${getcustomer }">客户管理</a></li>
				</ul>
			</li>
			<li class="dropdown">
			    <a href="#" class="dropdown-toggle"
				   data-toggle="dropdown" id="order">订单<strong class="caret"></strong></a>
				<ul class="dropdown-menu">
					<c:url value="/orderManageAction!query.do" var="orderquery"></c:url>
					<li><a href="${orderquery }">订单查询</a></li>
					
					<c:url value="/orderManageAction!addUI.do" var="orderadd"></c:url>
					<li><a href="${orderadd }">新增订单</a></li>
					
					<li class="divider"></li>
					<c:url value="/orderAction!getOrderAll.do" var="orderget"></c:url>
					<li><a href="${orderget }">订单管理</a></li>
				</ul>
			</li>
			<c:if test="${!empty user and user.grade gt 2}">
				<li class="dropdown">
				    <a href="#" class="dropdown-toggle"
					   data-toggle="dropdown" id="user">用户<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<c:url value="/userAction!addUI.do" var="uaddui"></c:url>
						<li><a href="${uaddui }">新增用户</a></li>
						
						<c:url value="/userAction!getUserAll.do" var="uget"></c:url>
						<li><a href="${uget }">用户管理</a></li>
					</ul>
				</li>
			</c:if>
			<li id ="help"><a href="#">帮助</a></li>
		</ul>
		<form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${empty user}">
				<c:url value="/loginAction!loginUI.do" var="loginui"></c:url>
				<li id="login"><a href="${loginui }">登录</a></li>
			</c:if>
			<c:if test="${!empty user}">
				<!-- <li id="login"><a href="login.do">重新登录</a></li> -->
				<li class="dropdown" id="username">
				   <a href="#" class="dropdown-toggle" data-toggle="dropdown">
					  用户名： ${user.username}
					  <strong class="caret"></strong>
				    </a>
					<ul class="dropdown-menu">
						<c:url value="/userAction!modPwdUI.do" var="modpwdui"></c:url>
						<li><a href="${modpwdui }">密码修改</a></li>
						
						<li class="divider"></li>
						<c:url value="/loginAction!logoff.do" var="logoff"></c:url>
						<li><a href="${logoff }">退出</a></li>
					</ul>
				</li>
			</c:if>
		</ul>
	</div>

</nav>

<div>
	<span class="label label-default" style="float: right;">${user.gradeName}</span>
</div>