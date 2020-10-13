package com.amtech.chama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

import com.amtech.chama.MainFragments.HomeFragment;
import com.amtech.chama.MainFragments.MembersFragment;
import com.amtech.chama.MainFragments.NotificationsFragment;
import com.amtech.chama.MainFragments.TransactionsFragment;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    private AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation =  findViewById(R.id.bottom_navigation);

        changeFragment(0);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Home", R.drawable.ic_baseline_home_grey);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Members", R.drawable.ic_baseline_people_grey);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Transactions", R.drawable.ic_baseline_bar_chart_grey);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem("Notifications", R.drawable.ic_baseline_notifications_grey);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item4);
        bottomNavigation.addItem(item5);
        bottomNavigation.setCurrentItem(0);
        bottomNavigation.setBehaviorTranslationEnabled(true);
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#ffffff"));
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);
        bottomNavigation.setAccentColor(Color.parseColor("#031A6E"));
        bottomNavigation.setInactiveColor(Color.parseColor("#CBCBDD"));
        bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#ff0000"));

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                if (position==0){
                    changeFragment(0);
                    wasSelected = true;
                }
                if (position==1){
                    changeFragment(1);
                    wasSelected = true;
                }
                if (position==2){
                    changeFragment(2);
                    wasSelected = true;
                }
                if (position==3){
                    changeFragment(3);
                    wasSelected = true;
                }

                return wasSelected;
            }
        });
    }

    private void changeFragment (int position){

        FragmentTransaction transaction;
        transaction = getSupportFragmentManager().beginTransaction();

        if (position == 0){
            transaction.replace(R.id.frameLayout, new HomeFragment());
            transaction.commit();
        }
        if (position == 1){
            transaction.replace(R.id.frameLayout, new MembersFragment());
            transaction.commit();
        }
        if (position == 2){
            transaction.replace(R.id.frameLayout, new TransactionsFragment());
            transaction.commit();
        }
        if (position == 3){
            transaction.replace(R.id.frameLayout, new NotificationsFragment());
            transaction.commit();
        }
    }
}