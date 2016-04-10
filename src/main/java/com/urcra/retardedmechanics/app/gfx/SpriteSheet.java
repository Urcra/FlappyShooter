package com.urcra.retardedmechanics.app.gfx;

import android.graphics.Bitmap;


public class SpriteSheet {

	private Bitmap sheet;
	
	public SpriteSheet(Bitmap sheet){
		this.sheet = sheet;
	}
	
	public Bitmap crop(int col, int row, int w, int h){

        return  Bitmap.createBitmap(sheet,col * 16, row * 16, w, h);
	}
	
}
