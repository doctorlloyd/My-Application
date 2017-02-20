package com.example.admin.myapplication.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.doc.final_project.R;
import com.example.admin.myapplication.fragments.LoginFragment;
import com.example.admin.myapplication.fragments.SignUpFragment;
import com.example.admin.myapplication.fragments.SplashFragment;

/**
 * Created by Admin on 2017/02/15.
 */

public class ViewPagerAdapterLogin extends FragmentStatePagerAdapter {
    private Context context;
//    private ArrayList<Fragment> fragments = new ArrayList<>();
    public ViewPagerAdapterLogin(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
//        if(position==0)
//        {
//            return new LoginFragment();
//        }else
        if(position ==0)
        {
            return new SplashFragment();
        }else {
            return new SignUpFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        if(position==0)
//        {
//            return context.getResources().getString(R.string.title_login_fragment);
//        }else
        if(position ==0)
        {
            return context.getResources().getString(R.string.title_splash_fragment);
        }else {
            return context.getResources().getString(R.string.title_sign_up_fragment);
        }
    }
}
