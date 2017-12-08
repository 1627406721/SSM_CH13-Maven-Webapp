package com.fjc.service.impl;

import java.util.List;

import com.fjc.dao.SmbmsProviderDao;
import com.fjc.entity.SmbmsProvider;
import com.fjc.service.SmbmsProviderService;

public class SmbmsProviderServiceImpl implements SmbmsProviderService {

	SmbmsProviderDao dao;
	public List<SmbmsProvider> getSmbmsProvider(String proCode, String proName,
			int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getSmbmsProvider(proCode, proName, (pageIndex-1)*pageSize, pageSize);
	}
	public int getProviderRow(String proCode, String proName) {
		// TODO Auto-generated method stub
		return dao.getProviderRow(proCode, proName);
	}
	public SmbmsProviderDao getDao() {
		return dao;
	}
	public void setDao(SmbmsProviderDao dao) {
		this.dao = dao;
	}
	public int addSmbmsProvider(SmbmsProvider provider) {
		// TODO Auto-generated method stub
		return dao.addSmbmsProvider(provider);
	}
	public int delSmbmsProvider(Long id) {
		// TODO Auto-generated method stub
		return dao.delSmbmsProvider(id);
	}
	

}
