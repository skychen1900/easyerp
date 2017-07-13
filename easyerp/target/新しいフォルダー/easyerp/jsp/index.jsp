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
				
				<div class="jumbotron ">
					<h1>
						简易订单管理系统
					</h1>
					<p>
						本系统可进行客户管理、订单管理及用户管理。
					</p>
					
					<dl>
					<dt>
						<c:if test="${user.username != null}">
							欢迎 ${user.username} 登陆本系统！
						</c:if>
						<c:if test="${user.username == null}">
							欢迎使用本系统，使用前请先登录！
						</c:if>
					</dt>
					<dd>
						上次登陆时间： xx:xx:xx
					</dd>
					</dl>
				</div>
				
				<%@include file="common/message.jsp"%>

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