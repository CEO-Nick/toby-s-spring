package com.study.tobyspring.user.dao;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DaoFactory {

    /**
     * 팩토리의 메서드
     * UserDAO 타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지 결정
     */
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/toby_spring");
        dataSource.setUsername("root");
        dataSource.setPassword("whdlrgus99@");
    }

}
