package com.example.dennis.selfmademoney.dao;

import com.example.dennis.selfmademoney.model.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserDao implements IRepository<User> {

    private final ArrayList<User> userList = new ArrayList(Arrays.asList(
            new User(1,"Schuetze19","Schuetze19@yahoo.de","PasswordSchuetze"),
            new User(2,"Bonziller","Bonziller@yahoo.de","PasswordBonziller"),
            new User(3,"MoneyMüller","MoneyMüller@yahoo.de","PasswordMoneyMüller"),
            new User(4,"SiegerTyp","SiegerTyp@yahoo.de","PasswordSiegerTyp"),
            new User(5,"StahlTräger18","StahlTräger18@yahoo.de","PasswordStahlTräger18"),
            new User(6,"Gnome8532","Gnome8532@yahoo.de","PasswordGnome8532"),
            new User(7,"TopfGold","TopfGold@yahoo.de","PasswordTopfGold"),
            new User(8,"DonaldTrump","DonaldTrump@yahoo.de","PasswordDonaldTrump"),
            new User(9,"GeldMaschine","GeldMaschine@yahoo.de","PasswordGeldMaschine"),
            new User(10,"AliBaba","AliBaba@yahoo.de","PasswordAliBaba")));

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
