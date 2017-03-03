package com.aavjaav.qd.aavjaav.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aavjaav.qd.aavjaav.R;

/**
 * Created by Daniel on 3/3/2017.
 */

public class FeedbackFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_feedback, container, false);


        return root;
    }
}
