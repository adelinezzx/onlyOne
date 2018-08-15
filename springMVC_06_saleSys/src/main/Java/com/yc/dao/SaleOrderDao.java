package com.yc.dao;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;

//操作
public interface SaleOrderDao {

	/**
	 * 根据订单号查订单  包括 订单项
	 * @param id
	 * @return
	 */
	public  SaleOrder getWithLines(Long id);
	
	/**
	 * 添加订单
	 * @param saleorder
	 */
	public void add(SaleOrder  saleorder);
	
	/**
	 * 添加订单详情   
	 * @param saleorderline
	 */
	public  void addDetail(SaleOrderLine  saleorderline);
	
	/**
	 * 更新订单详情（主要是数量）
	 * @param s
	 */
	public  void updateDatail(SaleOrderLine  s );
	
	/**
	 * 根据订单号删除订单详情
	 * @param saleorderline
	 */
	public void delOrderLine(SaleOrderLine saleorderline);
}
