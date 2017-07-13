<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="./common/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>订单管理系统</title>

	<link href="<%=basePath%>jsp/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="common/nav.jsp"%>
				<div class="jumbotron">
					<h1>  Welcome!</h1>
					<c:if test="${empty user}">
						<p>  欢迎进入订单管理系统，使用前请先登录！</p>
						<p>
							<c:url value="/loginAction!loginUI.do" var="login"></c:url> 
							<a class="btn btn-primary btn-large" href="${login}">Login</a>
						</p>
					</c:if>
					<c:if test="${!empty user}">
						<p>  欢迎进入订单管理系统，您已登录！</p>
					</c:if>
					
				</div>
				
			</div>
			
		</div>
	</div>
	
	<script src="<%=basePath%>jsp/js/jquery.min.js"></script>
	<script src="<%=basePath%>jsp/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$('#home').addClass('active');
	</script>
</body>
</html>