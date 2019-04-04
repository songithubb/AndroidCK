package com.example.administrator.androidck;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PaperStateAdapter extends FragmentStatePagerAdapter{
    List<Fragment> fragments = new ArrayList<>();
    List<String> stringList = new ArrayList<>();

    public PaperStateAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        fragments.add(fragment);
        stringList.add(title);
    }
}
