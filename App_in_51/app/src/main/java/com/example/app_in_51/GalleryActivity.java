package com.example.app_in_51;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;


public class GalleryActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Fragment currentFragment;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        configNavigation();
        Intent intent=getIntent();
        userName=intent.getStringExtra(MainActivity.USERNAME_KEY);
        currentFragment = new MyGalleryFragment();
        addNavigationListener();
    }

    private void configNavigation() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void addNavigationListener(){
        navigationView = findViewById(R.id.nav_view);
        View headerLayout=navigationView.getHeaderView(0);
        TextView text=headerLayout.findViewById(R.id.username);
        text.setText(userName);
        View includedLayout=findViewById(R.id.gallery_content);
        final View frameContainer=includedLayout.findViewById(R.id.main_frame_container);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction transaction=fm.beginTransaction();
                if(menuItem.getItemId() == R.id.nav_paintings){
                    currentFragment = new PaintingsFragment();
                    transaction.replace(frameContainer.getId(),currentFragment);
                    transaction.commit();
                }
                else if(menuItem.getItemId() == R.id.nav_sculptures){
                    currentFragment = new SculpturesFragment();
                    transaction.replace(frameContainer.getId(),currentFragment);
                    transaction.commit();
                }
                else if(menuItem.getItemId() == R.id.nav_sell){
                    currentFragment = new SellArtFragment();
                    transaction.replace(frameContainer.getId(),currentFragment);
                    transaction.commit();
                }
                else if(menuItem.getItemId() == R.id.nav_buy){
                    currentFragment = new BuyArtFragment();
                    transaction.replace(frameContainer.getId(),currentFragment);
                    transaction.commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}