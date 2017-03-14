package com.aavjaav.qd.aavjaav.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aavjaav.qd.aavjaav.R;
import com.aavjaav.qd.aavjaav.model.pojo.searchcar.SearchCarResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CarsResultAdapter extends RecyclerView.Adapter<CarsResultAdapter.CarResultHolder> {

    private ArrayList<SearchCarResponse.Result> mCars;
    private Context mContext;

    public CarsResultAdapter(ArrayList<SearchCarResponse.Result> mCars, Context mContext) {
        this.mCars = mCars;
        this.mContext = mContext;
    }

    public void swap(ArrayList<SearchCarResponse.Result> list) {
        if (mCars != null) {
            mCars.clear();
            mCars.addAll(list);
        } else {
            mCars = list;
        }
        notifyDataSetChanged();
    }

    @Override
    public CarResultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.view_car_row, parent, false);
        return new CarResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CarResultHolder holder, int position) {
        SearchCarResponse.Result car = mCars.get(position);
        holder.mCarType.setText(car.getVenderCarName());
        holder.mCarName.setText(car.getVehicleCompnayName());
        holder.mCarPrice.setText(car.getMbill() + " EUR");
        holder.mVendorName.setText(car.getVendorName());
        Picasso.with(mContext).load(car.getUrl()).placeholder(R.drawable.ic_placeholder).into(holder.mCarImage);
    }

    @Override
    public int getItemCount() {
        return mCars.size();
    }

    class CarResultHolder extends RecyclerView.ViewHolder {
        private TextView mCarName;
        private TextView mCarType;
        private TextView mCarPrice;
        private TextView mVendorName;
        private ImageView mCarImage;

        public CarResultHolder(View itemView) {
            super(itemView);
            mCarName = (TextView) itemView.findViewById(R.id.car_row_car_name);
            mCarType = (TextView) itemView.findViewById(R.id.car_row_car_type);
            mCarPrice = (TextView) itemView.findViewById(R.id.car_row_car_price);
            mCarImage = (ImageView) itemView.findViewById(R.id.car_row_car_image);
            mVendorName = (TextView) itemView.findViewById(R.id.car_row_car_vendor);


        }
    }
}
