package com.example.dennis.selfmademoney.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennis.selfmademoney.R;

public class MeineAuftrageFragment extends Fragment {

    public MeineAuftrageFragment() {}

    public static MeineAuftrageFragment newInstance(String param1, String param2) {
        MeineAuftrageFragment fragment = new MeineAuftrageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meine_auftrage, container, false);

        return view;
    }

}
