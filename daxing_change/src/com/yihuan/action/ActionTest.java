package com.yihuan.action;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yihuan.dao.AdminDao;
import com.yihuan.dao.IndexDao;
import com.yihuan.dao.impl.TestDaoImpl;
import com.yihuan.service.AdminService;

@Controller
public class ActionTest extends ActionSupport{
	private String id;
	private String name;
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private Integer i;

	@Resource
	private TestDaoImpl testDaoImpl;
	
	@Resource
	private IndexDao indexDao;
	
	@Resource
	private AdminDao adminDao;
	
	@Resource
	private AdminService ad;

	public String execute(){
		System.out.println("test....");
		ad.checkLogin(1, "xxoo", "123");
		System.out.println("00000");
		return "success";
	}
	
	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ActionTest [id=" + id + ", name=" + name + "]";
	}
	
	public static void main(String[] args) throws URISyntaxException, IOException{
		String b=ActionTest.class.getResource("/").toURI().getPath();
		new File("/").getCanonicalPath();
		System.out.println(b);
	}
	 List<Integer> h(){
		List<Integer> l=new ArrayList<Integer>();
		l.add(222);
		return l;
	}
}
