package com.food.myapp.users;



public interface UsersService {

	void insertUsers(UsersVO vo);

	UsersVO getUsers(UsersVO vo);
	
	public int idChk(UsersVO vo) ;

}