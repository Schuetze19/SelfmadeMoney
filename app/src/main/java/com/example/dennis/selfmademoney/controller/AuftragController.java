package com.example.dennis.selfmademoney.controller;

import com.example.dennis.selfmademoney.model.Auftrag;

import java.util.Date;

public class AuftragController {

    public AuftragController(){}

    public void createAuftrag(String titel, String beschreibung, Date auftragsstart, double verguetung, String location){
        Auftrag auftrag = new Auftrag(titel, beschreibung, auftragsstart, verguetung, location);
        //Objekt ist bereit um in die Datenbank geschrieben zu werden.
        //Überlegung -> Datenbankoperationen in eine Manager bzw Service Klasse auslagern.

    }

    private void clearAuftrag(){

    }

    private void cancelAuftrag(){

    }
}
