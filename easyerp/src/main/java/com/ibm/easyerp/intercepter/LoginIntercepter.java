package com.ibm.easyerp.intercepter;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import com.ibm.easyerp.model.User;

public class LoginIntercepter extends AbstractInterceptor {
	
	private static final long serialVersionUID = 6203506362291764836L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//ActionContext ctx=invocation.getInvocationContext();//获得ActionContext对象
		//Map<String, Object> session=ctx.getSession();		//获得session对象
		//User user = (User)session.get("user");//获得用户登录信息
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String sessID = request.getSession().getId();
		User user =(User)request.getSession().getAttribute("user");
		
		ActionSupport actionSupport = (ActionSupport)invocation.getAction();
		
		//获取当前请求地址
	    String queryString = request.getQueryString();
	    if (queryString == null) { // 预防空指针
			queryString = "";
	    }else {
	    	queryString =  "?" + queryString;
	    }
	    
	    //保存当前请求到session
	    String curPath = request.getRequestURI() + queryString;
	    System.out.println("session id:" + sessID );
	    System.out.println("curPath：" + curPath);
		
		/*-------------*/
		/* 用户登录验证 */
		/*-------------*/
		if(user == null) {	//如果为空，则表示已经登录	
			actionSupport.addActionError(actionSupport.getText("9002"));
		    request.getSession().setAttribute("goingURL", curPath);
			
			return "login";//跳转到登录页面
		}
		
		/*-------------*/
		/* 用户权限验证 */
		/*-------------*/
	    String actionName = invocation.getProxy().getActionName();  //获取请求的action的name
	    System.out.println("actionName:" + actionName);
	    String methodName = invocation.getProxy().getMethod();
	    System.out.println("methodName:" + methodName);
	    
	    boolean redirectFlg = false;
	    
	    switch(user.getGrade()){
	    case 1:  //只读用户
	    	if(methodName.indexOf("del") > -1  || methodName.indexOf("update") > -1 ||
	    		methodName.indexOf("add") > -1) {
	    		redirectFlg = true;
	    	}
	    	break;
	    case 2:  //普通用户
	    	if(methodName.indexOf("del") > -1) {
	    		redirectFlg = true;
		    }
	    	break;
	    case 3:  //超级用户
	    	break;
	    case 4:  //管理员
	    	break;
	    }
	    
	    if(redirectFlg){
    		actionSupport.addActionError(actionSupport.getText("9003"));
	    	return "error";
	    }
	    
	    request.getSession().setAttribute("preURL", curPath);
	    return invocation.invoke();//继续执行后面的操作
	}

}