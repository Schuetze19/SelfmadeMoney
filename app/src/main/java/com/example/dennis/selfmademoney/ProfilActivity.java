package com.example.dennis.selfmademoney;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class ProfilActivity extends AppCompatActivity {

    private CircleImageView profilBild;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        profilBild = (CircleImageView) findViewById(R.id.profilBild);

        Picasso.get()
                .load(R.drawable.ic_portrait_white_48dp)
                .placeholder(R.drawable.ic_portrait_white_48dp)
                .error(R.drawable.ic_portrait_white_48dp)
                .transform(new CropCircleTransformation())
                .into(profilBild);
    }

}
