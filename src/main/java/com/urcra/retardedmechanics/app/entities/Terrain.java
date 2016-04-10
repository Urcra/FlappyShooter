package com.urcra.retardedmechanics.app.entities;

import android.graphics.Canvas;


import com.urcra.retardedmechanics.app.GameView;
import com.urcra.retardedmechanics.app.gfx.ImageManager;

public class Terrain {


	private int x, y, state;
	private ImageManager im;
	private final int speed = 6;
	
	
	public Terrain(int x, int y, int state, ImageManager im){
		this.x = x;
		this.y = y;
		this.im = im;
        this.state = state;
	}



    public void tick(){
		x += GameView.getBack().getoffsetspeed();
	}
	
	public void render(Canvas canvas){
        if(state == 0){
            for(int i = 0; i <= y/16-1; i++){
                GameView.getRenderer().drawImg(canvas, im.pipepiece, x, 16*i, 16 * GameView.SCALE, 16 * GameView.SCALE);
            }
            GameView.getRenderer().drawImg(canvas, im.pipedown, x, y, 16 * GameView.SCALE, 12 * GameView.SCALE);

        }else if (state == 1){
            for(int i = 0; i <= y/16-1; i++){
                GameView.getRenderer().drawImg(canvas, im.pipepiece, x, GameView.HEIGHT - 16*i, 16 * GameView.SCALE, 16 * GameView.SCALE);
            }
            GameView.getRenderer().drawImg(canvas, im.pipeup, x,  GameView.HEIGHT -y, 16 * GameView.SCALE, 12 * GameView.SCALE);
        }
		
	}
	
	public int getx(){
		return x;
	}
	
	public int gety(){
        if (state == 0){
            return 0;
        }else if (state == 1){
            return GameView.HEIGHT;
        }else return 0;
	}

    public int getxdim(){
        return 16 * GameView.SCALE;
    }

    public int getydim(){
        if (state == 0){
            return y;
        }else if (state == 1){
            return -y;
        }else return 0;
    }

	/*public int getsize() {
		return size;
	}*/


}
