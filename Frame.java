package com.example.jimmy.myfirstgame;

import android.graphics.Bitmap;

/**
 * Created by Jimmy on 2017-03-16.
 */

public class Frame {
    private Bitmap image;
    private double duration;

    public Frame(Bitmap image, double duration){
        this.image = image;
        this.duration = duration;

    }

    public Bitmap getImage(){
        return image;
    }

    public double getDuration(){
        return duration;
    }

}
