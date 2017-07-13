<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/taglib.jsp"%>
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
	<title>密码修改</title>
	<link href="<%=basePath%>jsp/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="../common/nav.jsp"%>
				<%@include file="../common/message.jsp"%>
				
				<div class="page-header">
					<h2>密码修改</h2>
				</div>
				<div class="row clearfix">
					<div class="col-md-6 column">
						<form class="form-horizontal" role="form" action="userAction!modPwd.do" method="post">
						
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">旧密码</label>
								<div class="col-sm-10">
									<input type="password"  class="form-control" id="inputEmail3" 
									       placeholder="请输入旧密码" name="oldpassword"/>
								</div>
							</div>
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">新密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputEmail3"
									       placeholder="请输入新密码" name="newpassword"/>
								</div>
							</div>
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">新密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputEmail3"
									       placeholder="请再次输入新密码" name="newpassword2"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									 <button type="submit" class="btn btn-default">提交</button>
								</div>
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
		$('#username').addClass('active');
	</script>
</body>
</html>