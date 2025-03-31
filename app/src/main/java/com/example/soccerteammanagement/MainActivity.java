package com.example.soccerteammanagement;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyPagerAdapter pagerAdapter;
    private EditText searchBar;
    private Button sortButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = findViewById(R.id.search_bar);
        sortButton = findViewById(R.id.sort_button);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                FilterAndSortable currentFragment = (FilterAndSortable) pagerAdapter.getItem(viewPager.getCurrentItem());
                currentFragment.filterData(s.toString());
            }
        });

        sortButton.setOnClickListener(v -> {
            FilterAndSortable currentFragment = (FilterAndSortable) pagerAdapter.getItem(viewPager.getCurrentItem());
            currentFragment.sortData();
        });
    }
}

