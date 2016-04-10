package com.urcra.retardedmechanics.app.gfx;

import android.graphics.Bitmap;

import com.urcra.retardedmechanics.app.GameView;


public class ImageManager{
	
	public Bitmap player;
	public Bitmap bullet;
	public Bitmap background;
	public Bitmap ce;
	public Bitmap terrain;
	public Bitmap fullheart;
	public Bitmap halfheart;
    public Bitmap pipeup;
    public Bitmap pipedown;
    public Bitmap pipepiece;
	
	public ImageManager(SpriteSheet ss){
		player = ss.crop(0,0,16,16);
		bullet = ss.crop(1,0,16,16);
		background = ss.crop(0, 2, 800, 480);
		ce = ss.crop(2,0,16,16);
		fullheart = ss.crop(3, 0, 16, 16);
		halfheart = ss.crop(4, 0, 16, 16);
        pipeup = ss.crop(5, 0 , 16, 12);
        pipedown = ss.crop(6,0,16,12);
        pipepiece = ss.crop(7,0,14,16);
		//terrain = ss.crop(col, row, w, h);

	}

    public void initimg(int scale){
        player = GameView.getRenderer().resize(player,16*scale,16*scale);
        //
        bullet = GameView.getRenderer().resize(bullet,16*scale,16*scale);
        background = GameView.getRenderer().resize(background,GameView.WIDTH,GameView.HEIGHT);
        ce = GameView.getRenderer().resize(ce,16*scale,16*scale);
        fullheart = GameView.getRenderer().resize(fullheart,16*scale,16*scale);
        halfheart = GameView.getRenderer().resize(halfheart,16*scale,16*scale);
        pipeup = GameView.getRenderer().resize(pipeup,16*scale,16*scale);
        pipedown = GameView.getRenderer().resize(pipedown,16*scale,16*scale);
        pipepiece = GameView.getRenderer().resize(pipepiece,16*scale,16*scale);
    }
}
