package com.yc.web.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.JsonModel;
import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.biz.SaleOrderBiz;

@Controller
//@Scope(value="prototype")
public class SaleOrderController {
	
	@Resource(name="saleOrderBizImpl")
	private SaleOrderBiz  saleOrderBiz ;
	
	@ResponseBody
	@RequestMapping("saleOrder_save.action")
	public JsonModel  findAll(SaleOrder saleOrder ,HttpSession  session){
		 JsonModel  jm = new JsonModel() ;
		 this.saleOrderBiz.add(saleOrder);
		 long orderid = saleOrder.getOdrId();
		 jm.setCode(1);
		 jm.setObj(orderid);
		 Gson  gson  =  new Gson() ;
		  String jsonString  = gson.toJson(jm);
		  session.setAttribute("jsonModel", jsonString);
		return jm;
		
	}
	@ResponseBody
	@RequestMapping("saleOrder_findOrderWithDetail.action")
	public JsonModel saleProduct_findAll(long odrId ,HttpSession  session){
		 JsonModel  jm = new JsonModel() ;
		 
		 SaleOrder saleOrder = this.saleOrderBiz.getWithLines(odrId);
		 
		 jm.setCode(1);
		 jm.setObj(saleOrder);
		 
		 Gson  gson  =  new Gson() ;
		  String jsonString  = gson.toJson(jm);
		   
		  session.setAttribute("jsonModel", jsonString);
		return jm;
	}
	@ResponseBody
	@RequestMapping("saleOrder_saveOrderLine.action")
	public JsonModel saveOrderLine(   SaleOrderLine saleOrderLine,HttpServletRequest request ){
		this.saleOrderBiz.addDetail(saleOrderLine);
		
		JsonModel jsonModel = new JsonModel();
		jsonModel.setCode(1);
		
		Gson gson=new Gson();
		String result=gson.toJson(jsonModel);
		
		request.setAttribute("jsonModel", result);
		return  jsonModel;
	}
	
	@ResponseBody
	@RequestMapping("selectOrder_delOrderLine.action")
	public JsonModel delOrderLine(     SaleOrderLine saleOrderLine, HttpServletRequest request ){
		this.saleOrderBiz.delOrderLine(saleOrderLine);
		
		JsonModel jsonModel = new JsonModel();
		jsonModel.setCode(1);
		
		Gson gson=new Gson();
		String result=gson.toJson(jsonModel);
		
		request.setAttribute("jsonModel", result);
		return jsonModel;
	}
}
