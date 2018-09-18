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
    public Auftrag findById(long id) {
        return id <= auftragsliste.size() && id > 0 ? auftragsliste.get((int) id - 1) : null;
    }

    @Override
    public ArrayList<Auftrag> findAll() {
        return auftragsliste;
    }

    public ArrayList<Auftrag> findAllLaufende(){
        ArrayList laufendeAuftraege = new ArrayList();
        for (Auftrag auftrag: auftragsliste) {
            if(auftrag.isLaufend())
                laufendeAuftraege.add(auftrag);
        }
        return laufendeAuftraege;
    }

    public ArrayList<Auftrag> findAllAbgeschlossene(){
        ArrayList abgeschlosseneAuftraege = new ArrayList();
        for (Auftrag auftrag: auftragsliste) {
            if(auftrag.isAbgeschlossen())
                abgeschlosseneAuftraege.add(auftrag);
        }
        return abgeschlosseneAuftraege;
    }

    @Override
    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }
}
