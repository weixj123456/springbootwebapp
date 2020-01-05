package com.root.dao;

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;

import com.root.entity.Channel;

@MapperScan
public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);
    
    Channel selectByChannelid(String channelid);
    
    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
        
    List<Channel>  getAll();
    
    
}