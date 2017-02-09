package com.makroid.musicplayer.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.makroid.musicplayer.SongFragment;


public class SongPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "songs", "album", "artist","playlist"};
    private Context context;

    public SongPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        return SongFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
