package com.yihuan.util;

import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;



public class AllInterceptors implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		BaseLog.logger.info("������destyoy....");
	}

	public void init() {
		// TODO Auto-generated method stub
		BaseLog.logger.info("������init....");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext=invocation.getInvocationContext();
		HttpServletRequest request=(HttpServletRequest)actionContext.get(StrutsStatics.HTTP_REQUEST);
		BaseLog.logger.info("����ecoding...");
		String url=request.getRequestURI();
		BaseLog.logger.info("�����ַ��"+url);
		String nameSpace=null;
		try {
			nameSpace=url.substring(url.indexOf("/",1), url.lastIndexOf("/"));
		} catch (Exception e) {
			Util.log2Error("�и������ַ�ַ����쳣[����]��", e);
		}
		if(nameSpace!=null && "/ajax_manager".equals(nameSpace)){
			BaseLog.logger.info("���session...");
			if(request.getSession().getAttribute("username")==null){
				BaseLog.logger.info("δ�ҵ��û���¼��¼��");
				HttpServletResponse response = ServletActionContext.getResponse();
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                JSONObject result = new JSONObject();
                result.put("status", -1);
                result.put("message", "���ȵ�¼��");
                out.print(result);
                out.flush();
				return null;
			}
		}
		if(request.getMethod().compareToIgnoreCase("post")>=0){
			request.setCharacterEncoding("gbk");
			BaseLog.logger.info("����������post��֧...");
		}else{
			Iterator iter=request.getParameterMap().values().iterator();
			while(iter.hasNext()){
				String[] parames=(String[])iter.next();
				for(int i=0;i<parames.length;i++){
					parames[i]=new String(parames[i].getBytes("iso8859-1"),"gbk");
				}
			}
		}
		
        return invocation.invoke();  
    }  
	
	
  
}
