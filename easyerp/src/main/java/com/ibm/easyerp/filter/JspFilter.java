package com.ibm.easyerp.filter;

import java.io.IOException;  

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

/** 
 * JSP过滤器,不能直接访问JSP 
 *  
 * 
 */  
public class JspFilter implements Filter {
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
  
    public void doFilter(ServletRequest request, ServletResponse response, 
    	                 FilterChain chain ) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;  
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;  

        String url = httpServletRequest.getRequestURI();  
        if (url != null && url.endsWith(".jsp")) {  
            // TODO 这里可以跳转到主页  
            String contextPath = httpServletRequest.getContextPath();  
            //httpServletResponse.sendRedirect(contextPath + "/jsp/login.jsp");
            httpServletResponse.sendRedirect(contextPath + "/loginAction/loginUI.html");
            return;
        }  
        chain.doFilter(httpServletRequest, httpServletResponse);  
  
    }

	public void destroy() {
		// TODO Auto-generated method stub
		
	}  

  
}  
