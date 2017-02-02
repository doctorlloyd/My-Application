package com.example.doc.final_project.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doc.final_project.R;

/**
 * Created by Doc on 2017/02/01.
 */

public class Clothing_Fragment extends Fragment{

    public static final String ARG_OBJECT = "object";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.clothing_main_fragment,container,false);
//        Bundle args = getArguments();
//        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
//                Integer.toString(args.getInt(ARG_OBJECT)));
        return rootView;
    }
}
