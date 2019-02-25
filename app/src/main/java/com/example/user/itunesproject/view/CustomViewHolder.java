package com.example.user.itunesproject.view;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.itunesproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_track_price)
    TextView tv_track_price;
    @BindView(R.id.tv_artist)
    TextView tv_artist;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_music)
    ImageView iv_music;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }
}
