package com.aavjaav.qd.aavjaav.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aavjaav.qd.aavjaav.R;


public class BookCarFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_car, container, false);
        
        
        
        return root;
    }


    public static BookCarFragment newInstance() {
        
        Bundle args = new Bundle();
        
        BookCarFragment fragment = new BookCarFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
