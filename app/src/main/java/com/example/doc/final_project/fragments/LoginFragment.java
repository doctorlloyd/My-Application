package com.example.doc.final_project.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.doc.final_project.R;
import com.example.doc.final_project.activities.HomeScreen;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
/**
 * Created by Doc on 2017/02/01.
 */
public class LoginFragment extends Fragment{
    private FirebaseAuth mfirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;
    //ends fire\

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.login_fragment, container, false);
        return rootView;
    }

}
