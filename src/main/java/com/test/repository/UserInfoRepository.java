package com.test.repository;

import com.test.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface  UserInfoRepository  {

    void init();

    List<UserInfo> selectAll();

    void columnAdd();

    void columnDel();

}
