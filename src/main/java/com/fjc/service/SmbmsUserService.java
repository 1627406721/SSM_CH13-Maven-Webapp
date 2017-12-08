package com.fjc.service;

import com.fjc.entity.SmbmsUser;

public interface SmbmsUserService {
	SmbmsUser login(SmbmsUser user);
	int addSmbmsUser(SmbmsUser user);
	int delSmbmsUser(String userCode);
	int updateSmbmsUser(SmbmsUser user);
}
