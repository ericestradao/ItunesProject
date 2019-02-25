package com.example.user.itunesproject.presenter;

import android.content.Context;
import android.util.Log;

import com.example.user.itunesproject.MainActivity;
import com.example.user.itunesproject.model.ItunesInterfaceApi;
import com.example.user.itunesproject.model.ItunesPojo;
import com.example.user.itunesproject.view.ViewContract;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter implements PresenterConctract{
    final String TAG = MainActivity.class.getSimpleName();

    ViewContract viewContract;
    Context context;
    final String BASE_URL = "https://itunes.apple.com/";
    Retrofit retrofit;

    public Presenter(ViewContract viewContract) {

        this.viewContract = viewContract;
        this.context = (Context) viewContract;
    }

    @Override
    public void initRetrofit() {
        //todo retrofit call
//        Gson gson = new Gson
         retrofit = new  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void getRockMusic() {
    //todo after getting the data from retrofit call
        //todo send data back to teh view
        //todo like viewContract.populateRockMusic(data)

        ItunesInterfaceApi interfaceApi = retrofit.create(ItunesInterfaceApi.class);
        interfaceApi.getMusic("rock","music","song","50").enqueue(new Callback<ItunesPojo>() {
            @Override
            public void onResponse(Call<ItunesPojo> call, Response<ItunesPojo> response) {
                if(response.isSuccessful())
                    viewContract.populateRockMusic(response.body());

            }

            @Override
            public void onFailure(Call<ItunesPojo> call, Throwable t) {
                    //do the viewContract on fail
                //snackbar or toast
                Log.d(TAG, "Fallo");
            }
        });
    }

    @Override
    public void getClassicMusic() {

    }

    @Override
    public void getPopMusic() {

    }
}
