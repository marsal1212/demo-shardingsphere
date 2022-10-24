# init.sql
```
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `add_test` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NOT NULL,
  `sex` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

INSERT INTO `test_sp`.`user_info` (`id`, `name`, `age`, `sex`) VALUES (1, 'zhangsan', 110, 1);

```

# steps
1. query all columns data 
   
       curl 'http://localhost:8091/list'
2.  add a column
     
        curl 'http://localhost:8091/column/add'
3.  query all columns data again

        curl 'http://localhost:8091/list'


4.    then throw an exception:

            2022-10-24 23:10:55.763 ERROR 47648 --- [io-8091-exec-10] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.dao.TransientDataAccessResourceException: 
                ### Error querying database.  Cause: java.sql.SQLException: java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
                ### The error may exist in mapper/UserInfoMapper.xml
                ### The error may involve defaultParameterMap
                ### The error occurred while setting parameters
                ### SQL: select * from user_info
                ### Cause: java.sql.SQLException: java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
                ; java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4; nested exception is java.sql.SQLException: java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4] with root cause
                
                java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
                at com.mysql.cj.protocol.a.MergingColumnDefinitionFactory.createFromFields(MergingColumnDefinitionFactory.java:61) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.protocol.a.ColumnDefinitionReader.read(ColumnDefinitionReader.java:80) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.protocol.a.ColumnDefinitionReader.read(ColumnDefinitionReader.java:40) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.protocol.a.NativeProtocol.read(NativeProtocol.java:1587) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.protocol.a.BinaryResultsetReader.read(BinaryResultsetReader.java:70) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.protocol.a.BinaryResultsetReader.read(BinaryResultsetReader.java:50) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.protocol.a.NativeProtocol.read(NativeProtocol.java:1600) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.protocol.a.NativeProtocol.readAllResults(NativeProtocol.java:1654) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.ServerPreparedQuery.readExecuteResult(ServerPreparedQuery.java:433) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.ServerPreparedQuery.serverExecute(ServerPreparedQuery.java:211) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.jdbc.ServerPreparedStatement.serverExecute(ServerPreparedStatement.java:632) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.jdbc.ServerPreparedStatement.executeInternal(ServerPreparedStatement.java:418) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.mysql.cj.jdbc.ClientPreparedStatement.execute(ClientPreparedStatement.java:371) ~[mysql-connector-java-8.0.27.jar:8.0.27]
                at com.zaxxer.hikari.pool.ProxyPreparedStatement.execute(ProxyPreparedStatement.java:44) ~[HikariCP-4.0.3.jar:na]
                at com.zaxxer.hikari.pool.HikariProxyPreparedStatement.execute(HikariProxyPreparedStatement.java) ~[HikariCP-4.0.3.jar:na]
                at org.apache.shardingsphere.driver.jdbc.core.statement.ShardingSpherePreparedStatement$2.executeSQL(ShardingSpherePreparedStatement.java:442) ~[shardingsphere-jdbc-core-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.driver.jdbc.core.statement.ShardingSpherePreparedStatement$2.executeSQL(ShardingSpherePreparedStatement.java:438) ~[shardingsphere-jdbc-core-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.infra.executor.sql.execute.engine.driver.jdbc.JDBCExecutorCallback.execute(JDBCExecutorCallback.java:95) ~[shardingsphere-infra-executor-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.infra.executor.sql.execute.engine.driver.jdbc.JDBCExecutorCallback.execute(JDBCExecutorCallback.java:75) ~[shardingsphere-infra-executor-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.infra.executor.kernel.ExecutorEngine.syncExecute(ExecutorEngine.java:135) ~[shardingsphere-infra-executor-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.infra.executor.kernel.ExecutorEngine.parallelExecute(ExecutorEngine.java:131) ~[shardingsphere-infra-executor-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.infra.executor.kernel.ExecutorEngine.execute(ExecutorEngine.java:116) ~[shardingsphere-infra-executor-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.infra.executor.sql.execute.engine.driver.jdbc.JDBCExecutor.execute(JDBCExecutor.java:65) ~[shardingsphere-infra-executor-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.infra.executor.sql.execute.engine.driver.jdbc.JDBCExecutor.execute(JDBCExecutor.java:49) ~[shardingsphere-infra-executor-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.driver.executor.DriverJDBCExecutor.doExecute(DriverJDBCExecutor.java:156) ~[shardingsphere-jdbc-core-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.driver.executor.DriverJDBCExecutor.execute(DriverJDBCExecutor.java:145) ~[shardingsphere-jdbc-core-5.2.1.jar:5.2.1]
                at org.apache.shardingsphere.driver.jdbc.core.statement.ShardingSpherePreparedStatement.execute(ShardingSpherePreparedStatement.java:403) ~[shardingsphere-jdbc-core-5.2.1.jar:5.2.1]
                at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:64) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:325) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:89) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:151) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:145) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:140) ~[mybatis-3.5.10.jar:3.5.10]
                at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
                at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
                at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
                at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
                at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:427) ~[mybatis-spring-2.0.7.jar:2.0.7]
                at jdk.proxy2/jdk.proxy2.$Proxy91.selectList(Unknown Source) ~[na:na]
                at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:224) ~[mybatis-spring-2.0.7.jar:2.0.7]
                at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:147) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:80) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.binding.MapperProxy$PlainMethodInvoker.invoke(MapperProxy.java:145) ~[mybatis-3.5.10.jar:3.5.10]
                at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:86) ~[mybatis-3.5.10.jar:3.5.10]
                at jdk.proxy4/jdk.proxy4.$Proxy92.selectAll(Unknown Source) ~[na:na]
                at com.test.rest.TestRest.list(TestRest.java:27) ~[main/:na]
                at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
                at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
                at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
                at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
                at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205) ~[spring-web-5.3.23.jar:5.3.23]
                at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150) ~[spring-web-5.3.23.jar:5.3.23]
                at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[spring-webmvc-5.3.23.jar:5.3.23]
                at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) ~[spring-webmvc-5.3.23.jar:5.3.23]
                at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) ~[spring-webmvc-5.3.23.jar:5.3.23]
                at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.3.23.jar:5.3.23]
                at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1071) ~[spring-webmvc-5.3.23.jar:5.3.23]
                at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:964) ~[spring-webmvc-5.3.23.jar:5.3.23]
                at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.3.23.jar:5.3.23]
                at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) ~[spring-webmvc-5.3.23.jar:5.3.23]
                at javax.servlet.http.HttpServlet.service(HttpServlet.java:670) ~[tomcat-embed-core-9.0.68.jar:4.0.FR]
                at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.3.23.jar:5.3.23]
                at javax.servlet.http.HttpServlet.service(HttpServlet.java:779) ~[tomcat-embed-core-9.0.68.jar:4.0.FR]
                at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.3.23.jar:5.3.23]
                at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.23.jar:5.3.23]
                at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.3.23.jar:5.3.23]
                at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.23.jar:5.3.23]
                at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter.doFilterInternal(WebMvcMetricsFilter.java:96) ~[spring-boot-actuator-2.6.13.jar:2.6.13]
                at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.23.jar:5.3.23]
                at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.3.23.jar:5.3.23]
                at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.23.jar:5.3.23]
                at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:360) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:893) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1789) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
                at java.base/java.lang.Thread.run(Thread.java:833) ~[na:na]

5. Then I tried the refresh reloadSchema and reported an error.
        
        curl http://localhost:8091/refresh