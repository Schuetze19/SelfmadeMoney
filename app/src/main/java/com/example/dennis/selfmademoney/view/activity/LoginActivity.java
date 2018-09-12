package com.example.dennis.selfmademoney.view.activity;

import com.example.dennis.selfmademoney.R;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText txtPassword, txtEmail;
    private Button btnRegister, btnLogin;

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
                new Authentifizierungstask().execute(txtEmail.getText().toString(),txtPassword.getText().toString());
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Weiteres Register Fragment erstellen
                //Felder wie auf der Seite Profil zu sehen sind auch Registrierungsfelder
            }
        });
    }

    private class Authentifizierungstask extends AsyncTask<String,Void,Boolean> {

        @Override
        protected void onPreExecute() {
            // Wird unter anderem genutzt, um im UI-Thread eine ProgressBar zu initialisieren
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            if(strings == null || strings.length < 2)
                return Boolean.FALSE;
            final String email = strings[0];
            final String passwort = strings[1];
            return Boolean.TRUE;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            // Wird unter anderem genutzt, um im UI-Thread die ProgressBar zu updaten
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result == Boolean.TRUE) {
                startActivity(new Intent(LoginActivity.this, BottumActivity.class));
            }
        }
    }

}
