package com.example.admin.myapplication.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.doc.final_project.R;
import com.example.admin.myapplication.fragments.SplashFragment;
/**
 * Created by Doc on 2017/02/15.
 */

public class ViewPagerAdapterLogin extends FragmentStatePagerAdapter {
    private Context context;
    public ViewPagerAdapterLogin(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        return new SplashFragment();
    }
    @Override
    public int getCount() {
        return 1;
    }
    @Override
    public CharSequence getPageTitle(int position) {
            return context.getResources().getString(R.string.title_splash_fragment);
    }
}
