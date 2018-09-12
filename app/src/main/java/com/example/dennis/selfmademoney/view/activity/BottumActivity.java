package com.example.dennis.selfmademoney.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.dennis.selfmademoney.R;
import com.example.dennis.selfmademoney.adapter.CollectionPagerAdapter;

public class BottumActivity extends AppCompatActivity {

    private CollectionPagerAdapter collectionPagerAdapter;
    private ViewPager viewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_startseite:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_auftrag:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_meineAuftraege:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_profil:
                    viewPager.setCurrentItem(3);
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

        viewPager = (ViewPager) findViewById(R.id.pager);
        collectionPagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(collectionPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                navigation.getMenu().getItem(position).setChecked(true);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}