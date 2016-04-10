package com.urcra.retardedmechanics.app.entities;

import android.graphics.Canvas;

import java.util.LinkedList;

import com.urcra.retardedmechanics.app.gfx.ImageManager;

public class CircleEnemyController {

private LinkedList<CircleEnemy> circleEnemies = new LinkedList<CircleEnemy>();
	
	CircleEnemy tempEnemy;
	
	ImageManager im;
	
	public CircleEnemyController(ImageManager im){
		this.im = im;
		
	}



    public void tick(){
		for(int i = 0; i < circleEnemies.size(); i++){
			tempEnemy = circleEnemies.get(i);
			
			/*if(tempEnemy.getx() < Flappy.getPlayer().getx()){
				removeCircleEnemy(tempEnemy);
				Flappy.getSpawner().enemykilled();
			}
			*/
			tempEnemy.tick();
		}
	}
	
	public void render(Canvas canvas){
		for(int i = 0; i < circleEnemies.size(); i++){
			tempEnemy = circleEnemies.get(i);
			
			tempEnemy.render(canvas);
		}
	}

	public void addCircleEnemy(CircleEnemy ce){
		circleEnemies.add(ce);
	}
		
	public void removeCircleEnemy(CircleEnemy ce){
		circleEnemies.remove(ce);
	}
	public LinkedList<CircleEnemy> getlist(){
		return circleEnemies;
	}
}

