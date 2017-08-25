package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Bussess;

public interface BussessDao {
	/**
	 * 添加业务
	 * @param bussess
	 * @return
	 */
	public int insertBussess(Bussess bussess);
	/**
	 * 查询所有的业务
	 * @return
	 */
	public List<Bussess> selectAllBussesses();
	/**
	 * 暂停业务
	 * @param bussess
	 * @return
	 */
	public int changeBussessStatus(Bussess bussess);
	/**
	 * 修改业务
	 * @param bussess
	 * @return
	 */
	public int updateBussess(Bussess bussess);
	/**
	 * 根据id查询数据
	 * @param bussess
	 * @return
	 */
	public Bussess selectedBussessById(Bussess bussess);
	/**
	 * 根据条件查询业务
	 * @param bussess
	 * @return
	 */
	public Bussess selectBussessByCondition(Bussess bussess);
	

}
