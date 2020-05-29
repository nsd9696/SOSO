package org.techtown.soso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_menu;
    Button btn_person;
    Button btn_find;
    Button login;

    TabLayout mTablayout;
    ViewPager mViewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btn_menu=(Button)findViewById(R.id.btn_menu);
        btn_person=(Button)findViewById(R.id.btn_person);
        btn_find=(Button)findViewById(R.id.btn_find);

        btn_person.setOnClickListener(this);
        btn_find.setOnClickListener(this);
        btn_menu.setOnClickListener(this);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTablayout = (TabLayout) findViewById(R.id.tab);

        mTablayout.setupWithViewPager(mViewpager);
        NewAdapter newAdapter = new NewAdapter(getSupportFragmentManager());
        mViewpager.setAdapter(newAdapter);

    }

    @Override
    public void onClick(View v) {
        if(v==btn_find) {
        }
        else if (v==btn_person){
            Intent intent=new Intent(FirstActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        else if(v==btn_menu) {

        }

    }

    public class NewAdapter extends FragmentPagerAdapter {

        public NewAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    MainFragment mainFragment1=new MainFragment();
                    return mainFragment1;
                case 1:
                    MainFragment mainFragment2=new MainFragment();
                    return mainFragment2;
                case 2:
                    MainFragment mainFragment3=new MainFragment();
                    return mainFragment3;
                case 3:
                    MainFragment mainFragment4=new MainFragment();
                    return mainFragment4;
            }
            return null;
        }


        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "과일";
                case 1:
                    return "야채";
                case 2:
                    return "제철";
                case 3:
                    return "농가";
            }
            return null;
        }

    }
}
