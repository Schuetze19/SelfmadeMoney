package com.example.dennis.selfmademoney.controller;

import com.example.dennis.selfmademoney.dao.AuftragDao;
import com.example.dennis.selfmademoney.model.Auftrag;

import java.util.Date;

// Ist diese Klasse wirklich nötig? Es ist nur eine "Weiterleitungsklasse"
public class AuftragController {

    private AuftragDao auftragDao = new AuftragDao();

    public AuftragController(){}

    public void createAuftrag(String titel, String beschreibung, Date auftragsstart, double verguetung, String location, String userId){
        Auftrag auftrag = new Auftrag(titel, beschreibung, auftragsstart, verguetung, location, userId);
        auftragDao.save(auftrag);
    }

    private void clearAuftrag(){

    }

    private void cancelAuftrag(){

    }
}
