package com.food.myapp.users.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.myapp.users.UsersService;
import com.food.myapp.users.UsersVO;



@Service("UsersService")
public class UsersServiceImpl implements UsersService{

	


	
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Override
	public void insertUsers(UsersVO vo) {
		usersDAO.insertUsers(vo);	
	}

	@Override
	public UsersVO getUsers(UsersVO vo) {

		return usersDAO.getUsers(vo);
	}
	
	// ���̵� �ߺ� üũ
	@Override
	public int idChk(UsersVO vo) {
		int result = usersDAO.idChk(vo);
		return 	result;
	}
	


}
