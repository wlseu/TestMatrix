package com.example.testmatrix.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wl on 2014/11/17.
 */
public class MyView extends View
{
    private Bitmap bitmap;
    private Matrix matrix = new Matrix ();
    private int width,hight;
    private float scale = 1.5f;
    public float posx;
    public float posy;
    public MyView(Context context,AttributeSet set)
    {
        super(context,set);
        bitmap = ((BitmapDrawable) context.getResources ().getDrawable (R.drawable.ball)).getBitmap ();
        width = bitmap.getWidth ();
        hight = bitmap.getHeight ();
        Log.v ("Bitmap","width"+width+"   hight"+hight);
        this.setFocusable (true);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw (canvas);
        matrix.reset ();
        matrix.setScale (scale,scale);
        Bitmap bitmaptemp = Bitmap.createBitmap (bitmap,0,0,width,hight,matrix,true);
        canvas.drawBitmap (bitmaptemp,matrix,null);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        posx = event.getX ();
        posy = event.getY ();
        Log.v ("MyView","x" + posx+"   y"+posy);
        return true;
    }
}
