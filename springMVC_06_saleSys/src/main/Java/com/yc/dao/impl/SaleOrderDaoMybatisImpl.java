package com.yc.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.dao.SaleOrderDao;

@Repository
public class SaleOrderDaoMybatisImpl implements SaleOrderDao {

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlsession ;
	
	@Override
	public SaleOrder getWithLines(Long id) {
		return this.sqlsession.selectOne("com.yc.dao.SaleOrderDaoMapper.getWithLines", id);
	}

	@Override
	public void add(SaleOrder saleorder) {
		this.sqlsession.insert("com.yc.dao.SaleOrderDaoMapper.add",saleorder);
		
	}

	@Override
	public void addDetail(SaleOrderLine saleorderline) {
	this.sqlsession.insert("com.yc.dao.SaleOrderDaoMapper.addDetail", saleorderline);
		
	}

	@Override
	public void updateDatail(SaleOrderLine s) {
		this.sqlsession.insert("com.yc.dao.SaleOrderDaoMapper.updateDetail", s);
		
	}

	@Override
	public void delOrderLine(SaleOrderLine saleorderline) {
		this.sqlsession.insert("com.yc.dao.SaleOrderDaoMapper.delDetail", saleorderline);
		
	}

	public void setSqlsession(SqlSessionTemplate sqlsession) {
		this.sqlsession = sqlsession;
	}
	 
	
}
