package com.example.dennis.selfmademoney.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.dennis.selfmademoney.R;
import com.example.dennis.selfmademoney.controller.AuftragController;

public class AuftragFragment extends Fragment {

    private Button btnCreate;
    private Button btnBack;
    private Button btnCancel;
    private EditText txtTitle;
    private EditText txtPayment;
    private EditText txtStarttime;
    private EditText txtLocation;
    private EditText txtDescription;
    private AuftragController auftragController = new AuftragController();

    public AuftragFragment () {}

    public static AuftragFragment newInstance() {
        AuftragFragment fragment = new AuftragFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auftrag, container, false);
        this.btnCreate = (Button) view.findViewById(R.id.btnCreate);
        this.btnBack = (Button) view.findViewById(R.id.btnBack);
        this.btnCancel = (Button) view.findViewById(R.id.btnCancel);
        this.txtTitle = (EditText) view.findViewById(R.id.txtTitle);
        this.txtPayment = (EditText) view.findViewById(R.id.txtPayment);
        this.txtStarttime = (EditText) view.findViewById(R.id.txtStarttime);
        this.txtLocation = (EditText) view.findViewById(R.id.txtLocation);
        this.txtDescription = (EditText) view.findViewById(R.id.txtDescription);
        addButtonListener();
        return view;
    }

    private void addButtonListener(){
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Benutereingabe von einem Datum nicht ohne weiteres möglich
                //uftragController.createAuftrag(
                //        txtTitle.getText().toString(), txtDescription.getText().toString(), Date.valueOf(txtStarttime.getText().toString()),
                //        Double.parseDouble(txtPayment.getText().toString()), txtLocation.getText().toString());
                clearUIElements();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearUIElements();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("ICH GEHE ZURÜCK");
                //Von hier zum davor gezeigen Fragment wechseln -> Keine Lösung gefunden
            }
        });
    }

    private void clearUIElements(){
        txtTitle.setText("");
        txtPayment.setText("");
        txtStarttime.setText("");
        txtLocation.setText("");
        txtDescription.setText("");
    }
}
