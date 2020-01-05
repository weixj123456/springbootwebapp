package com.root.dao;

import java.util.List;
import java.util.Map;

import com.root.entity.Idcard;


public interface IdcardMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(Idcard record);

    int insertSelective(Idcard record);

    Idcard selectByPrimaryKey(Integer id);
     
    Idcard selectByidno(String idno);
    
    int updateByPrimaryKeySelective(Idcard record);

    int updateByPrimaryKey(Idcard record);
    
    int updateByIdno(Map<String, Object> map);
    
    List<Idcard>  getAll();
    /*
     <select id="getAll"  resultType="cn.temptation.domain.Idcard">
    select * from idcard  where 1=1
  </select>
    */
}