package com.example.dennis.selfmademoney.model;

import java.util.Calendar;
import java.util.Date;

public class Auftrag {

    private final long id;
    private String titel, beschreibung;
    private Calendar erstellungsdatum, auftragsstart = Calendar.getInstance();
    private double verguetung;
    private Status status;

    private enum Status{
        OFFEN,
        GELOESCHT,
        ABGESCHLOSSEN;
    }

    public Auftrag(final long id, String titel, String beschreibung, Date auftragsstart, double verguetung) {
        this.id = id;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.auftragsstart.setTime(auftragsstart);
        this.verguetung = verguetung;
        this.erstellungsdatum.setTime(new Date());
        this.status = Status.OFFEN;
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

    public boolean isOffen(){
        return Status.OFFEN.equals(status);
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
