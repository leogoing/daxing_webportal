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
		BaseLog.logger.info("拦截器destyoy....");
	}

	public void init() {
		// TODO Auto-generated method stub
		BaseLog.logger.info("拦截器init....");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext=invocation.getInvocationContext();
		HttpServletRequest request=(HttpServletRequest)actionContext.get(StrutsStatics.HTTP_REQUEST);
		BaseLog.logger.info("进入ecoding...");
		String url=request.getRequestURI();
		BaseLog.logger.info("请求地址："+url);
		String nameSpace=null;
		try {
			nameSpace=url.substring(url.indexOf("/",1), url.lastIndexOf("/"));
		} catch (Exception e) {
			Util.log2Error("切割请求地址字符串异常[正常]：", e);
		}
		if(nameSpace!=null && "/ajax_manager".equals(nameSpace)){
			BaseLog.logger.info("检查session...");
			if(request.getSession().getAttribute("username")==null){
				BaseLog.logger.info("未找到用户登录记录！");
				HttpServletResponse response = ServletActionContext.getResponse();
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                JSONObject result = new JSONObject();
                result.put("status", -1);
                result.put("message", "请先登录！");
                out.print(result);
                out.flush();
				return null;
			}
		}
		if(request.getMethod().compareToIgnoreCase("post")>=0){
			request.setCharacterEncoding("gbk");
			BaseLog.logger.info("进入拦截器post分支...");
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
