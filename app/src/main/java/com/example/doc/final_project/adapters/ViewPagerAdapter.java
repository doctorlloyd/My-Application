package com.example.doc.final_project.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.doc.final_project.R;
import com.example.doc.final_project.fragments.Clothing_Fragment;
import com.example.doc.final_project.fragments.Food_Fragment;
import com.example.doc.final_project.fragments.Furniture_Fragment;

/**
 * Created by Doc on 25-Jan-17.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        {
            return new Furniture_Fragment();
        }
        else if(position == 1)
            return new Food_Fragment();
        else
            return new Clothing_Fragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getResources().getString(R.string.title_furniture_fragment);
        } else if (position == 1) {
            return context.getResources().getString(R.string.title_food_fragment);
        } else {
            return context.getResources().getString(R.string.title_clothing_fragment);
        }
    }
}
