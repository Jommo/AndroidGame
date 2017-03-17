package com.example.jimmy.myfirstgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Jimmy on 2017-03-16.
 */

public class Player {
    private Bitmap playerImage;
    private BitmapFactory bitmapFac;
    private Rect src;
    private Rect dst;
    //private Animation playerAnim;
    private int height;
    private int  width;
    private int speedX;
    private int speedY;
    private int x = 0;
    private int y = 0;
    private int currentFrame = 0;
    private int[] DIRECTION_OF_ANIMATION = {3,1,0, 2};

    public Player(Bitmap playerImage, int height, int width){
        this.playerImage = playerImage;
        this.height = height;
        this.width = width;
        speedX = 0;
        speedY = 0;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void moveX(int speedX){
        x = x + speedX;
    }

    public void moveY(int speedY){

    }

    public void playerFalling(){

    }

    public int playerJumping(){

        return DIRECTION_OF_ANIMATION[0];
    }

    public void update(int currentFrame){
        this.currentFrame = currentFrame;
    }

    public void draw(Canvas canvas){
        int srcX = currentFrame * width;
        int srcY = getAnimationRow() * getHeight();
        Rect src = new Rect(srcX,srcY,srcX+width,srcY+height);
        Rect dst = new Rect(x,y,x+width,y+height);

        canvas.drawBitmap(playerImage,src,dst, null);
    }

    private int getAnimationRow(){
        int direction = 0;
        moveX(5);
        return DIRECTION_OF_ANIMATION[direction];
    }
}
