package com.test.rest;

import com.test.entity.UserInfo;
import com.test.repository.UserInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestRest {

    @Resource
    private UserInfoRepository userInfoRepository;

    @GetMapping("list")
    public List<UserInfo> list(){
        return  userInfoRepository.selectAll();
    }


    @GetMapping("column/add")
    public void add(){
        userInfoRepository.columnAdd();
    }

    @GetMapping("column/del")
    public void alert(){
        userInfoRepository.columnDel();
    }

}
