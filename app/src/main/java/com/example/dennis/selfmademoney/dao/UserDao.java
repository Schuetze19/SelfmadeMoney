package com.example.dennis.selfmademoney.dao;

import com.example.dennis.selfmademoney.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class UserDao implements IRepository<User> {
    private final String datePattern = "dd.MM.yyyy";
    private ArrayList<User> userList = new ArrayList<>();
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

    public UserDao(){

    }

    @Override
    public User save(User model) {
        if(model != null){
            String id = databaseReference.push().getKey();
            databaseReference.child(id).setValue(model);
            model.setId(id);
        }
        // User mit model.ID X soll durch model ersetzt werden.
        return model;
    }

    @Override
    public User update(User model) {
        if(model != null){
            databaseReference.child(model.getId()).setValue(model);
        }
        // User mit model.ID X soll durch model ersetzt werden.
        return model;
    }

    @Override
    public User delete(User model) {
        if(model != null){
            databaseReference.child(model.getId()).removeValue();
        }
        // User mit model.ID X soll gelöscht werden.
        return model;
    }

    @Override
    public User findById(long id) {
        // User mit id X soll zurückgegeben werden.
        // Falls die Id > 10 ist, dann wird der User "nicht gefunden" und dementsprechen Null zurückgegeben.
        return id <= userList.size() && id > 0 ? userList.get((int)id - 1) : null;
    }

    @Override
    public ArrayList<User> findAll() {
        // Alle User sollen zurückgegeben werden. (Aus test zwecken immer 10)
        return userList;
    }

    @Override
    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }
}
