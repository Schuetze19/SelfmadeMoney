package com.example.dennis.selfmademoney.model;

import java.util.Date;

public class Auftrag {

    private String id;
    private String titel, beschreibung;
    private Date erstellungsdatum = new Date();
    private Date auftragsstart = new Date();
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
        this.auftragsstart.setTime(auftragsstart.getTime());
        this.verguetung = verguetung;
        this.location = location;
        this.erstellungsdatum.setTime(new Date().getTime());
    }

    public Auftrag(final String id, String titel, String beschreibung, Date auftragsstart, double verguetung, String location) {
        this.id = id;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.auftragsstart.setTime(auftragsstart.getTime());
        this.verguetung = verguetung;
        this.erstellungsdatum.setTime(new Date().getTime());
        this.location = location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
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
        return erstellungsdatum;
    }

    public Date getAuftragsstart() {
        return auftragsstart;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
