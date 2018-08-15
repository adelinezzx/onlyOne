package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.biz.SaleOrderBiz;
import com.yc.dao.SaleOrderDao;

@Service
@Transactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackForClassName = {
		"java.lang.RuntimeException" }, propagation = Propagation.SUPPORTS)
public class SaleOrderBizImpl implements SaleOrderBiz {

	private SaleOrderDao saleOrderDao;

	@Override
	@Transactional(readOnly = true)
	public SaleOrder getWithLines(Long id) {
		return this.saleOrderDao.getWithLines(id);
	}

	@Override
	public void add(SaleOrder s) {
		this.saleOrderDao.add(s);

	}

	/**
	 * 添加订单详情： 通过传递的对象的id得到该要添加的订单的详情，如果详情表中不为空，则取出详情，遍历
	 * 如果当前对象的产品名和详情列表中的产品名相同，则将详情表中的该商品的数量叠加，并将详情表中的id传给该订单 即：订单表中如果有数据，则更新
	 * 没有则添加新的订单到详情表
	 */
	@Override
	public void addDetail(SaleOrderLine o) {
		boolean flag = false;
		// 1. 根据 订单编号查订单，以获得这个订单的订单详情.
		SaleOrder so = getWithLines(o.getSaleOrder().getOdrId());
		// 有详情，则看详情中的产品是否是当前这个 要下订的产品，如果是，则加数量。
		if (so != null && so.getSaleOrderLines() != null && so.getSaleOrderLines().size() > 0) {
			List<SaleOrderLine> list = so.getSaleOrderLines();
			for (SaleOrderLine sol : list) {
				if (sol.getOdlProductName().equals(o.getOdlProductName())) {
					// 如果产品已经存在，则取出订单详情编号，及更改数量
					o.setOdlId(sol.getOdlId());
					o.setOdlProductCount(o.getOdlProductCount() + sol.getOdlProductCount());
					flag = true;
					break;
				}
			}
		}
		if (flag) {
			this.saleOrderDao.updateDatail(o);
		} else {
			this.saleOrderDao.addDetail(o);
		}
	}

	@Resource(name = "saleOrderDaoMybatisImpl")
	public void setSaleOrderDao(SaleOrderDao saleOrderDao) {
		this.saleOrderDao = saleOrderDao;
	}

	@Override
	public void delOrderLine(SaleOrderLine s) {
		this.saleOrderDao.delOrderLine(s);

	}

}
