<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>jsp/style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="<%=basePath%>jsp/script/public.js"></script>
<title>更新客户信息</title>
</head>
<body>
	<center>
		<c:url var="cupdate" value="/customerManageAction!update.do" />
		<form action="/easyerp/customerManageAction!update.do" method="post">
			<input type="hidden" name="customerNO" value="<s:property value="#customer.customerNO"/>">
			<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0"
				style="width: 580px;">
				<TBODY>
					<TR>
						<!-- 这里是添加、编辑界面的标题 -->
						<td align="center" class="tdEditTitle">更新客户信息</TD>
					</TR>
					<TR>
						<td>
							<!-- 主输入域开始 -->
							<table class="tableEdit" style="width: 580px;" cellspacing="0"
								border="0" cellpadding="0">
								<tr>
									<td class="tdEditLabel">客户名称</td>
									<td class="tdEditContent"><input type="text"
										name="customerName" value="<s:property value="#customer.customerName"/>"></td>
									<td class="tdEditLabel">联系电话</td>
 									<td class="tdEditContent"><input type="text" name="phone"
										value="<s:property value="#customer.phone"/>"></td> 
								</tr>
								<tr>
									<td class="tdEditLabel">联系地址</td>
									<td class="tdEditContent"><input type="text"
										name="address" value="<s:property value="#customer.address"/>"></td>
									<td class="tdEditLabel">联系人</td>
									<td class="tdEditContent"><input type="text"
										name="relationman" value="<s:property value="#customer.relationman"/>"></td>
								</tr>
								<tr>
									<td class="tdEditLabel">其他</td>
									<td class="tdEditContent" colspan="3"><input type="text"
										name="otherInfo" value="<s:property value="#customer.otherInfo"/>"></td>
								</tr>
							</table> <!-- 主输入域结束 -->
						</td>
					</TR>
				</TBODY>
			</TABLE>

			<TABLE>
				<TR align="center">
					<TD colspan="3" bgcolor="#EFF3F7">
						<input type="submit" name="saveButton" class="MyButton" value="更新"> 
						<input type="button" class="MyButton" value="关闭" onclick="window.close()">
					</TD>
				</TR>
			</TABLE>
			<s:debug></s:debug>
		</form>
	</center>
</body>
</html>