package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Bussess;

public interface BussessService {
	public boolean addBussess(Bussess bussess);
	
	public List<Bussess> getAllBussesses();
	
	public boolean changeBussessStatus(Bussess bussess);
	
	public Bussess getedBussessById(Bussess bussess2);
	
	public boolean modifyBussess(Bussess bussess);
	
	public List<Bussess> getBussessByCondition(Bussess bussess);

}
