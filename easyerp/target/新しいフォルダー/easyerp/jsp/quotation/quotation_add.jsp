<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="<%=basePath%>script/public.js"></script>
<title>新增报价信息</title>
</head>
<body>
<center>
<form action="quotationmanage_add.do" method="post">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">新增报价信息</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->
<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td class="tdEditLabel" >报价编号</td>			
		<td class="tdEditContent"><input type="text" name="quotationNO">
		</td>
		<td class="tdEditLabel" >客户名称</td>			
		<td class="tdEditContent">
		<select name="customer.customerNO">
			<s:iterator value="#request.customers" id="customer">
				<option value="${customer.customerNO}">${customer.customerName}</option>
			</s:iterator>
		</select>
		</td>
	</tr>
	<tr>
		<td class="tdEditLabel" >产品名称</td>			
		<td class="tdEditContent">
		<select name="product.productNO">
			<s:iterator value="#request.products" id="product">
				<option value="${product.productNO}">${product.productName}</option>
			</s:iterator>
		</select>
		</td>
		<td class="tdEditLabel" >报价人</td>			
		<td class="tdEditContent"><input type="text" name="quotationMan"></td>
	</tr>
	<tr>
		<td class="tdEditLabel" >其他信息</td>			
		<td class="tdEditContent" colspan="3"><input type="text" name="otherInfo"></td>
	</tr>
</table>
			<!-- 主输入域结束 -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="新增报价信息"> 
			<input type="button" class="MyButton"
				value="关闭窗口" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>