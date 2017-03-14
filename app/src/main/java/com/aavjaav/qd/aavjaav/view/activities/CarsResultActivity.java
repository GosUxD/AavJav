package com.aavjaav.qd.aavjaav.view.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.aavjaav.qd.aavjaav.R;
import com.aavjaav.qd.aavjaav.model.adapter.CarsResultAdapter;
import com.aavjaav.qd.aavjaav.model.pojo.mybookings.BookingsResponse;
import com.aavjaav.qd.aavjaav.model.pojo.searchcar.SearchCarResponse;
import com.aavjaav.qd.aavjaav.model.storage.SingletonStorage;
import com.aavjaav.qd.aavjaav.presenter.SearchCarContract;
import com.aavjaav.qd.aavjaav.presenter.SearchCarPresenter;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class CarsResultActivity extends AppCompatActivity implements SearchCarContract.SearchCarView {

    public static final String EXTRA_CITY = "city_extra";
    private String mCity;
    private SearchCarPresenter mPresenter;
    private RecyclerView mRecycler;
    private ArrayList<SearchCarResponse.Result> mCars;
    private CarsResultAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
        mCars = SingletonStorage.getInstance().getCarResults();
        mAdapter = new CarsResultAdapter(mCars, this);

        mPresenter = new SearchCarPresenter(this, this);
        mCity = getIntent().getStringExtra(EXTRA_CITY);
        mPresenter.searchCar(mCity);

        mRecycler = (RecyclerView) findViewById(R.id.activity_cars_result_recycler_view);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(mAdapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return (super.onOptionsItemSelected(item));

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onSuccess(List<SearchCarResponse.Result> result) {
        mAdapter.swap((ArrayList<SearchCarResponse.Result>) result);
    }

    @Override
    public void onFailure() {
        Toast.makeText(this, "There's been an error. Try again.", Toast.LENGTH_SHORT).show();
        finish();
    }
}
