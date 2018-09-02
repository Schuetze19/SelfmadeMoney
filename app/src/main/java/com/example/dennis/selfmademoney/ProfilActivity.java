package com.example.dennis.selfmademoney;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dennis.selfmademoney.dao.UserDao;
import com.example.dennis.selfmademoney.model.User;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class ProfilActivity extends AppCompatActivity {

    private CircleImageView profilBild;
    private TextView txtUsername, txtEmail, txtMitgliedSeit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        profilBild = (CircleImageView) findViewById(R.id.profilBild);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        txtMitgliedSeit = (TextView) findViewById(R.id.txtMitgliedSeit);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        User user = new UserDao().findById(1);
        txtUsername.setText(user.getUsername());
        txtMitgliedSeit.setText(user.getMitgliedSeit());
        txtEmail.setText(user.getEmail());

        Picasso.get()
                .load(R.drawable.ic_portrait_white_48dp)
                .placeholder(R.drawable.ic_portrait_white_48dp)
                .error(R.drawable.ic_portrait_white_48dp)
                .transform(new CropCircleTransformation())
                .into(profilBild);
    }

}
