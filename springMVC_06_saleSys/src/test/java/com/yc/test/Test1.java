package com.yc.test;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.CusCustomer;
import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.bean.SaleProduct;
import com.yc.biz.CusCustomerBiz;
import com.yc.biz.SaleOrderBiz;
import com.yc.biz.SaleProductBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml","classpath:beans-dao.xml"})
public class Test1 {
	
	@Resource(name ="cusCustomerBizImpl")
	private CusCustomerBiz  cusCustomerBiz ;
	
	@Resource(name ="saleProductBizImpl")
	private SaleProductBiz  saleProductBiz ;
	
	@Resource(name ="saleOrderBizImpl")
	private SaleOrderBiz  saleOrderBiz ;
	
	@Test
	public  void test1(){
		List<CusCustomer> list = this.cusCustomerBiz.findAll();
		System.out.println(list);
	}
	
	@Test
	public  void test2(){
		List<SaleProduct> list = this.saleProductBiz.findAll();
		System.out.println(list);
	}
	
	@Test//添加订单项
	public  void test3(){
		 SaleOrder  s  =new SaleOrder();
		 s.setOdrCustomerId(1L);
		 s.setOdrCustomerName("adeline科技有限公司");
		 s.setOdrDeliverAddr("上海浦东区");
		 s.setOdrDeliverDate(new Date(2017, 12, 12));
		 s.setOdrOrderDate(new Date(2017, 12, 12));
		 s.setOdrStatus("1");
		 this.saleOrderBiz.add(s);
		 System.out.println(s);
	}
	
	@Test//添加订单项 ：向新增的1 号订单项添加一个产品
	public  void test4(){
		 SaleOrder  s = new SaleOrder() ;
		 s.setOdrId(1L);
		 SaleOrderLine  sol = new SaleOrderLine();
		 sol.setSaleOrder(s);
		 sol.setOdlProductName("智能鼠标");
		 sol.setOdlProductPrice(5000.0);
		 sol.setOdlProductCount(200);
		 this.saleOrderBiz.addDetail(sol);
		 System.out.println(sol);
	}

	
	@Test //删除订单项
	public  void test5(){
		 SaleOrderLine  sol = new SaleOrderLine();
		 sol.setOdlId(9L);
		 this.saleOrderBiz.delOrderLine(sol);
	}
	
	@Test //查询订单项
	public  void test7(){
		 SaleOrder  s =  this.saleOrderBiz.getWithLines(1L);
		 System.out.println(s);
	}
	
	
	
}
