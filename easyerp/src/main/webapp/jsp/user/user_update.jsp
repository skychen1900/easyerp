<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/taglib.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>jsp/style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="<%=basePath%>jsp/js/public.js"></script>
<title>修改用户信息</title>
</head>
<body>
<center>
<form action="userAction!update.do" method="post">
<input type="hidden" name="username" value="<s:property value="#user.username"/>">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- 这里是添加、编辑界面的标题 -->
			<td align="center" class="tdEditTitle">修改用户信息</TD>
		</TR>
		<TR>
			<td>
			<!-- 主输入域开始 -->
				<table class="tableEdit" style="width:580px;" cellspacing="0" border="0" cellpadding="0">
					<tr>
						<td class="tdEditLabel" >密码</td>			
						<td class="tdEditContent">
							<input type="password" name="password" value="<s:property value="#user.password"/>">
						</td>
						
						<td class="tdEditLabel" >级别</td>			
						<td class="tdEditContent" colspan="3">
							<select name="grade" id="grade" class="selector">
								<option value="1">1:只读用户</option>
								<option value="2">2:普通用户</option>
								<option value="3">3:超级用户</option>
								<option value="4">4:管理员</option>
							</select>
						</td>
					</tr>
					<tr>
					
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
			class="MyButton" value="保存"> 
		<input type="button" class="MyButton"
			value="关闭" onclick="window.close()">
		</TD>
	</TR>
</TABLE>
</form>

</center>

<script src="<%=basePath%>jsp/js/jquery.min.js"></script>
<script type="text/javascript">
	$(".selector").find("option[value='<s:property value="#user.grade"/>']").attr("selected",true);
</script>

</body>
</html>