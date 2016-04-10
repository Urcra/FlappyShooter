package com.urcra.retardedmechanics.app.entities;

import java.util.Random;


import com.urcra.retardedmechanics.app.GameView;
import com.urcra.retardedmechanics.app.gfx.ImageManager;

public class EnemySpawner {
	
	Random rn = new Random();
	ImageManager im;
	CircleEnemyController cec;
	PowerupController puc;
    TerrainController tec;
	private int espawnd = 1, pspawnd = 1, temprandom;
	
	
	public EnemySpawner(ImageManager im, CircleEnemyController cec, PowerupController puc, TerrainController tec){
		this.im = im;
		this.cec = cec;
		this.puc = puc;
        this.tec = tec;
	}



    public void lineofcircles(CircleEnemyController cec){
		for(int i = 0; i <= 2; i++){
			//cec.addCircleEnemy(new CircleEnemy(700,100+40*i,im));
			cec.addCircleEnemy(new CircleEnemy((GameView.WIDTH*GameView.SCALE) + 20, rn.nextInt((GameView.HEIGHT*GameView.SCALE)-200)+50, im));

		}
	}
	
	public void circleofcircles(CircleEnemyController cec, int quantity){
		for(int i = 0; i < quantity; i++){
			cec.addCircleEnemy(new CircleEnemy(GameView.WIDTH+10,100+40*i,im));
		}
	}
	public void tick(){
		if(GameView.getBack().getdistance()/espawnd > 500){
            tec.addTerrain( new Terrain(GameView.WIDTH+10, 200, 0, im));
            tec.addTerrain( new Terrain(GameView.WIDTH+10, 100, 1, im));
			espawnd++;
			lineofcircles(GameView.getCec());
		}
		/*if(puc.getlist().size() < 1){
			puc.addPowerup(new Powerup((Flappy.width*Flappy.scale) + 20, rn.nextInt((Flappy.height*Flappy.scale)-200)+50, im, 2));
			pspawnd++;
		}*/
		if(GameView.getBack().getdistance()/pspawnd > 1000 ){
			temprandom = rn.nextInt(4)+1;
			if(temprandom <= 2){
				puc.addPowerup(new Powerup((GameView.WIDTH*GameView.SCALE) + 20, rn.nextInt((GameView.HEIGHT*GameView.SCALE)-200)+50, im, temprandom));
				pspawnd++;
			}
		}
	}
	
}
