package com.ibm.easyerp.action;

import org.apache.struts2.ServletActionContext;

import org.springframework.context.annotation.Scope;

import com.ibm.easyerp.base.BaseAction;
import com.ibm.easyerp.model.User;
import com.ibm.easyerp.service.UserServiceI;
import com.ibm.easyerp.util.MessageDigestUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
/**
 * 用户管理
 */
@Scope("singleton")
public class UserAction extends BaseAction implements ModelDriven<User>{

	private static final long serialVersionUID = -8478042192670799081L;

	private UserServiceI userService;
	private User userVo; 

	private List<User> userList;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String getUserAll(){
		
		try {
			//获取当前用户
			HttpServletRequest request = ServletActionContext.getRequest();
			userVo =(User)request.getSession().getAttribute("user");

			userVo = userService.find(userVo.getUsername());

			if(page != null){
				String page = request.getParameter("page");
				System.out.println("page:" + page);
				userVo.setPage(page);
			}
			
			userVo.setSort("username");
			userVo.setOrder("asc");
			userVo.setTotalRecord(userService.getUserSize(userVo));  //dbからユーザ数を取得する
			userList = userService.getUserList(userVo);  //dbからユーザを取得する

			int totalPageNum = userVo.getTotalRecord()/userVo.getRows();
			if(userVo.getTotalRecord() % userVo.getRows() > 0){
				totalPageNum++;
			}
			userVo.setTotalPage(totalPageNum);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "userList";
	}
	
	public String helpUI(){
		return "helpUI";
	}
	
	public String modPwdUI(){
		return "updatepwd";
	}
	
	public String modPwd() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String oldPassword = (String) request.getParameter("oldpassword");
		String newPassword = (String) request.getParameter("newpassword");
		User user =(User)request.getSession().getAttribute("user");
		
		//if(!oldPassword.equals(user.getPassword())) {
		if(MessageDigestUtil.digestByMD5(oldPassword).equals(user.getPassword())){
			addActionError(getText("2002"));
			return "updatepwd";
		}
		
		//todo 新密码规范check
		if(newPassword == null || newPassword.length() < 1){
			addActionError(getText("2003"));
			return "updatepwd";
		}
		
		user.setPassword(newPassword);
		userService.update(user);
		addActionMessage(getText("2001"));
		
		return SUCCESS;
	}
	
	public String updateUI(){
		
		userVo = new User();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getParameter("username");
		
		userVo = userService.find(username);
		ActionContext context = ActionContext.getContext();
		context.put("user",userVo);
		
		return "updateUI";
	}
	
	public String update(){
		
		try {
			userVo = new User();
			
			getParams(userVo);
			
			switch(userVo.getGrade()){
			case 1:
				userVo.setGradeName("只读用户");
				break;
			case 2:
				userVo.setGradeName("普通用户");
				break;
			case 3:
				userVo.setGradeName("超级用户");
				break;
			case 4:
				userVo.setGradeName("管理员");
				break;
			}
			
			userService.update(userVo);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "pub_update_success";
	}
	
	public String addUI(){
		return "addUI";
	}
	
	public String add(){
		try {
			userVo = new User();
			
			HttpServletRequest request = ServletActionContext.getRequest();
			userVo.setUsername((String) request.getParameter("username"));
			userVo.setPassword((String) request.getParameter("password"));
			
			String grade = (String) request.getParameter("grade");
			userVo.setGrade(Integer.parseInt(grade));
			switch(Integer.parseInt(grade)){
			case 1:
				userVo.setGradeName("只读用户");
				break;
			case 2:
				userVo.setGradeName("普通用户");
				break;
			case 3:
				userVo.setGradeName("超级用户");
				break;
			case 4:
				userVo.setGradeName("管理员");
				break;
			}
			
			userService.insert(userVo);
			
			//获取当前用户
			userVo =(User)request.getSession().getAttribute("user");
			userVo = userService.find(userVo.getUsername());
			
			userVo.setSort("username");
			userVo.setOrder("asc");
			userVo.setTotalRecord(userService.getUserSize(userVo));  //dbからユーザ数を取得する
			userList = userService.getUserList(userVo);  //dbからユーザを取得する
		} catch (Exception e) {
			System.out.println(e);
		}

		addActionMessage(getText("1006"));
		
		return "userList";
	}
	
	public String del(){
		
		try {
			userVo = new User();
			getParams(userVo);
			userService.delete(userVo);
			
			//获取当前用户
			userVo =(User)request.getSession().getAttribute("user");
			userVo = userService.find(userVo.getUsername());
			
			userVo.setSort("username");
			userVo.setOrder("asc");
			userVo.setTotalRecord(userService.getUserSize(userVo));  //dbからユーザ数を取得する
			userList = userService.getUserList(userVo);  //dbからユーザを取得する
		} catch (Exception e) {
			System.out.println(e);
		}
	
		addActionMessage(getText("1003"));
		
		return "userList";
	}
	
	public User getUserVo() {
		return userVo;
	}

	public void setUserVo(User userVo) {
		this.userVo = userVo;
	}

	public UserServiceI getUserService() {
		return userService;
	}

	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getModel() {
		return userVo;
	}
	
}