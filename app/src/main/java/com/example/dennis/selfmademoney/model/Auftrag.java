package com.example.dennis.selfmademoney.model;

import java.util.Calendar;
import java.util.Date;

public class Auftrag {

    private long id;
    private String titel, beschreibung;
    private Calendar erstellungsdatum = Calendar.getInstance();
    private Calendar auftragsstart = Calendar.getInstance();
    private String location;
    private double verguetung;
    private Status status;

    public enum Status{
        LAUFEND,
        GELOESCHT,
        ABGESCHLOSSEN;
    }

    public Auftrag(){}

    public Auftrag(String titel, String beschreibung, Date auftragsstart, double verguetung, String location) {
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.auftragsstart.setTime(auftragsstart);
        this.verguetung = verguetung;
        this.location = location;
        this.erstellungsdatum.setTime(new Date());
    }

    public Auftrag(final long id, String titel, String beschreibung, Date auftragsstart, double verguetung) {
        this.id = id;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.auftragsstart.setTime(auftragsstart);
        this.verguetung = verguetung;
        this.erstellungsdatum.setTime(new Date());
        if(id < 3)
            this.status = Status.LAUFEND;
        else
            this.status = Status.ABGESCHLOSSEN;
    }

    public long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Date getErstellungsdatum() {
        return erstellungsdatum.getTime();
    }

    public Date getAuftragsstart() {
        return auftragsstart.getTime();
    }

    public double getVerguetung() {
        return verguetung;
    }

    public void setVerguetung(double verguetung) {
        this.verguetung = verguetung;
    }

    public boolean isLaufend(){
        return Status.LAUFEND.equals(status);
    }

    public boolean isGeloescht(){
        return Status.GELOESCHT.equals(status);
    }

    public boolean isAbgeschlossen(){
        return Status.ABGESCHLOSSEN.equals(status);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
