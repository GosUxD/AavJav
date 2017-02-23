package com.aavjaav.qd.aavjaav.view.fragments.MyAccountFragmentTabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aavjaav.qd.aavjaav.R;
import com.aavjaav.qd.aavjaav.view.activities.AccountDetailsActivity;
import com.aavjaav.qd.aavjaav.view.activities.ChangePasswordActivity;

/**
 * Created by Daniel on 2/22/2017.
 */

public class AccountDetailsFragment extends Fragment {

    LinearLayout mChangePassword;
    LinearLayout mAccountDetails;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_account_details, container ,false);

        mChangePassword = (LinearLayout) root.findViewById(R.id.fragment_account_change_password);
        mChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePassword = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivity(changePassword);
            }
        });

        mAccountDetails = (LinearLayout) root.findViewById(R.id.fragment_account_details);
        mAccountDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accountDetails = new Intent(getActivity(), AccountDetailsActivity.class);
                startActivity(accountDetails);
            }
        });



        return root;
    }


    public static AccountDetailsFragment newInstance() {

        Bundle args = new Bundle();

        AccountDetailsFragment fragment = new AccountDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
