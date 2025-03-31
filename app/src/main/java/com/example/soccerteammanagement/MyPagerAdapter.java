package com.example.soccerteammanagement;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private String[] tabTitles = new String[]{"Teams", "Players", "Matches"};

    private TeamsFragment teamsFragment = new TeamsFragment();
    private PlayersFragment playersFragment = new PlayersFragment();
    private MatchesFragment matchesFragment = new MatchesFragment();

    public MyPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return teamsFragment;
            case 1:
                return playersFragment;
            case 2:
                return matchesFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
