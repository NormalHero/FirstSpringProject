package com.food.myapp.users.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.myapp.users.UsersVO;

@Repository("usersDAO")
public class UsersDAO  {
	
	
	@Autowired
	private  SqlSessionTemplate mybatis;
	
	public void insertUsers(UsersVO vo) {
		mybatis.insert("UsersDAO.insertUsers", vo);
	
	
	}
	
	public UsersVO getUsers(UsersVO vo) {
		return (UsersVO)mybatis.selectOne("UsersDAO.getUsers", vo);
	}
	public int idChk(UsersVO vo) {
		int result = mybatis.selectOne("UsersDAO.idChk", vo);
		return result;
	};
	

}