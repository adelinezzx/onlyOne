package com.yc.web.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yc.bean.JsonModel;
import com.yc.bean.SaleProduct;
import com.yc.biz.SaleProductBiz;

@Controller
public class SaleProductContoller {

	@Resource(name = "saleProductBizImpl")
	private SaleProductBiz spb;

	@RequestMapping("saleProduct_findAll.action")
	@ResponseBody
	public JsonModel getAllProduct(HttpSession session) {
		JsonModel jm = new JsonModel();
		List<SaleProduct> list = this.spb.findAll();
		jm.setCode(1);
		jm.setObj(list);

		Gson gson = new Gson();
		String jsonString = gson.toJson(jm);

		session.setAttribute("jsonModel", jsonString);
		return jm;
	}
}
