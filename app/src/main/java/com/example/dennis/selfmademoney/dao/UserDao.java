package com.example.dennis.selfmademoney.dao;

import com.example.dennis.selfmademoney.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class UserDao implements IRepository<User> {
    private final String datePattern = "dd.MM.yyyy";
    private ArrayList<User> userList;

    {
        try {
            userList = new ArrayList(Arrays.asList(
                        new User(1,"Dennis","A","Schuetze19","Schuetze19@yahoo.de","PasswordSchuetze", new SimpleDateFormat(datePattern).parse("01.01.1980"),"Berlin",true),
                        new User(2,"Michael","K","Bonziller","Bonziller@yahoo.de","PasswordBonziller", new SimpleDateFormat(datePattern).parse("06.08.1995"),"Berlin", true),
                        new User(3,"Meier","Müller","MoneyMüller","MoneyMüller@yahoo.de","PasswordMoneyMüller", new SimpleDateFormat(datePattern).parse("11.11.1958"),"Brandenburg", true),
                        new User(4,"Henry","Sieg","SiegerTyp","SiegerTyp@yahoo.de","PasswordSiegerTyp", new SimpleDateFormat(datePattern).parse("21.07.1988"),"Köln", true),
                        new User(5,"Carsten","Stahl","StahlTräger18","StahlTräger18@yahoo.de","PasswordStahlTräger18", new SimpleDateFormat(datePattern).parse("15.02.1991"),"München",true),
                        new User(6,"Gisela","Norment","Gnome8532","Gnome8532@yahoo.de","PasswordGnome8532", new SimpleDateFormat(datePattern).parse("09.06.1978"),"Stuttgart", false),
                        new User(7,"Tina","Gold","TopfGold","TopfGold@yahoo.de","PasswordTopfGold", new SimpleDateFormat(datePattern).parse("03.04.1986"),"Hamburg", false),
                        new User(8,"Donald","Trump","DonaldTrump","DonaldTrump@yahoo.de","PasswordDonaldTrump", new SimpleDateFormat(datePattern).parse("13.01.1990"),"Frankfurt", true),
                        new User(9,"Robert","Reuther","GeldMaschine","GeldMaschine@yahoo.de","PasswordGeldMaschine", new SimpleDateFormat(datePattern).parse("07.07.1977"),"Berlin", true),
                        new User(10,"Ali","Baba","AliBaba","AliBaba@yahoo.de","PasswordAliBaba", new SimpleDateFormat(datePattern).parse("22.12.1978"),"Köln", true)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User save(User model) {
        // User mit model.ID X soll durch model ersetzt werden.
        return model;
    }

    @Override
    public User update(User model) {
        // User mit model.ID X soll durch model ersetzt werden.
        return model;
    }

    @Override
    public User delete(User model) {
        // User mit model.ID X soll gelöscht werden.
        return model;
    }

    @Override
    public User findById(long id) {
        // User mit id X soll zurückgegeben werden.
        // Falls die Id > 10 ist, dann wird der User "nicht gefunden" und dementsprechen Null zurückgegeben.
        return id <= userList.size() && id > 0 ? userList.get((int)id - 1) : null;
    }

    @Override
    public ArrayList<User> findAll() {
        // Alle User sollen zurückgegeben werden. (Aus test zwecken immer 10)
        return userList;
    }
}
