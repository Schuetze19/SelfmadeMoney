package com.example.dennis.selfmademoney.dao;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public interface IRepository<T> {

    T save(T model);
    T update(T model);

    /**
     * Dient zum löschen eines Models.
     * Falls man es sich kurzfristig anders überlegt und das Model wieder haben möchte (Undo-Funktion), kann man das Model wieder anlegen (Deswegen wird das gelöschte Model returnt).
     * @param model Das zu löschende Model
     * @return Das gelöschte Model
     */
    T delete(T model);

    /**
     * @param id id des Models
     * @return 1 Model
     */
    T findById(long id);

    /**
     * @return Genau 10 Models
     */
    List<T> findAll();

    DatabaseReference getDatabaseReference();
}
