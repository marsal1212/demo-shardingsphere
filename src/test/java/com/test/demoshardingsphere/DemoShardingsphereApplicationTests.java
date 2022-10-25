package com.test.demoshardingsphere;

import com.test.repository.UserInfoRepository;
import org.apache.shardingsphere.infra.database.type.dialect.MySQLDatabaseType;
import org.apache.shardingsphere.infra.metadata.database.schema.loader.common.TableMetaDataLoader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class DemoShardingsphereApplicationTests {


    @Resource
    private UserInfoRepository userInfoRepository;

    @Resource
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() throws SQLException {

        userInfoRepository.selectAll();
        userInfoRepository.columnAdd();
        try {
            userInfoRepository.selectAll();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());
            refresh();
        }
        userInfoRepository.selectAll();
    }

    public void refresh() throws SQLException {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        TableMetaDataLoader.load(dataSource, "user_info",
                new MySQLDatabaseType());
    }
}
