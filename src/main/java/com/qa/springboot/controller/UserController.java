package com.qa.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.pojo.User;
import com.qa.springboot.service.UserService;

@RestController
@RequestMapping("/userController")
public class UserController {
	
	@Autowired
	UserService us;
	
	
	@RequestMapping("/query")
	public Map<String, Object> queryAll(Integer limit,Integer offset,@RequestParam(value="truename",required=false)String truename){
		
		Map<String, Object> map = new HashMap<String, Object>();
		//总记录数
		int total = us.queryAll(truename);
		//每页显示数据集合
		List<User> count = us.queryBySearchName(offset, limit, truename);
		map.put("total", total);
		map.put("rows", count);
		return map;
	}
	@RequestMapping("/save")
	public String save(@Valid User u,Errors  e){
		String s = u.getSalt();
		int i = s.lastIndexOf("\\")+1;
		String salt = s.substring(i);
		u.setSalt(salt);
		String str="新增成功";
		List<ObjectError> es = e.getAllErrors();
		if(es.size()>0){
			for (ObjectError ee : es) {
				str=ee.getDefaultMessage();
			}
		}else{
			us.addUser(u);
		}
		return str;
	}
	@RequestMapping("/chek")
	public String chek(String username){
		boolean flag = us.chekUsername(username);
		if(flag){
			return "账号已存在";
		}
		return "";
	}
	
	@RequestMapping("/del")
	public String del(@RequestParam("uids")Integer[] uids){
		
		us.delUser(uids);
		return "删除成功！";
	}
	@RequestMapping("/edit")
	public User edit(Integer uid){
		return us.queryById(uid);
	}
	@RequestMapping("/update")
	public String update(@Valid User u,Errors  e){
		String s = u.getSalt();
		int i = s.lastIndexOf("\\")+1;
		String salt = s.substring(i);
		u.setSalt(salt);
		String str="修改成功";
		List<ObjectError> es = e.getAllErrors();
		if(es.size()>0){
			for (ObjectError ee : es) {
				str=ee.getDefaultMessage();
			}
		}else{
			us.updateByUid(u);
		}
		return str;
	}

}
