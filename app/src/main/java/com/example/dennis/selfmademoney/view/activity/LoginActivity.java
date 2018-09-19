package com.example.dennis.selfmademoney.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dennis.selfmademoney.R;
import com.example.dennis.selfmademoney.dao.UserDao;
import com.example.dennis.selfmademoney.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private EditText txtPassword, txtEmail;
    private Button btnRegister, btnLogin;
    private SharedPreferences sharedPref;
    private final String sharedpreferences_email = "email";
    private final String sharedpreferences_password = "password";
    private final String sharedpreferences_userId = "userId";
    private final UserDao userDao = new UserDao();
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        registerListener();
    }

    private void registerListener(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = txtEmail.getText().toString().trim();
                final String password = txtPassword.getText().toString().trim();
                if(validateInputWithErrors(email, password)){
                    signIn(email, password);
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Weiteres Register Fragment erstellen
                //Felder wie auf der Seite Profil zu sehen sind auch Registrierungsfelder
                // mAuth.createUserWithEmailAndPassword(txtEmail.getText().toString(), txtPassword.getText().toString());
            }
        });
    }

    private void signIn(@NonNull String email, @NonNull String password){
        if(!email.isEmpty() && email.length() >= 4 && email.contains("@")
                && !password.isEmpty() && password.length() >= 6){

            userDao.getDatabaseReference().orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String userStr = dataSnapshot.getValue().toString();
                    String userPassword = userStr.substring(userStr.indexOf(", password=")+11);
                    userPassword = userPassword.substring(0,userPassword.indexOf(","));
                    if(password.trim().equalsIgnoreCase(userPassword.trim())) {
                        String userId = userStr.substring(1,userStr.indexOf("="));
                        if (sharedPref != null) {
                            final SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString(sharedpreferences_email, email);
                            editor.putString(sharedpreferences_password, password);
                            editor.putString(sharedpreferences_userId, userId);
                            editor.commit();
                        }
                        Intent intent = new Intent(LoginActivity.this, BottumActivity.class);
                        intent.putExtra(getString(R.string.intent_userId), userId);
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // User nicht gefunden oder email und password falsch.
                }
            });
        }
    }

    private boolean validateInputWithErrors(String email, String password){
        if(email.isEmpty() || email.length() <= 4 || !email.contains("@")){
            txtEmail.setError("Invalid E-Mail Adress");
            return false;
        }else if(password.isEmpty() || password.length() < 6) {
            txtPassword.setError("The Password need at least 6 characters");
            return false;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPref = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if(sharedPref != null && sharedPref.getString(sharedpreferences_email,null) != null){
            signIn(sharedPref.getString(sharedpreferences_email,null), sharedPref.getString(sharedpreferences_password,null));
        }
    }
}
