package com.urcra.retardedmechanics.app.entities;

import android.graphics.Canvas;
import android.util.Log;

import com.urcra.retardedmechanics.app.GameView;
import com.urcra.retardedmechanics.app.gfx.ImageManager;

public class Player{
	
	private int x, y;
	private ImageManager im;
	private boolean up = false, down = false, left = false, right = false, inair = false;
	private int momentum = 0;
	private int hp = 5;
	private final int size = 16 * GameView.SCALE;
	private final int speed = 4;
	private int attack = 1;
	private int timer;
	
	public Player(int x, int y, ImageManager im){
		this.x = x;
		this.y = y;
		this.im = im;
	}
	
	public void tick(){
		if(up && y-6 >= 0){
			y -= speed;
		}
		
		if(inair){
			y -= momentum;
			momentum--;
			if((y-momentum)+64 >= GameView.HEIGHT){
				this.inair = false;
				y = GameView.HEIGHT -16*GameView.SCALE;
				momentum = 0;
                this.sethp(0);
			}
		}
		
		if(down && y+64 <= GameView.HEIGHT*GameView.SCALE){
			y += speed;
		}
		if(left && x-4 >= 0){
			x -= speed;
			GameView.getBack().setoffsetspeed(3);
		}else if(left && x-4 <= 5){
			GameView.getBack().setoffsetspeed(1);
		}else if(right && x+40 <= (GameView.WIDTH*GameView.SCALE)/2){
			x += speed;
			GameView.getBack().setoffsetspeed(3);
		}else if(right && x+40 >= (GameView.WIDTH*GameView.SCALE)/2){
			GameView.getBack().setoffsetspeed(5);
		}else{
			GameView.getBack().setoffsetspeed(3);
		}
		if(timer <= 0){
			attack = 1;
		}else{
			timer--;
		}
        //Log.d("playerpos", Integer.toString(x) + " X, " + Integer.toString(y) + " Y, ");
	}
	
	public void render(Canvas canvas){
        GameView.getRenderer().drawImg(canvas, im.player, x, y, size, size);
		for(int i = 1; i <= hp; i++){
            GameView.getRenderer().drawImg(canvas, im.fullheart, (16 * i) - 16, 0, 16, 16);
		}
	}
	
	public void setup(boolean state){
		this.up = state;
	}
	public void setdown(boolean state){
		this.down = state;
	}
	public void setleft(boolean state){
		this.left = state;
	}
	public void setright(boolean state){
		this.right = state;
	}
	public void jump(){
		if(this.momentum >= 0){
			this.momentum += 10;
		}else{
			this.momentum = 10;
		}
		this.inair = true;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}

	public void shoot() {
		GameView.getBullets().addBullet(new Bullet(x,y,im, attack));
	}
	
	public void damage(int dmg){
		this.hp -= dmg;
	}
	
	public int gethp(){
		return this.hp;
	}
	
	public void sethp(int hp){
		this.hp = hp;
	}

	public int getsize() {
		return size;
	}
	public void attackup(){
		this.attack = 2;
		this.timer = 60*20;
	}
	
	

}
