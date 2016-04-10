package com.urcra.retardedmechanics.app.entities;


import android.graphics.Canvas;

import com.urcra.retardedmechanics.app.GameView;
import com.urcra.retardedmechanics.app.gfx.ImageManager;

public class CircleEnemy {

	private int x, y;
	private ImageManager im;
	private int hp = 2;
	private final int size = 16 * GameView.SCALE;
	private final int speed = -1;
	
	
	public CircleEnemy(int x, int y, ImageManager im){
		this.x = x;
		this.y = y;
		this.im = im;
	}
	
	public void tick(){
		x += speed + GameView.getBack().getoffsetspeed();
		if(GameView.getPlayer().gety() < y){
			y += speed;
		}else if(GameView.getPlayer().gety() > y){
			y += -speed;
		}
		if(x < 0 - size){
			GameView.getCec().removeCircleEnemy(this);
		}
	}
	
	public void render(Canvas canvas){
        GameView.getRenderer().drawImg(canvas, im.ce, x, y, size, size);
		
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
	
	public void damage(int damage){
		this.hp -= damage;
		if(this.hp <= 0){
			GameView.getCec().removeCircleEnemy(this);
			GameView.getscorecounter().addscore(25);
		}
	}

}
