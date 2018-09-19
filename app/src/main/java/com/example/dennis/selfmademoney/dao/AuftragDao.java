package com.example.dennis.selfmademoney.dao;

import com.example.dennis.selfmademoney.model.Auftrag;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class AuftragDao implements IRepository<Auftrag> {

    private final String datePattern = "dd.MM.yyyy";
    private ArrayList<Auftrag> auftragsliste = new ArrayList<>();
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("auftraege");

    public AuftragDao(){

    }

    @Override
    public Auftrag save(Auftrag model) {
        if(model != null) {
            String id = databaseReference.push().getKey();
            databaseReference.child(id).setValue(model);
            model.setId(id);
            auftragsliste.add(model);
        }
        return model;
    }

    @Override
    public Auftrag update(Auftrag model) {
        if(model != null){
            databaseReference.child(model.getId()).setValue(model);
        }
        return model;
    }

    @Override
    public Auftrag delete(Auftrag model) {

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
