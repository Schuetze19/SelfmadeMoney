package com.example.dennis.selfmademoney.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.dennis.selfmademoney.R;
import com.example.dennis.selfmademoney.view.fragment.AuftragFragment;
import com.example.dennis.selfmademoney.view.fragment.MeineAuftrageFragment;
import com.example.dennis.selfmademoney.view.fragment.ProfilFragment;
import com.example.dennis.selfmademoney.view.fragment.StartseiteFragment;

public class BottumActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_startseite:
                    switchToFragment(R.id.container, new StartseiteFragment());
                    return true;
                case R.id.navigation_auftrag:
                    switchToFragment(R.id.container, new AuftragFragment());
                    return true;
                case R.id.navigation_meineAuftraege:
                    switchToFragment(R.id.container, new MeineAuftrageFragment());
                    return true;
                case R.id.navigation_profil:
                    switchToFragment(R.id.container, new ProfilFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottum);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void switchToActivity(Activity startActivity, Class finishActivity){
        Intent intent = new Intent(startActivity, finishActivity);
        startActivity(intent);
    }

    private void switchToFragment(int container, Fragment targetFragment) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(container, targetFragment).commit();
    }
}
