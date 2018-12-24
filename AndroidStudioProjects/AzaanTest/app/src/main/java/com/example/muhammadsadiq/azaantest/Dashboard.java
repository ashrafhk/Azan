package com.example.muhammadsadiq.azaantest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


public class Dashboard extends AppCompatActivity {

    private TextView mTextMessage;
    TabLayout tab;
    ViewPager viewPager;
    PagersAdapter pagersAdapter;
    BottomNavigationView mBottomNavigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent First = new Intent(Dashboard.this, Dashboard.class);
                    startActivity(First);
                    break;

                case R.id.navigation_qibla:
                    Intent Second = new Intent(Dashboard.this, Qibla.class);
                    startActivity(Second);
                    break;

                case R.id.navigation_book:
                    Intent Third = new Intent(Dashboard.this, Book.class);
                    startActivity(Third);
                    break;

                case R.id.navigation_tasbih:
                    Intent Fourth = new Intent(Dashboard.this, Tasbih.class);
                    startActivity(Fourth);
                    break;

            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mTextMessage = (TextView) findViewById(R.id.message);
        mBottomNavigation = (BottomNavigationView) findViewById(R.id.navigation);

        mBottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager = (ViewPager)findViewById(R.id.pagers);
        pagersAdapter = new com.example.muhammadsadiq.azaantest.PagersAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagersAdapter);

        tab = (TabLayout)findViewById(R.id.tabs_layout);
        tab.setupWithViewPager(viewPager);
        setUpWithTab();
    }

    private void setUpWithTab() {
        tab.getTabAt(0).setText("Prayer");
        tab.getTabAt(1).setText("Calender");
        tab.getTabAt(2).setText("Time Table");
    }
}
