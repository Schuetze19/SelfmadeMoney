package com.example.dennis.selfmademoney.dao;

import com.example.dennis.selfmademoney.model.User;
import com.example.dennis.selfmademoney.util.Shuffle;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements IRepository<User> {

    @Override
    public User save(User model) {
        // User mit model.ID X soll durch model ersetzt werden.
        return model;
    }

    @Override
    public User update(User model) {
        // User mit model.ID X soll durch model ersetzt werden.
        return model;
    }

    @Override
    public User delete(User model) {
        // User mit model.ID X soll gelöscht werden.
        return model;
    }

    @Override
    public User findById(long id) {
        // User mit id X soll zurückgegeben werden.
        return createUser(id);
    }

    @Override
    public List<User> findAll() {
        // Alle User sollen zurückgegeben werden.
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            userList.add(createUser(i));
        }
        return userList;
    }

    private User createUser(long id){
        return new User(id, Shuffle.shuffle("John_Test"),Shuffle.shuffle("John_Test@Test.de"),Shuffle.shuffle("password"));
    }
}
