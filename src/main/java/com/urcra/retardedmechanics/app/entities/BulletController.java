package com.urcra.retardedmechanics.app.entities;

import android.graphics.Canvas;


import java.util.LinkedList;

import com.urcra.retardedmechanics.app.GameView;
import com.urcra.retardedmechanics.app.gfx.ImageManager;

public class BulletController {

	private LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	
	Bullet tempBullet;
	
	ImageManager im;
	
	public BulletController(ImageManager im){
		this.im = im;
		
	}



    public void tick(){
		for(int i = 0; i < bullets.size(); i++){
			tempBullet = bullets.get(i);
			
			if(tempBullet.getx() > GameView.WIDTH+10 ) removeBullet(tempBullet);
			
			tempBullet.tick();
		}
	}
	
	public void render(Canvas canvas){
		for(int i = 0; i < bullets.size(); i++){
			tempBullet = bullets.get(i);
			
			tempBullet.render(canvas);
		}
	}

	public void addBullet(Bullet b){
		bullets.add(b);
	}
		
	public void removeBullet(Bullet b){
		bullets.remove(b);
	}

	public LinkedList<Bullet> getlist() {
		return bullets;
	}
}
