package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MyView extends View {
    int N = 8000;
    int a = 25;
    int[] k = new int[N];
    int[] alpha = new int[N];
    int c = N;
    int b = N / 255 + 1;
    float[] x = new float[N];
    float[] y = new float[N];
    float[] vy = new float[N];
    int[] color = new int[N];
    Paint paint = new Paint();
    Random r = new Random();
    DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
    public MyView(Context context) {
        super(context);
        for (int i = 0; i < N; i++) {
            c--;
            x[i] = (float)(Math.random() * width * 1.0567);
            y[i] = r.nextInt((int)(height * 1.0567 / 3)) + (float)(height * 1.0567) - 50;
            vy[i] = (float)(Math.random() * 10 + r.nextInt(5) + 1);
            alpha[i] = (int) (height * 1.0567 - y[i]) / 80;
            k[i] = (int) y[i] / 25;
            color[i] = Color.argb(r.nextInt(50) + alpha[i], (N - c) / b * k[i], r.nextInt(1), r.nextInt(1));
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        float xT = event.getX();
        float yT = event.getY();
        boolean isTouched = false;
        if(!isTouched) {
            isTouched = true;
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(getContext(),"LOL. YOU BURNED OUT.",Toast.LENGTH_SHORT).show();
                isTouched = false;
            }
        }
        return super.onTouchEvent(event);
    }
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < N; i++) {
            paint.setColor(color[i]);
            canvas.drawRect(x[i] - a, y[i] - a, x[i] + a, y[i] + a, paint);
        }
        setBackgroundColor(Color.BLACK);
        for (int i = 0; i < N; i++) {
            y[i] -= vy[i];
            double d = (double) x[i];
            if (y[i] <=  Math.sin(d / r.nextInt(10)) * 100 + height * 1.0567 - r.nextInt((int)(height * 1.0567) * 10)) {
                y[i] = r.nextInt(50) + (float)(height * 1.0567);
                vy[i] = (float)(Math.random() * 10 + r.nextInt(5) + 1);
            }
            if (vy[i] <= 4) {
                if (vy[i] <= 2) {
                    if (y[i] <= r.nextInt(200) + (int)(3 * (float)(height * 1.0567) / 5)) {
                        y[i] = r.nextInt(50) + (float)(height * 1.0567);
                        vy[i] = (float)(Math.random() * 10 + r.nextInt(5) + 1);
                    }
                } else {
                    if (y[i] <= r.nextInt(200) + (int)((float)(height * 1.0567) / 2) + 200) {
                        y[i] = r.nextInt(50) + (float)(height * 1.0567);
                        vy[i] = (float)(Math.random() * 10 + r.nextInt(5) + 1);
                    }
                }
            }
        }
        invalidate();
    }
}