package com.example.doc.final_project.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doc.final_project.R;

import static com.example.doc.final_project.fragments.Clothing_Fragment.ARG_OBJECT;

/**
 * Created by Doc on 2017/02/01.
 */

public class Food_Fragment extends Fragment {
    SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.food_main_fragment,container,false);
//        Bundle args = getArguments();
//        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
//                Integer.toString(args.getInt(ARG_OBJECT)));
//        searchView.setBackgroundColor(Color.WHITE);
        return rootView;
    }
}
