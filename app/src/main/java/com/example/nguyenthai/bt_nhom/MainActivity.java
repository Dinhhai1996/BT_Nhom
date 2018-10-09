package com.example.nguyenthai.bt_nhom;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    Toolbar toolbar;
    TabLayout tabLayout;

    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new ListFragment());
        viewPagerAdapter.addFragment(new GridFragment());

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.getTabAt(0).setText("List view");
//        tabLayout.getTabAt(1).setText("Grid view");
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_view_list_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_grid_on_black_24dp);

    }
}
