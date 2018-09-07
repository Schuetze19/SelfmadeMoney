package com.example.dennis.selfmademoney.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennis.selfmademoney.R;
import com.example.dennis.selfmademoney.adapter.MeineAuftraegeViewAdapter;
import com.example.dennis.selfmademoney.dao.AuftragDao;
import com.example.dennis.selfmademoney.model.Auftrag;

import java.util.ArrayList;

public class MeineAuftrageFragment extends Fragment {

    private RecyclerView laufende_auftraege_recyclerview, abgeschlossene_auftraege_recyclerview;
    private AuftragDao auftragDao = new AuftragDao();

    public MeineAuftrageFragment() {}

    public static MeineAuftrageFragment newInstance() {
        MeineAuftrageFragment fragment = new MeineAuftrageFragment();
        return fragment;
    }

    public static MeineAuftrageFragment newInstance(String param1, String param2) {
        MeineAuftrageFragment fragment = new MeineAuftrageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meine_auftrage, container, false);
        laufende_auftraege_recyclerview = view.findViewById(R.id.laufende_auftraege_recyclerview);
        laufende_auftraege_recyclerview.setAdapter(new MeineAuftraegeViewAdapter(getActivity(), auftragDao.findAllLaufende(), null));
        laufende_auftraege_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        abgeschlossene_auftraege_recyclerview = view.findViewById(R.id.abgeschlossene_auftraege_recyclerview);
        abgeschlossene_auftraege_recyclerview.setAdapter(new MeineAuftraegeViewAdapter(getActivity(), auftragDao.findAllAbgeschlossene(), Auftrag.Status.ABGESCHLOSSEN));
        abgeschlossene_auftraege_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
