package com.example.jimmy.myfirstgame;

import android.graphics.Bitmap;

/**
 * Created by Jimmy on 2017-03-16.
 */

public class Animation {
    private Frame[] frames;
    private double[] frameEndTimes;
    private int currentFrame;
    private long durationTime;
    private double currentTime;
    private double totalDuration;

    Animation(Frame...frames){
        this.frames = frames;
        frameEndTimes = new double[frames.length];
        for(int i = 0; i < frames.length; i++){
            Frame f = frames[i];
            totalDuration += f.getDuration();
            frameEndTimes[i] = totalDuration;
        }
    }

    
}
