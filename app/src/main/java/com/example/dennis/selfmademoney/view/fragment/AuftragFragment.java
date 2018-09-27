package com.example.dennis.selfmademoney.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.dennis.selfmademoney.R;
import com.example.dennis.selfmademoney.controller.AuftragController;

import java.util.Calendar;

public class AuftragFragment extends Fragment {

    private Button btnCreate;
    private Button btnBack;
    private Button btnCancel;
    private EditText txtTitle;
    private EditText txtPayment;
    private DatePicker datePicker;
    private EditText txtLocation;
    private EditText txtDescription;
    private AuftragController auftragController = new AuftragController();
    private final int TAGE = 31;
    private String userId = "";
    private static AuftragFragment fragment;

    public AuftragFragment () {}

    public static AuftragFragment newInstance() {
        if (fragment == null) {
            fragment = new AuftragFragment();
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
        View view = inflater.inflate(R.layout.fragment_auftrag, container, false);
        this.btnCreate = (Button) view.findViewById(R.id.btnCreate);
        this.btnBack = (Button) view.findViewById(R.id.btnBack);
        this.btnCancel = (Button) view.findViewById(R.id.btnCancel);
        this.txtTitle = (EditText) view.findViewById(R.id.txtTitle);
        this.txtPayment = (EditText) view.findViewById(R.id.txtPayment);
        this.datePicker = (DatePicker) view.findViewById(R.id.datePicker);
        this.datePicker.updateDate(Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        this.txtLocation = (EditText) view.findViewById(R.id.txtLocation);
        this.txtDescription = (EditText) view.findViewById(R.id.txtDescription);
        userId = getActivity().getIntent().getStringExtra(getString(R.string.intent_userId));
        addButtonListener();
        return view;
    }

    private void addButtonListener(){
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        datePicker.setMinDate(System.currentTimeMillis() - 100);
        calendar.add(Calendar.DATE, TAGE);
        datePicker.setMaxDate(calendar.getTimeInMillis());

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar choosenAuftragsstart = Calendar.getInstance();
                choosenAuftragsstart.setTimeInMillis(0);
                choosenAuftragsstart.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                auftragController.createAuftrag(
                        txtTitle.getText().toString(), txtDescription.getText().toString(), choosenAuftragsstart.getTime(),
                       Double.parseDouble(txtPayment.getText().toString()), txtLocation.getText().toString(),userId);
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
        datePicker.updateDate(Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        txtLocation.setText("");
        txtDescription.setText("");
    }
}
