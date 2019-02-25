package com.example.user.itunesproject.view;

import com.example.user.itunesproject.model.ItunesPojo;

import java.util.List;

public interface ViewContract {
    void populateRockMusic(ItunesPojo data);
    void populateClassicMusic(ItunesPojo data);
    void populatePopMusic(ItunesPojo data);
}
