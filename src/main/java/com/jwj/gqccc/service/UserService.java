package com.jwj.gqccc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwj.gqccc.bean.User;
import com.jwj.gqccc.bean.UserExample;
import com.jwj.gqccc.bean.UserExample.Criteria;
import com.jwj.gqccc.dao.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;


	public void insertNewUser(User u){
		userMapper.insertSelective(u);
	}
	
	public boolean isUserExist(String uid) {
		User u = userMapper.selectByPrimaryKey(uid);
		if (u != null) {
			return true;// 数据库中已存在该用户
		} else {
			return false;// 数据库中没有该用户，该用户为新用户
		}
	}
	
	public void update(User user){
		UserExample example = new UserExample();
		 Criteria criteria = example.createCriteria();
		 criteria.andUidEqualTo(user.getUid());
		
		userMapper.updateByExampleSelective(user, example);
	}
	
}
