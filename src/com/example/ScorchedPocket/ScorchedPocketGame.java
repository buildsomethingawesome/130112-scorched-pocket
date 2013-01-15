package com.example.ScorchedPocket;

import android.content.Context;
import android.graphics.*;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class ScorchedPocketGame extends View implements Runnable {
    private float tank1X = 11;
    private float tank1Y = 226;
    Bitmap backgroundImage;
    Bitmap tank1Image;
    Bitmap tank2Image;
    Bitmap ammoImage;
    Bitmap explosionImage;
    Handler handler = new Handler();
    private int ammoX = 85;

    public ScorchedPocketGame(Context context) {
        super(context);

        backgroundImage = BitmapFactory.decodeResource(getResources(),
                R.drawable.map1);
        tank1Image = BitmapFactory.decodeResource(getResources(),
                R.drawable.tank1);
        tank2Image = BitmapFactory.decodeResource(getResources(),
                R.drawable.tank2);
        ammoImage = BitmapFactory.decodeResource(getResources(),
                R.drawable.ammo1);
        explosionImage = BitmapFactory.decodeResource(getResources(),
                R.drawable.explosion);

        handler.postDelayed(this, 30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(backgroundImage, 0, 0, null);

        canvas.drawBitmap(tank1Image, tank1X, tank1Y, null);
        canvas.drawBitmap(tank2Image, 404, 268, null);
        canvas.drawBitmap(ammoImage, ammoX, 203, null);
        canvas.drawBitmap(explosionImage, 155, 164, null);
    }

    @Override
    public void run() {
        ammoX = ammoX + 5;

        postInvalidate();
        handler.postDelayed(this, 30);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        tank1X = event.getX();
        tank1Y = event.getY();

        if (event.getAction() == MotionEvent.ACTION_UP) {
            ammoX = 0;
        }

        postInvalidate();
        return true;
    }
}
