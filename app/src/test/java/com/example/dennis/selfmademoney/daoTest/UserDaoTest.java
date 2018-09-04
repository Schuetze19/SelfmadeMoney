package com.example.dennis.selfmademoney.daoTest;

import com.example.dennis.selfmademoney.dao.UserDao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    private final UserDao userDao = new UserDao();

    @Test
    public void findUser(){
        assertEquals(userDao.findAll().get(2),userDao.findById(3));
        assertEquals(null,userDao.findById(11));
    }

}
