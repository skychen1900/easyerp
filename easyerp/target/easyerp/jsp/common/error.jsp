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
	<title>ERROR</title>

	<link href="<%=basePath%>jsp/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=basePath%>jsp/js/public.js"></script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="../common/nav.jsp"%>
				
				<div class="page-header">
					<h2>错误</h2>
				</div>
				
				<%@include file="../common/message.jsp"%>
				
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
