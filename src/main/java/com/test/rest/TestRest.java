package com.test.rest;

import com.test.entity.UserInfo;
import com.test.repository.UserInfoRepository;
import org.apache.shardingsphere.driver.jdbc.core.datasource.ShardingSphereDataSource;
import org.apache.shardingsphere.mode.manager.ContextManager;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

@RestController
public class TestRest {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Resource
    private ApplicationContext applicationContext;

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

    @GetMapping("refresh")
    public void refresh() throws SQLException {
        ShardingSphereDataSource dataSource = applicationContext.getBean(ShardingSphereDataSource.class);
        String schema = dataSource.getConnection().getSchema();
        ContextManager contextManager = getContextManager(dataSource);
        contextManager.reloadSchema(schema, schema, "ds-0");
        contextManager.reloadSchema(schema, schema, "ds-1");
    }

    private ContextManager getContextManager(ShardingSphereDataSource dataSource) {
        try {
            Field contextManagerField = dataSource.getClass().getDeclaredField("contextManager");
            contextManagerField.setAccessible(true);
            return (ContextManager) contextManagerField.get(dataSource);
        } catch (Exception e) {
            throw new RuntimeException("系统异常");
        }
    }


}
