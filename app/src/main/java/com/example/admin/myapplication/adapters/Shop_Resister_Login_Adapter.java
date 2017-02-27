package com.example.admin.myapplication.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.myapplication.fragments.LoginFragment;
import com.example.admin.myapplication.fragments.ShopRegistration;
import com.example.doc.final_project.R;

/**
 * Created by Doc on 2017/02/27.
 */

public class Shop_Resister_Login_Adapter extends FragmentStatePagerAdapter
{
    private Context context;
    public Shop_Resister_Login_Adapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new LoginFragment();
        }else {
            return new ShopRegistration();
        }

    }
    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getResources().getString(R.string.title_shop_login);
        } else{
            return context.getResources().getString(R.string.title_shop_signup);
        }
    }
}
