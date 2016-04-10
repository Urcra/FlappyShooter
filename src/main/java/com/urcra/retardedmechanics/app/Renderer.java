package com.urcra.retardedmechanics.app;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class Renderer {


    public void drawImg(Canvas canvas, Bitmap bmp, int x, int y, int sizex, int sizey){
        //bmp = resize(bmp,sizex,sizey);
        //canvas.drawBitmap(resize(bmp,sizex,sizey), x , y, null);
        canvas.drawBitmap(bmp, x , y, null);
    }

    public Bitmap resize(Bitmap bm, int newWidth, int newHeight){
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }


}
