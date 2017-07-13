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
	<title>用户管理</title>

	<link href="<%=basePath%>jsp/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=basePath%>jsp/js/public.js"></script>
	<script type="text/javascript">
		var totalPageNums = '${userVo.totalPage}';
		
		function goFirstPage(pageNum){
			var url = "/easyerp/userAction!getUserAll.do";
			window.location.href= url;
		}
		
		function goUpPage(pageNum){
			if((pageNum-1) < 1){
				alert("提示:已经是第一页");
				return false;			
			}
			var url = "/easyerp/userAction!getUserAll.do?page="+(pageNum-1);
			window.location.href= url;
		}
		
		function goDownPage(pageNum){
			if((pageNum+1) > totalPageNums){
				alert("提示:已经是最后一页");
				return false;
			}
			var url = "/easyerp/userAction!getUserAll.do?page="+(pageNum+1);
			window.location.href= url;
		}
		
		function goLastPage(pageNum){
			var url = "/easyerp/userAction!getUserAll.do?page="+totalPageNums;
			window.location.href= url;
		}
		
	</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@include file="../common/nav.jsp"%>
				<%@include file="../common/message.jsp"%>

				<div class="page-header">
					<h2>用户管理</h2>
				</div>
				
				<div class="col-md-8 column">

				<c:url var="get" value="/userAction!getUserAll.do" />
				<form action="${get }" method="post">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>用户名</th>
							<th>等级</th>
							<th>等级名</th>
							<th>操作</th>
							<th>说明</th>
						</tr>
					</thead>
					<tbody>
						<s:if test="null != userList && !userList.isEmpty() ">
							<s:iterator value="userList" id="item">
								<tr>
									<td ><s:property value="#item.username"/></td>
									<td ><s:property value="#item.grade"/></td>
									<td ><s:property value="#item.gradeName"/></td>
									<td >
									   <a href="#"
									   onclick="openWin('/easyerp/userAction!updateUI.do?username=<s:property value="#item.username"/>','addperson',600,200);">修改</a>
									   <a href="/easyerp/userAction!del.do?username=<s:property value="#item.username"/>">删除</a><br>
									   <!--  <a href="#" onclick="del('userAction!del.do?username=<s:property value="#item.username"/>');">删除</a><br>  -->
									</td>
									<td>
										<c:choose>
										    <c:when test="${item.grade == 1}">
										    	本用户只有浏览功能
											</c:when>
										    <c:when test="${item.grade == 2}">
										    	本用户可以编辑数据，不可删除数据
											</c:when>
										    <c:when test="${item.grade == 3}">
										    	本用户可以编辑数据及删除数据
											</c:when>
    										<c:otherwise>
    											无
    										</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</s:iterator>
						</s:if>
						
						<!-- 在列表数据为空的时候，要显示的提示信息 -->
						<s:else>
							<tr>
								<td>没有找到相应的记录</td>
							</tr>
						</s:else>
					</tbody>
				</table>
				</form>
				<ul class="pagination pagination-sm">
					<li>
						<a href="javascript:none;" onclick="goFirstPage(${userVo.page});">首页</a>
					</li>
					<li>
						<a href="javascript:none;" onclick="goUpPage(${userVo.page});">上一页</a>
					</li>
					<li>
						<a href="javascript:none;" onclick="goDownPage(${userVo.page});">下一页</a>
					</li>
					<li>
						<a href="javascript:none;" onclick="goLastPage('最后一页');">最后一页</a>
					</li>
				</ul>
				<!-- 
				<font color="blue"> 
				         当前页:第<s:property value="userVo.page"/>页 | 总记录数:<s:property value="userVo.totalRecord"/>条 | 
					每页显示:<s:property value="userVo.rows"/>条 | 总页数:<s:property value="userVo.totalPage"/>页
				</font>
				 -->
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
