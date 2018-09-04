package com.example.dennis.selfmademoney.dao;

import com.example.dennis.selfmademoney.model.Auftrag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuftragDao implements IRepository<Auftrag> {

    private ArrayList<Auftrag> auftragsliste;

    {
        try {
            auftragsliste = new ArrayList(Arrays.asList(new Auftrag(1,"Lebensmittel einkaufen","Wallah, ich brauche viel Mehl und Backpulver. Bier, Brot und vieles mehr", new SimpleDateFormat("dd.MM.yyyy").parse("15.09.2018"),6.50),
                    new Auftrag(2,"Alkohol für ne Party","Ich und meine Freunde veranstalten eine voll krasse Party und brauchen noch Alkohol. 2x Sky Vodka, 3x 1l Cola (1.5l is auch okay) und 2x 1 Liter Feigling ", new SimpleDateFormat("dd.MM.yyyy").parse("13.09.2018"),19.99)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Auftrag save(Auftrag model) {
        return model;
    }

    @Override
    public Auftrag update(Auftrag model) {
        return model;
    }

    @Override
    public Auftrag delete(Auftrag model) {
        return model;
    }

    @Override
    public Auftrag findById(long id) {
        return id <= auftragsliste.size() && id > 0 ? auftragsliste.get((int) id - 1) : null;
    }

    @Override
    public List<Auftrag> findAll() {
        return auftragsliste;
    }
}
