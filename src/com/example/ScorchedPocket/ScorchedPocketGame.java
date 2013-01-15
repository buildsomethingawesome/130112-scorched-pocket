package com.example.ScorchedPocket;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class ScorchedPocketGame extends View {

    public ScorchedPocketGame(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        redPaint.setTextSize(20);

        canvas.drawText("Width: " + getWidth(), 100, 100, redPaint);
        canvas.drawText("Height: " + getHeight(), 100, 150, redPaint);
    }
}
