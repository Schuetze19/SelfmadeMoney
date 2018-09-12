package com.example.dennis.selfmademoney.view.fragment;

import android.os.AsyncTask;
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

import java.util.ArrayList;

public class StartseiteFragment extends Fragment {

    private RecyclerView startseite_auftraege;
    private SearchView searchView;
    private AuftragDao auftragDao = new AuftragDao();

    public StartseiteFragment() {}

    public static StartseiteFragment newInstance() {
        StartseiteFragment fragment = new StartseiteFragment();
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
        new AsynchAuftraegeLoader().execute();
        return view;
    }

    private class AsynchAuftraegeLoader extends AsyncTask<Void,Void,ArrayList<Auftrag>>{

        @Override
        protected ArrayList<Auftrag> doInBackground(Void... voids) {
            return auftragDao.findAllLaufende();
        }

        @Override
        protected void onPostExecute(ArrayList<Auftrag> auftragArrayList) {
            startseite_auftraege.setAdapter(new StartseiteAuftraegeViewAdapter(getActivity(), auftragArrayList));
        }
    }

}
