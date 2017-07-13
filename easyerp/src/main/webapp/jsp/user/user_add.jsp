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
	<title>新增用户信息</title>
	<link href="<%=basePath%>jsp/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="../common/nav.jsp"%>
				<%@include file="../common/message.jsp"%>
				
				<div class="page-header">
					<h2>新增用户信息</h2>
				</div>
				<div class="row clearfix">
					<div class="col-md-4 column">
						<c:url var="add" value="/userAction!add.do" />
						<form class="form-horizontal" role="form" action="${add }" method="post">
						
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3" name="username"  required/>
								</div>
							</div>
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputEmail3" name="password"  required/>
								</div>
							</div>
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">等级</label>
								<div class="col-sm-10">
								    <select class="form-control"  name="grade">
								      <option value="1">1:只读用户</option>
								      <option value="2">2:普通用户</option>
								      <option value="3">3:超级用户</option>
								      <option value="4">4:管理员</option>
								    </select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									 <button type="submit" class="btn btn-default">保存</button>
								</div>
							</div>
							<s:token/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script src="<%=basePath%>jsp/js/jquery.min.js"></script>
	<script src="<%=basePath%>jsp/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$('#user').addClass('active');
	</script>
</body>
</html>