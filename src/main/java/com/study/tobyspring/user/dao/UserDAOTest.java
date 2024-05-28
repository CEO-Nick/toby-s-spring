package com.study.tobyspring.user.dao;

import com.study.tobyspring.user.domain.User;
import java.sql.SQLException;

public class UserDAOTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ConnectionMaker connectionMaker = new DConnectionMaker();
//        ConnectionMaker connectionMaker = new NConnectionMaker();

        // 이것도 관심사 분리가 안된 것.
        // UserDAOTest는 UserDAO 기능이 잘 동작하는 테스트하는 책임인데,
        // 어떤 ConnectionMaker 구현 클래스를 사용할지 결정하는 책임도 떠맡음
        
//        UserDao userDao = new UserDao(connectionMaker);

        // DaoFactory를 통해 UserDAO 생성하는 책임 안짐
        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("jiseon");
        user.setName("하지선");
        user.setPassword("gkwltjs");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공!!");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공!!");
    }

}
