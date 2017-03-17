package com.example.jimmy.myfirstgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Jimmy on 2017-03-10.
 */

public class Game extends SurfaceView implements Runnable {
    private volatile boolean running = false;
    private Bitmap gameImage;
    private Thread mainThread;
    private Canvas canvas;
    private Drawable shape;
    private Paint paint;
    private Player player;
    private Bitmap playerBitmap;
    private static final int BMP_COLUMNS = 3;
    private static final int BMP_ROWS = 4;
    private int currentFrame = 0;

    public Game(Context context, int gameHeight, int gameWidth){
        super(context);
        //Använder surfaceholder istället för att använda Surface direkt, så används SurfaceHolder istället för att styra surfaceview. Sen override alla funktioner genom skapa en callback.
        SurfaceHolder holder = getHolder();
        //Sätter en bitmap till canvas som man ritar på.
        gameImage = Bitmap.createBitmap(gameHeight, gameWidth, Bitmap.Config.RGB_565);
        //Sätter bitmapen till Canvas.
        canvas = new Canvas(gameImage);
        paint = new Paint();

        playerBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bad2);
        player = new Player(playerBitmap,playerBitmap.getHeight() / BMP_ROWS, playerBitmap.getWidth() / BMP_COLUMNS);

        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                initGame();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                //pauseGame();

            }
        });

    }

    public void initGame(){
        running = true;
        mainThread = new Thread(this, "Game Thread");
        mainThread.start();
    }

    public void pauseGame(){
        running = false;
    }

    public void render(){


    }

    public void update(){
        currentFrame = ++currentFrame % BMP_COLUMNS;
        player.update(currentFrame);
    }


    public void draw(){
        canvas = getHolder().lockCanvas();
        if(canvas != null){
            canvas.drawColor(Color.BLUE);
            player.draw(canvas);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void run(){
        while(running){
            update();
            draw();
            try{
                Thread.sleep(50);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
