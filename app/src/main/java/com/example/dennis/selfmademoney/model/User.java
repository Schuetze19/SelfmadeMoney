package com.example.dennis.selfmademoney.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@IgnoreExtraProperties
public class User {

    private String id;
    private boolean male;
    private String username, vorname, nachname, wohnort, email;
    private String password, beschreibung;
    private Date mitgliedSeit = new Date();
    private Date geborenAm;
    private List<Auftrag> auftragsliste = new ArrayList<>();
    private final String datePattern = "dd.MM.yyyy";

    public User(){}

    public User(final String vorname, final String nachname, final String username, final String email, String password, final Date geborenAm, final String wohnort, boolean male){
        this.vorname = vorname;
        this.nachname = nachname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.geborenAm = geborenAm;
        this.mitgliedSeit.setTime(new Date().getTime());
        this.wohnort = wohnort;
        this.male = male;
    }

    public User(final String id, final String vorname, final String nachname, final String username, final String email, String password, final Date geborenAm, final String wohnort, boolean male){
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.geborenAm = geborenAm;
        this.mitgliedSeit.setTime(new Date().getTime());
        this.wohnort = wohnort;
        this.male = male;
    }

    public User(final String id, final String vorname, final String nachname, final String username, final String email, String password, final Date geborenAm, final String wohnort, boolean male, List<Auftrag> auftragsliste){
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.geborenAm = geborenAm;
        this.mitgliedSeit.setTime(new Date().getTime());
        this.wohnort = wohnort;
        this.male = male;
        this.auftragsliste = auftragsliste;
    }

    public User(boolean male, String username, String vorname, String nachname, String wohnort, String email, String password, Date mitgliedSeit, Date geborenAm) {
        this.male = male;
        this.username = username;
        this.vorname = vorname;
        this.nachname = nachname;
        this.wohnort = wohnort;
        this.email = email;
        this.password = password;
        this.mitgliedSeit = mitgliedSeit;
        this.geborenAm = geborenAm;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getMitgliedSeit(){
        return new SimpleDateFormat(datePattern).format(mitgliedSeit.getTime());
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getFullName(){
        return vorname+" "+nachname;
    }

    public String getGeborenAm() {
        return new SimpleDateFormat(datePattern).format(geborenAm.getTime());
    }

    public String getWohnort() {
        return wohnort;
    }

    public boolean isMale() {
        return male;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public List<Auftrag> getAuftragsliste() {
        return auftragsliste;
    }

    public void setMitgliedSeit(String mitgliedSeit) {
        try {
            this.mitgliedSeit = new SimpleDateFormat(datePattern).parse(mitgliedSeit);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGeborenAm(String geborenAm) {
        try {
            this.geborenAm = new SimpleDateFormat(datePattern).parse(geborenAm);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setAuftragsliste(List<Auftrag> auftragsliste) {
        this.auftragsliste = auftragsliste;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", male=" + male +
                ", username='" + username + '\'' +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", wohnort='" + wohnort + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", mitgliedSeit=" + mitgliedSeit +
                ", geborenAm=" + geborenAm +
                ", auftragsliste=" + auftragsliste +
                '}';
    }
}
