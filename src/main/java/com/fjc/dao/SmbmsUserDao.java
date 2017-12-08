package com.fjc.dao;

import java.util.List;

import com.fjc.entity.SmbmsUser;


public interface SmbmsUserDao {
	SmbmsUser login(SmbmsUser user);
	int changePassword(String userCode,String userPassword,String newPwd);
	int addSmbmsUser(SmbmsUser user);
	int delSmbmsUser(String userCode);
	int updateSmbmsUser(SmbmsUser user);
	int count(SmbmsUser user);
	SmbmsUser getSmbmsUserById(Long id);
	List<SmbmsUser> getAllSmbmsUsers();
	List<SmbmsUser> getSmbmsUsers(SmbmsUser user);
}
