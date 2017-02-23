package com.aavjaav.qd.aavjaav.view.fragments.MyAccountFragmentTabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aavjaav.qd.aavjaav.R;


public class PaymentDetailsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_payment_details, container, false);


        return root;
    }


    public static PaymentDetailsFragment newInstance() {

        Bundle args = new Bundle();

        PaymentDetailsFragment fragment = new PaymentDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
