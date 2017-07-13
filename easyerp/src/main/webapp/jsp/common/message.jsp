 <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"  isELIgnored="false" %>
<%@include file="../common/taglib.jsp"%>
 
 <div>
         <!-- fieldError  -->
    <s:if test="hasFieldErrors()">
        <s:iterator value="fieldErrors">
            <s:iterator value="value" status="statu">
				<div class="alert alert-success alert-dismissable">
					 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
					<h5>
		                <!-- fieldのメッセージが複数なので、繰り返り  -->
		                <s:set name="index" value="#statu.index"/>
		                <s:set name="msg" value="#msg==null?'':#msg+
		                value.get(#request.index).toString()+'\\\n'"/>
					</h5>
				</div>
             </s:iterator>
        </s:iterator>
    </s:if>

         <!--  actionError   -->
    <s:if test="hasActionErrors()">
        <s:iterator value="actionErrors">
			<div class="alert alert-danger alert-dismissable">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h5><s:property escape="false"/></h5>
			</div>
        </s:iterator>
    </s:if>

         <!-- actionMessage  -->
    <s:if test="hasActionMessages()">
        <s:iterator value="actionMessages">
			<div class="alert alert-info alert-dismissable">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h5><s:property escape="false"/></h5>
			</div>
        </s:iterator>
     </s:if>

         <!-- fieldErrorメッセージを出力 -->
    <s:if test="hasFieldErrors()">
      <s:if test="#msg.length()>0">
			<div class="alert alert-danger alert-dismissable">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h5><s:property escape="false"/></h5>
			</div>
       </s:if>
    </s:if>
</div>