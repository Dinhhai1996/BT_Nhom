package com.example.nguyenthai.bt_nhom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by NGUYENTHAI on 2/3/2018.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> arrayList = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    public void addFragment(Fragment fragment){
        arrayList.add(fragment);
    }
}
