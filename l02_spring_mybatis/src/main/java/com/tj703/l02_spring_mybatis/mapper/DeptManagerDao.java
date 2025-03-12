package com.tj703.l02_spring_mybatis.mapper;

import com.tj703.l02_spring_mybatis.dto.DeptManager;
import com.tj703.l02_spring_mybatis.dto.DeptManagerKey;

public interface DeptManagerDao {
    int deleteByPrimaryKey(DeptManagerKey key);

    int insert(DeptManager record);

    int insertSelective(DeptManager record);

    DeptManager selectByPrimaryKey(DeptManagerKey key);

    int updateByPrimaryKeySelective(DeptManager record);

    int updateByPrimaryKey(DeptManager record);
}