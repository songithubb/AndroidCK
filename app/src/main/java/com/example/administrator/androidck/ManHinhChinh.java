package com.example.administrator.androidck;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ManHinhChinh extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);

        onIt();

        tabLayout.setupWithViewPager(viewPager);
        PaperStateAdapter adapter = new PaperStateAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_List_Sach(),"ListSach");
        adapter.addFragment(new FragmentListMuonSach(),"ListMuonSach");
        viewPager.setAdapter(adapter);

    }

    private void onIt() {

        tabLayout = (TabLayout)findViewById(R.id.mTabLayout);
        viewPager = (ViewPager)findViewById(R.id.mViewPager);
    }
}
