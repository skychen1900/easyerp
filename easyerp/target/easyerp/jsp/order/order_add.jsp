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
	<title>新增客户信息</title>
	<link href="<%=basePath%>jsp/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="../common/nav.jsp"%>
				<%@include file="../common/message.jsp"%>
				
				<div class="page-header">
					<h2>新增客户信息</h2>
				</div>
				<div class="row clearfix">
					<div class="col-md-6 column">
						<c:url var="add" value="/customerManageAction!add.do" />
						<form class="form-horizontal" role="form" action="${add}" method="post">
						
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">客户编号</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3" name="customerNO"  required/>
								</div>
							</div>
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">客户名称</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3" name="customerName"/>
								</div>
							</div>
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">联系电话</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3" name="phone"/>
								</div>
							</div>
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">联系地址</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3" name="address"/>
								</div>
							</div>
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">联系人</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3" name="relationman"/>
								</div>
							</div>
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">其他</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputEmail3" name="otherInfo"/>
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
		$('#customer').addClass('active');
	</script>
</body>
</html>