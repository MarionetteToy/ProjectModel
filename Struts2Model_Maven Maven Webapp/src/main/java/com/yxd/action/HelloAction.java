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
		//���ַ�ʽֻ����struts2�ı�ǩ������jspҳ���н��з���
		ActionContext.getContext().getSession().put("index", "����index����");
		return SUCCESS;
	}
	
	public String error() throws Exception {
		ActionContext.getContext().getSession().put("error", "����error����");
		return ERROR;
	}
}
