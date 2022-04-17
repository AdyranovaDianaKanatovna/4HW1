package com.example.a4hw1;

import android.os.Bundle;

import com.example.a4hw1.ui.dashboard.DashboardFragment;
import com.example.a4hw1.ui.home.HomeFragment;
import com.example.a4hw1.ui.notifications.NotificationsFragment;
import com.example.a4hw1.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.a4hw1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        binding.navView.setOnItemSelectedListener(item -> {

        switch (item.getItemId()){
            case R.id.navigation_home:
                replaceFragment(new HomeFragment());
                break;
            case R.id.navigation_dashboard:
                replaceFragment(new DashboardFragment());
                break;
            case R.id.navigation_notifications:
                replaceFragment(new NotificationsFragment());
                break;
            case R.id.navigation_profile:
                replaceFragment(new ProfileFragment());
                break;
        }
            return true;
        });


    }
private void replaceFragment(Fragment fragment){
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.nav_host_fragment_activity_main,fragment);
    fragmentTransaction.commit();
}
}