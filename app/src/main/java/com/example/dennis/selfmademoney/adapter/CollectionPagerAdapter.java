package com.example.dennis.selfmademoney.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.dennis.selfmademoney.view.fragment.AuftragFragment;
import com.example.dennis.selfmademoney.view.fragment.MeineAuftrageFragment;
import com.example.dennis.selfmademoney.view.fragment.ProfilFragment;
import com.example.dennis.selfmademoney.view.fragment.StartseiteFragment;

public class CollectionPagerAdapter extends FragmentPagerAdapter {

    public CollectionPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return StartseiteFragment.newInstance();
            case 1:
                return AuftragFragment.newInstance();
            case 2:
                return MeineAuftrageFragment.newInstance();
            case 3:
                return ProfilFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
