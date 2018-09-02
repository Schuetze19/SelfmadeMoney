package com.example.dennis.selfmademoney;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dennis.selfmademoney.dao.UserDao;
import com.example.dennis.selfmademoney.model.User;
import com.example.dennis.selfmademoney.util.ClipboardUtil;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class ProfilActivity extends AppCompatActivity {

    private CircleImageView profilBild;
    private TextView txtUsername, txtEmail, txtMitgliedSeit, txtFullName, txtPlace;
    private EditText editDescription;
    private ImageView emailToClip, usernameToClip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        profilBild = (CircleImageView) findViewById(R.id.profilBild);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        txtMitgliedSeit = (TextView) findViewById(R.id.txtMitgliedSeit);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        emailToClip = (ImageView) findViewById(R.id.emailToClip);
        usernameToClip = (ImageView) findViewById(R.id.usernameToClip);
        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtPlace = (TextView) findViewById(R.id.txtPlace);
        editDescription = (EditText) findViewById(R.id.editDescription);

        final User user = new UserDao().findById(2);
        txtUsername.setText(user.getUsername());
        txtMitgliedSeit.setText(user.getMitgliedSeit());
        txtEmail.setText(user.getEmail());
        txtFullName.setText(user.getFullName() + " / " + user.getGeborenAm());
        txtPlace.setText(user.getWohnort());
        editDescription.setText(user.getBeschreibung());
        emailToClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardUtil.copyToClipboard(ProfilActivity.this,"email", user.getEmail());
                Toast.makeText(ProfilActivity.this,user.getEmail()+" kopiert", Toast.LENGTH_SHORT).show();
            }
        });

        usernameToClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardUtil.copyToClipboard(ProfilActivity.this,"username", user.getUsername());
                Toast.makeText(ProfilActivity.this,user.getUsername()+" kopiert", Toast.LENGTH_SHORT).show();
            }
        });

        Picasso.get()
                .load(R.drawable.ic_portrait_white_48dp)
                .placeholder(R.drawable.ic_portrait_white_48dp)
                .error(R.drawable.ic_portrait_white_48dp)
                .transform(new CropCircleTransformation())
                .into(profilBild);
    }

}
