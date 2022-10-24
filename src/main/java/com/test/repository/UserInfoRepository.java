package com.test.repository;

import com.test.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface  UserInfoRepository  {

    List<UserInfo> selectAll();

    void columnAdd();

    void columnDel();

}
