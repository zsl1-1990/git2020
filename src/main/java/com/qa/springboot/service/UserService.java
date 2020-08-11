package com.qa.springboot.service;

import java.util.List;

import com.qa.springboot.pojo.User;

public interface UserService {
	//查询
	List<User> queryBySearchName(int offset,int limit,String truename);
	
	//查询所有
	int queryAll(String truename);
	
	//新增
	void addUser(User u);
	
	//账号是否存在
	boolean chekUsername(String username);
	
	//根据UID删除
	void delUser(Integer[]uids);
	
	//根据UID查询用户
	User queryById(Integer uid);
	
	//根据UID修改
	void updateByUid(User user);
}
