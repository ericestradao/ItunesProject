package com.example.user.itunesproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("collectionName")
    @Expose
    private String collectionName;
    @SerializedName("artworkUrl60")
    @Expose
    private String artworkUrl60;
    @SerializedName("trackPrice")
    @Expose
    private Double trackPrice;
    @SerializedName("previewUrl")
    @Expose
    private String previewUrl;


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public Double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(Double trackPrice) {
        this.trackPrice = trackPrice;
    }

}