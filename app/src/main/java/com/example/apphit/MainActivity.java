package com.example.apphit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.apphit.fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewpager);
        bottomNavigationView=findViewById(R.id.bottom);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.HomePage).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.ClassRoom).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.News).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.Personal).setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.HomePage:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.ClassRoom:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.News:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.Personal:
                    viewPager.setCurrentItem(3);
                    break;
            }
            return true;
        }
    });

    }
}