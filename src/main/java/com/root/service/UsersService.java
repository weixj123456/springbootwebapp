package com.root.service;

import java.util.List;

import com.root.entity.Users;

//	@Repository("UsersMapper")
	public interface UsersService {
		public List<Users> getAll();
		public int shan(String id);
		public int add(Users u);
		public List<Users> sou(String name);
		public List<Users> cha(String id);
		public int upUser(Users u);
	}


