package com.example.muhammadsadiq.azaantest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagersAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList = new ArrayList<Fragment>();

    public PagersAdapter(FragmentManager fm) {
        super(fm);
        fragmentList.add(new PrayerFrag());
        fragmentList.add(new CalenderHist());
        fragmentList.add(new SalahTime());
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
