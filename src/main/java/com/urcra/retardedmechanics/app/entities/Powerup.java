package com.urcra.retardedmechanics.app.entities;

import android.graphics.Canvas;


import com.urcra.retardedmechanics.app.GameView;
import com.urcra.retardedmechanics.app.gfx.ImageManager;

public class Powerup {


	private int x, y, type;
	private ImageManager im;
	//private final int speed = 6;
	private final int size = 9 * GameView.SCALE;
	
	
	public Powerup(int x, int y, ImageManager im, int type){
		this.x = x;
		this.y = y;
		this.im = im;
		this.type = type;
	}



    public void tick(){
		x += GameView.getBack().getoffsetspeed();
		if(x < 0){
			GameView.getPuc().removePowerup(this);
		}
	}
	
	public void render(Canvas canvas){
		switch(type){
		case 1: GameView.getRenderer().drawImg(canvas, im.bullet, x, y, 16 * GameView.SCALE, 16 * GameView.SCALE); break;
		case 2: GameView.getRenderer().drawImg(canvas, im.fullheart, x, y, 16 * GameView.SCALE, 16 * GameView.SCALE); break;
		default: System.out.println("error type was " + type); break;

		}
		
	}
	
	public int getx(){
		return x;
	}
	
	public int gety(){
		return y;
	}

	public int getsize() {
		return size;
	}
	
	public int gettype(){
		return type;
	}


}
