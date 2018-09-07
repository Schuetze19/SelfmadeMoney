package com.example.dennis.selfmademoney.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dennis.selfmademoney.R;

public class StartseiteFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_startseite, container, false);
    }
}
