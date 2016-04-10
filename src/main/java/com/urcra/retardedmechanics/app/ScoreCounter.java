package com.urcra.retardedmechanics.app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class ScoreCounter {

	private int score = 0;


    public void render(Paint paint, Canvas canvas){
		//g.drawString("Score: " + Integer.toString((Flappy.getBack().getdistance()/10) + score), 20, 20);
        canvas.drawText("Score: " + Integer.toString((GameView.getBack().getdistance()/10) + score), 20, 20, paint);
	}
	
	public void addscore(int toadd){
		score += toadd;
	}
}
