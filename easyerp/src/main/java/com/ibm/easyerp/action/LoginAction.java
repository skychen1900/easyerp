package com.ibm.easyerp.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import com.ibm.easyerp.base.BaseAction;
import com.ibm.easyerp.model.User;
import com.ibm.easyerp.service.UserServiceI;

/**
 * 用户登录
 */
@Scope("singleton")
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = -8478042192670799081L;

	private UserServiceI userService;
	private User user;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String welcome(){
		return "welcome";
	}
	
	public String loginUI(){
		return "loginUI";
	}
	
	public String login(){
		user = new User();
		
		//获取表单数据
		getParams(user);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String checkCode = (String) request.getParameter("checkcode");
		
		//验证码
        HttpSession session = ServletActionContext.getRequest().getSession();
        String checkCode2 = (String)session.getAttribute("checkCode");
        if(!checkCode.equals(checkCode2))
        {
            addActionError(getText("9004"));
            return INPUT;
        }
		
		//用户名，密码验证
		if(!userService.login(user)) {
//			addActionError(getText("9001"));
//			return INPUT;
		}

		user = userService.find(user.getUsername());
		
		request.getSession().setAttribute("user",user);
		user = userService.find(user.getUsername());
		addActionError(getText("1001"));
		
		//重定向URL
		String goingURL = (String) request.getSession().getAttribute("goingURL");
		if(goingURL != null){
		    HttpServletResponse response = ServletActionContext.getResponse();
		    try {
				response.sendRedirect(goingURL);
				System.out.println("goingURL:" + goingURL);
				request.removeAttribute("goingURL");
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			return null;
		}else{
			return SUCCESS;
		}
		
	}
	
	public String homePage() {
		return SUCCESS;
	}
	
	public String logoff() {
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().removeAttribute("user");
		
		user = null;
		
		return "logoff";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserServiceI getUserService() {
		return userService;
	}

	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
}