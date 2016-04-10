package com.urcra.retardedmechanics.app.entities;

import android.graphics.Canvas;


import com.urcra.retardedmechanics.app.GameView;
import com.urcra.retardedmechanics.app.gfx.ImageManager;

public class Bullet {

	private int x, y, attack;
	private ImageManager im;
	private final int speed = 6;
	private final int size = 9 * GameView.SCALE;
	
	
	public Bullet(int x, int y, ImageManager im, int attack){
		this.x = x;
		this.y = y;
		this.im = im;
		this.attack = attack;
	}
	
	public void tick(){
		x += speed;
	}
	
	public void render(Canvas canvas){
        GameView.getRenderer().drawImg(canvas, im.bullet, x, y, 16 * GameView.SCALE, 16 * GameView.SCALE);
		
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
	
	public int getattack(){
		return this.attack;
	}

}
