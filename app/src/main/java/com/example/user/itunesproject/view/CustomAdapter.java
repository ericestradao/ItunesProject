package com.example.user.itunesproject.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.itunesproject.R;
import com.example.user.itunesproject.model.ItunesPojo;
import com.squareup.picasso.Picasso;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
static String TAG = CustomAdapter.class.getSimpleName();
    ItunesPojo listData;

    public CustomAdapter(ItunesPojo listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout, viewGroup, false);
        return new CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: "+listData.getResults().size());
        Picasso.get().load(listData.getResults().get(i).getArtworkUrl60())
                .into(customViewHolder.iv_music);
        customViewHolder.tv_artist.setText(listData.getResults().get(i).getArtistName());
        customViewHolder.tv_title.setText(listData.getResults().get(i).getCollectionName());
        customViewHolder.tv_track_price.setText(listData.getResults().get(i).getTrackPrice().toString());
        //customViewHolder.iv_music.set
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
