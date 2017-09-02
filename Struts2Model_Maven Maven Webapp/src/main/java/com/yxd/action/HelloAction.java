package com.yxd.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author yxd
 *
 */
public class HelloAction extends ActionSupport {
	
	public String index() throws Exception {
		//这种方式只能用struts2的标签才能在jsp页面中进行访问
		ActionContext.getContext().getSession().put("index", "访问index方法");
		return SUCCESS;
	}
	
	public String error() throws Exception {
		ActionContext.getContext().getSession().put("error", "访问error方法");
		return ERROR;
	}
}
