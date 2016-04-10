package com.urcra.retardedmechanics.app.gfx;

import android.graphics.Canvas;
import android.util.Log;


import com.urcra.retardedmechanics.app.GameView;
import com.urcra.retardedmechanics.app.Renderer;


public class Background {
	
	private static int sizey = GameView.HEIGHT, sizex = GameView.WIDTH;
	private int offset = 0, distance = 0, offsetspeed = 0;
	private ImageManager im;
		
	public Background(ImageManager im){
		this.im = im;
        //ImageLoader.getResizedBitmap(im.background, sizey, sizex);
	}
	
	public void render(Canvas canvas){
        GameView.getRenderer().drawImg(canvas, im.background, offset, 0, sizex, sizey);
        GameView.getRenderer().drawImg(canvas, im.background, offset + sizex - 4, 0, sizex, sizey);
	}
	
	public void tick(){
		offset += offsetspeed;
		if(offset <= -sizex){
			distance += offset;
			offset = 0;

        }
	}
	
	public void setoffset(int offset){
		this.offset += offset;
	}
	
	public int getoffset(){
		return this.offset;
	}
	public int getdistance(){
		return -(this.offset + this.distance);
	}

	public void setoffsetspeed(int offsetspeed) {
		this.offsetspeed = -offsetspeed;
		
	}
	
	public int getoffsetspeed(){
		return this.offsetspeed;
	}

}
