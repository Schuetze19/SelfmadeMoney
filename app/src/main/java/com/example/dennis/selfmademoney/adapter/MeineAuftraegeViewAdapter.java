package com.example.dennis.selfmademoney.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dennis.selfmademoney.R;
import com.example.dennis.selfmademoney.model.Auftrag;

import java.util.ArrayList;

public class MeineAuftraegeViewAdapter extends RecyclerView.Adapter<MeineAuftraegeViewAdapter.MeineAuftraegeViewHolder> {

    private Context context;
    private ArrayList<Auftrag> auftragList = new ArrayList<Auftrag>();

    public MeineAuftraegeViewAdapter(Context context, ArrayList<Auftrag> auftragList) {
        this.context = context;
        this.auftragList = auftragList;
    }

    @Override
    public MeineAuftraegeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.meine_auftrage_row_item, parent,false);
        return new MeineAuftraegeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeineAuftraegeViewHolder holder, int position) {
        final Auftrag auftrag = auftragList.get(position);
        holder.txtTitel.setText(auftrag.getTitel());
        holder.txtVerguetung.setText(""+auftrag.getVerguetung());

        holder.imageViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Info => "+auftrag.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Delete => "+auftrag.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return auftragList.size();
    }

    public class MeineAuftraegeViewHolder extends RecyclerView.ViewHolder{

        public TextView txtTitel, txtVerguetung;
        public ImageView imageViewInfo, imageViewDelete;

        public MeineAuftraegeViewHolder(View itemView) {
            super(itemView);
            txtTitel = itemView.findViewById(R.id.txtTitel);
            txtVerguetung = itemView.findViewById(R.id.txtVerguetung);
            imageViewInfo = itemView.findViewById(R.id.imageViewInfo);
            imageViewDelete = itemView.findViewById(R.id.imageViewDelete);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
