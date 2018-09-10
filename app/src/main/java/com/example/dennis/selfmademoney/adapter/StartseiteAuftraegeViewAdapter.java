package com.example.dennis.selfmademoney.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dennis.selfmademoney.R;
import com.example.dennis.selfmademoney.model.Auftrag;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class StartseiteAuftraegeViewAdapter extends RecyclerView.Adapter<StartseiteAuftraegeViewAdapter.StartseiteAuftraegeViewHolder> {

    private Context context;
    private ArrayList<Auftrag> auftragList = new ArrayList<Auftrag>();

    public StartseiteAuftraegeViewAdapter(@NonNull Context context, @NonNull ArrayList<Auftrag> auftragList){
        this.context = context;
        this.auftragList = auftragList;
    }

    @Override
    public StartseiteAuftraegeViewAdapter.StartseiteAuftraegeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.startseite_auftraege_row_item, parent,false);
        return new StartseiteAuftraegeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StartseiteAuftraegeViewAdapter.StartseiteAuftraegeViewHolder holder, int position) {
        final Auftrag auftrag = auftragList.get(position);
        holder.txtUsername.setText("Username");
        holder.txtErstellungsdatum.setText(new SimpleDateFormat("dd.MM.yyyy").format(auftrag.getAuftragsstart()));
        holder.txtBeschreibung.setText(auftrag.getBeschreibung());
        holder.txtVerguetung.setText(String.format("%.2f €", auftrag.getVerguetung()));
        holder.txtWohnort.setText("Wohnort");

        holder.btnAnfrageStellen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.btnIgnorieren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return auftragList.size();
    }

    public class StartseiteAuftraegeViewHolder extends RecyclerView.ViewHolder{

        public TextView txtUsername, txtErstellungsdatum, txtBeschreibung, txtVerguetung, txtWohnort;
        public Button btnAnfrageStellen, btnIgnorieren;

        public StartseiteAuftraegeViewHolder(View itemView) {
            super(itemView);
            txtUsername = itemView.findViewById(R.id.txtUsername);
            txtErstellungsdatum = itemView.findViewById(R.id.txtErstellungsdatum);
            txtBeschreibung = itemView.findViewById(R.id.txtBeschreibung);
            txtVerguetung = itemView.findViewById(R.id.txtVerguetung);
            txtWohnort = itemView.findViewById(R.id.txtWohnort);
            btnAnfrageStellen = itemView.findViewById(R.id.btnAnfrageStellen);
            btnIgnorieren = itemView.findViewById(R.id.btnIgnorieren);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
