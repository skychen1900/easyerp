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
	<title>订单管理</title>

	<link href="<%=basePath%>jsp/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=basePath%>jsp/js/public.js"></script>
	<script type="text/javascript">
		var totalPageNums = '${order.totalPage}';
		
		function goFirstPage(pageNum){
			var url = "/easyerp/orderAction!getCustomerAll.do";
			window.location.href= url;
		}
		
		function goUpPage(pageNum){
			if((pageNum-1) < 1){
				alert("提示:已经是第一页");
				return false;			
			}
			var url = "/easyerp/orderAction!getCustomerAll.do?page="+(pageNum-1);
			window.location.href= url;
		}
		
		function goDownPage(pageNum){
			if((pageNum+1) > totalPageNums){
				alert("提示:已经是最后一页");
				return false;
			}
			var url = "/easyerp/orderAction!getCustomerAll.do?page="+(pageNum+1);
			window.location.href= url;
		}
		
		function goLastPage(pageNum){
			var url = "/easyerp/orderAction!getCustomerAll.do?page="+totalPageNums;
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
					<h2>订单管理</h2>
				</div>
				
				
				<c:url var="getOrder" value="/orderAction!getOrderAll.do" />
				<form action="${getorder }" method="post">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>客户编号</th>
							<th>客户名称</th>
							<th>联系电话</th>
							<th>联系地址</th>
							<th>联系人</th>
							<th>其他信息</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:if test="null != orderList && !orderList.isEmpty() ">
							<s:iterator value="orderList" id="item">
								<tr>
									<td ><s:property value="#item.orderNO"/></td>
									<td ><s:property value="#item.orderTime"/></td>
									<td ><s:property value="#item.otherInfo"/></td>
									<td ><s:property value="#item.quantity"/></td>
									<td ><s:property value="#item.customerNO"/></td>
									<td ><s:property value="#item.productNO"/></td>
									<td >
									   <c:url var="updateui" value="/orderManageAction!updateUI.do?orderNO=${item.orderNO }" />
									   <a href="#" onclick="openWin('${updateui}','addperson',600,200);">修改</a>
									   
									   <c:url var="delui" value="/orderManageAction!del.do?orderNO=${item.orderNO }" />
									   <a href="${delui}">删除</a><br>
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
						<a href="javascript:none;" onclick="goFirstPage(${order.page});">首页</a>
					</li>
					<li>
						<a href="javascript:none;" onclick="goUpPage(${order.page});">上一页</a>
					</li>
					<li>
						<a href="javascript:none;" onclick="goDownPage(${order.page});">下一页</a>
					</li>
					<li>
						<a href="javascript:none;" onclick="goLastPage('最后一页');">最后一页</a>
					</li>
				</ul>
				<!-- 
				<font color="blue"> 
				         当前页:第<s:property value="order.page"/>页 | 总记录数:<s:property value="order.totalRecord"/>条 |
					每页显示:<s:property value="order.rows"/>条 | 总页数:<s:property value="order.totalPage"/>页
				</font>
				 -->
			</div>
		</div>
	</div>

	<s:debug/>
	
	<script src="<%=basePath%>jsp/js/jquery.min.js"></script>
	<script src="<%=basePath%>jsp/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$('#order').addClass('active');
	</script>
</body>

</html>
