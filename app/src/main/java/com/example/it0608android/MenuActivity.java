package com.example.it0608android;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.it0608android.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        viewPager2 = findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setupViewPager();

        // bat su kien click vao cac tab icon
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.home_menu){
                    viewPager2.setCurrentItem(0);
                } else if (menuItem.getItemId() == R.id.budget_menu) {
                    viewPager2.setCurrentItem(1);
                } else if (menuItem.getItemId() == R.id.setting_menu) {
                    viewPager2.setCurrentItem(2);
                } else {
                    viewPager2.setCurrentItem(0);
                }
                return true;
            }
        });
    }

    // setup viewpager
    private void setupViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(viewPagerAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0) {
                    bottomNavigationView.getMenu().findItem(R.id.home_menu).setChecked(true);
                } else if (position == 1) {
                    bottomNavigationView.getMenu().findItem(R.id.budget_menu).setChecked(true);
                } else if (position == 2) {
                    bottomNavigationView.getMenu().findItem(R.id.setting_menu).setChecked(true);
                } else {
                    bottomNavigationView.getMenu().findItem(R.id.home_menu).setChecked(true);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.home_menu) {
            viewPager2.setCurrentItem(0);
        } else if (itemId == R.id.budget_menu) {
            viewPager2.setCurrentItem(1);
        } else if (itemId == R.id.setting_menu) {
            viewPager2.setCurrentItem(2);
        } else {
            viewPager2.setCurrentItem(0);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
