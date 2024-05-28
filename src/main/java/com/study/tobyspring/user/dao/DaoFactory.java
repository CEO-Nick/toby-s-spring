package com.study.tobyspring.user.dao;

public class DaoFactory {

    /**
     * 팩토리의 메서드
     * UserDAO 타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지 결정
     */
    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

}
