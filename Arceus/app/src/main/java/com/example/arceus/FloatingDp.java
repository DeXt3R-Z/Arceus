package com.example.arceus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FloatingDp extends Fragment {


    public FloatingDp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View f= inflater.inflate(R.layout.fragment_floating_dp, container, false);
//        int recImage=getArguments().getInt("deepee");
//        ImageView mg=f.findViewById(R.id.DP);
//        mg.setImageResource(recImage);
        return f;
    }
}