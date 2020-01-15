package com.root.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.dao.UsersMapper;
import com.root.entity.Users;
import com.root.service.UsersService;


//	@Service("UsersService")
	 public class UsersServiceImpl  implements UsersService{
		
//	@Autowired
	 UsersMapper um;
	
		@Override
		public List<Users> getAll() {
			// TODO Auto-generated method stub
			return  um.getAll();
		}
		@Override
		public int shan(String id) {
			// TODO Auto-generated method stub
			return um.shan(id);
		}
		@Override
		public int add(Users u) {
			// TODO Auto-generated method stub
			return um.add(u);
		}
		@Override
		public List<Users> sou(String name) {
			// TODO Auto-generated method stub
			return um.sou(name);
		}
		@Override
		public List<Users> cha(String id) {
			// TODO Auto-generated method stub
			return um.cha(id);
		}
		@Override
		public int upUser(Users u) {
			// TODO Auto-generated method stub
			return um.upUser(u);
		}


	}


