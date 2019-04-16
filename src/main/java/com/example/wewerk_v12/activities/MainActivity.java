package com.example.wewerk_v12.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.fragments.CreateFragment;
import com.example.wewerk_v12.fragments.DiscoverFragment;
import com.example.wewerk_v12.fragments.ProfileFragment;
import com.example.wewerk_v12.fragments.ProgramsFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigationView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intializing views
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        //keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DiscoverFragment()).commit();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_discover:
                            selectedFragment = new DiscoverFragment();
                            break;
                        case R.id.nav_create:
                            selectedFragment = new CreateFragment();
                            break;
                        case R.id.nav_programs:
                            selectedFragment = new ProgramsFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };


}
