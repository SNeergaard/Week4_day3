package com.example.week4_day3.model.Events;


import com.example.week4_day3.model.datasource.flickr.Flickr;

public class FlickrEvent {
    Flickr flickr;

    public FlickrEvent(Flickr flickr){
        this.flickr = flickr
    }

    public Flickr getFlickr() {
        return flickr;
    }

    public void setFlickr(Flickr flickr) {
        this.flickr = flickr;
    }
}
