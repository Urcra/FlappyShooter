package com.urcra.retardedmechanics.app.gfx;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.urcra.retardedmechanics.app.GameView;
import com.urcra.retardedmechanics.app.R;


public class ImageLoader {

	/*public Bitmap load(String path){

		return BitmapFactory.decodeResource(, R.drawable.ic_launcher);;
	}*/


    public static Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
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


    public Bitmap load(Resources resources, int spritesheet) {
        return BitmapFactory.decodeResource(resources, spritesheet);
    }
}
