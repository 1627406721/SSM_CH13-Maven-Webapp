package com.fjc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fjc.entity.SmbmsProvider;
import com.fjc.entity.SmbmsUser;

public interface SmbmsProviderDao {

	int addSmbmsProvider(SmbmsProvider provider);
	SmbmsProvider getSmbmsProviderById(Long id);
	List<SmbmsProvider> getSmbmsProvider(@Param("proCode") String proCode,@Param("proName") String proName,
			@Param("begin") int begin,@Param("size") int size);
	int getProviderRow(@Param("proCode") String proCode,@Param("proName") String proName);
	int delSmbmsProvider(Long id);
}
