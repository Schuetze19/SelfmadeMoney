package com.example.dennis.selfmademoney.dao;

import com.example.dennis.selfmademoney.model.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

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
        return model;
    }

    @Override
    public User update(User model) {
        if(model != null){
            // Wenn man z.B. nur die E-Mail ändern möchte, muss man nur databaseReference.child(model.getId()).child("email").setValue("neueEmail"); eingeben.
            databaseReference.child(model.getId()).setValue(model);
        }
        return model;
    }

    @Override
    public User delete(User model) {
        if(model != null){
            databaseReference.child(model.getId()).removeValue();
        }
        return model;
    }

    @Override
    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }
}
