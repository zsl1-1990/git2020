package com.qa.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springboot.mapper.UserMapper;
import com.qa.springboot.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper um;
	
	@Override
	public List<User> queryBySearchName(int offset, int limit, String truename) {
		return um.selectUserByLimit(offset, limit, "%"+truename+"%");
	}

	@Override
	public int queryAll(String truename) {
		System.out.println(truename);
		return um.selectTotal(truename);
	}

	@Override
	public void addUser(User u) {
		um.insert(u);
		
	}

	@Override
	public boolean chekUsername(String username) {
		User u = um.selectUsername(username);
		if(u!=null){
			return true;
		}
		return false;
	}

	@Override
	public void delUser(Integer[] uids) {
		um.deleteByUids(uids);
		
	}

	@Override
	public User queryById(Integer uid) {
		
		return um.selectByPrimaryKey(uid);
	}

	@Override
	public void updateByUid(User user) {
		um.updateByPrimaryKey(user);
		
	}


}
