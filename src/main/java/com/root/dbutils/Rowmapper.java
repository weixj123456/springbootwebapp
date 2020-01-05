package com.root.dbutils;

import java.sql.ResultSet;
 
public interface Rowmapper {
		//此处根据需求，将rs查询的结果集用对象接收；
		 public Object rowMapper(ResultSet rs);
}

