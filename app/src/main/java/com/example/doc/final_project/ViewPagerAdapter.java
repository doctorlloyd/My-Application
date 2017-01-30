package com.example.doc.final_project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Doc on 25-Jan-17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        {
            return new LoginFragment();
        }
//        else if(position == 1)
//            return new SplashFragment();
        else
            return new SplashFragment();
    }
    public void position(int pos){
        getItem(pos);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
