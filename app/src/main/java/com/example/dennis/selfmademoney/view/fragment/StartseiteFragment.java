package com.example.dennis.selfmademoney.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennis.selfmademoney.R;
import com.example.dennis.selfmademoney.adapter.StartseiteAuftraegeViewAdapter;
import com.example.dennis.selfmademoney.dao.AuftragDao;
import com.example.dennis.selfmademoney.model.Auftrag;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StartseiteFragment extends Fragment {

    private RecyclerView startseite_auftraege;
    private SearchView searchView;
    private final ArrayList<Auftrag> auftragArrayList = new ArrayList<>();
    private final AuftragDao auftragDao = new AuftragDao();
    private static StartseiteFragment fragment;

    public StartseiteFragment() {}

    public static StartseiteFragment newInstance() {
        if (fragment == null) {
            fragment = new StartseiteFragment();
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_startseite, container,false);
        startseite_auftraege = view.findViewById(R.id.startseite_auftraege);
        startseite_auftraege.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchView = view.findViewById(R.id.searchView);
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

        auftragDao.getDatabaseReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                auftragArrayList.clear();
                for (DataSnapshot data: dataSnapshot.getChildren()) {
                    auftragArrayList.add(data.getValue(Auftrag.class));
                }
                startseite_auftraege.setAdapter(new StartseiteAuftraegeViewAdapter(getActivity(), auftragArrayList));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
