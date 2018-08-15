package com.yc.web.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.CusCustomer;
import com.yc.bean.JsonModel;
import com.yc.biz.CusCustomerBiz;

@Controller
//@Scope(value="prototype")  //表示每次接收一个请求创建一个Action对象.
public class CusCustomerController {
	
	@Resource(name="cusCustomerBizImpl")
	private  CusCustomerBiz cusCustomsBiz ;
	
	@RequestMapping("/cuscustomer_findAll.action")
	/*@ResponseBody*/
	public String  findAll(HttpSession session){
		  JsonModel  jm = new JsonModel() ;
		  List<CusCustomer>  list = cusCustomsBiz.findAll();
		  jm.setCode(1);
		  jm.setObj(list);
		  
		  Gson  gson  =  new Gson() ;
		  String jsonString  = gson.toJson(list);
		   
		  session.setAttribute("jsonModel", jsonString);
		return "result"; 
	}

}
