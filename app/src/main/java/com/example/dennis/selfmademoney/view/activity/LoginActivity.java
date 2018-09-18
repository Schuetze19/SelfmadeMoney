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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText txtPassword, txtEmail;
    private Button btnRegister, btnLogin;
    private SharedPreferences sharedPref;
    private final String sharedpreferences_email = "email";
    private final String sharedpreferences_password = "password";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        registerListener();
        sharedPref = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if(sharedPref != null && sharedPref.getString(sharedpreferences_email,null) != null){
            signIn(sharedPref.getString(sharedpreferences_email,null), sharedPref.getString(sharedpreferences_password,null));
        }
    }

    private void registerListener(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = txtEmail.getText().toString().trim();
                final String password = txtPassword.getText().toString().trim();
                if(email.isEmpty() || email.length() <= 4 || !email.contains("@")){
                    txtEmail.setError("Invalid E-Mail Adress");
                }else if(password.isEmpty() || password.length() < 6) {
                    txtPassword.setError("The Password need at least 6 characters");
                }else{
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
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        if(sharedPref != null){
                            final SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString(sharedpreferences_email, email);
                            editor.putString(sharedpreferences_password, password);
                            editor.commit();
                        }
                        startActivity(new Intent(LoginActivity.this, BottumActivity.class));
                    }else{
                        Log.v("VERBOSE",task.getException().getMessage());
                        Log.v("VERBOSE",task.getResult().toString());
                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){

        }
    }
}
