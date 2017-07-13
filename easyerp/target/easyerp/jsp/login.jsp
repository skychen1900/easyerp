<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="./common/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>用户登录</title>

<link href="<%=basePath%>jsp/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="common/nav.jsp"%>
				<div class="row clearfix">
					<div class="col-md-4 column"></div>
					<div class="col-md-3 column">
						<%@include file="common/message.jsp"%>
						<c:url value="/loginAction!login.do" var="login"></c:url> 
						
						<form class="form-horizontal" role="form" method="post"
							action="${login}">
							<div class="page-header">
								<h3>用户登录</h3>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">账　号</span>
									<input
										name="username" type="text" class="form-control"
										placeholder="Username" value="${user.username}" required
										autofocus>
									<span class="glyphicon glyphicon-user form-control-feedback"></span>
								</div>
							</div>

							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">密　码</span> <input
										name="password" type="Password" class="form-control"
										placeholder="Password" value="${user.password}" required>
									<span class="glyphicon glyphicon-lock form-control-feedback"></span>
								</div>
							</div>

							<div class="form-group form-horizontal">
								<div class="row">
									<div class="col-sm-4">
										<input class="form-control" type="text" id="verify"
											maxlength="4" placeholder="验证码" name="checkcode" required>
									</div>
									<div class="col-sm-4">
										<c:url value="/createImageAction.do" var="image"></c:url>
										<c:url value="/createImageAction.do?Math.random()" var="image2"></c:url>  
										<img src="${image}"
											onclick="this.src='/easyerp/createImageAction.do?' + Math.random()"
											title="点击图片刷新验证码" class="img-responsive"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<input class="btn btn-primary btn-block" type="submit"
									value="登　　录" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="<%=basePath%>jsp/js/jquery.min.js"></script>
	<script src="<%=basePath%>jsp/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$('#login').addClass('active');
	</script>
</body>
</html>