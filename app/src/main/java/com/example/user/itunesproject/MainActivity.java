package com.example.user.itunesproject;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.user.itunesproject.model.ItunesPojo;
import com.example.user.itunesproject.presenter.Presenter;
import com.example.user.itunesproject.view.ClassicFragment;
import com.example.user.itunesproject.view.CustomAdapter;
import com.example.user.itunesproject.view.CustomViewHolder;
import com.example.user.itunesproject.view.PopFragment;
import com.example.user.itunesproject.view.RockFragment;
import com.example.user.itunesproject.view.TabAdapter;
import com.example.user.itunesproject.view.ViewContract;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements ViewContract {
    final String TAG = MainActivity.class.getSimpleName();

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    Presenter presenter;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.firstTab);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new RockFragment(), "Rock");
        adapter.addFragment(new ClassicFragment(), "Classic");
        adapter.addFragment(new PopFragment(), "Pop");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setIconsToTabLayout();

        //configure presenter
        presenter = new Presenter(this);
        //todo when swipe call the correct retrofit call
        //todo like presenter.getRockMusic()
        presenter.initRetrofit();
        presenter.getRockMusic();

    }

    public void setIconsToTabLayout(){
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_show_rock_fragment_tab);
    }

    @Override
    public void populateRockMusic(ItunesPojo data) {

        //todo create the Fragment
        //pass the adapter to the fragment
        //in the fragment initialize the RecyclerView.
        Log.d(TAG, "populateRockMusic: data= "+data.getResults().size());
        customAdapter = new CustomAdapter(data);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        Log.d("debugMode", "The application stopped after this");
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
        
       // return;
//
//        recyclerView = findViewById(R.id.recyclerView);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setHasFixedSize(true);
//        customAdapter = new CustomAdapter(data);
//        recyclerView.setAdapter(customAdapter);

//        Log.d(TAG, "populateInformation: title "+data);
//        final Snackbar snackbar = Snackbar
//                .make(coordinatorLayout, "Hello", Snackbar.LENGTH_INDEFINITE)
//                .setAction("UNDO", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Activate WIFI", Snackbar.LENGTH_SHORT);
//                    }
//                });
//
//        snackbar.show();

    }

    @Override
    public void populateClassicMusic(ItunesPojo data) {
        //todo send this data list to the adapter

    }

    @Override
    public void populatePopMusic(ItunesPojo data) {
        //todo send this data list to the adapter

    }
}
