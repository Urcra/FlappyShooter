package com.urcra.retardedmechanics.app.entities;

import android.graphics.Canvas;


import java.util.LinkedList;

import com.urcra.retardedmechanics.app.GameView;
import com.urcra.retardedmechanics.app.gfx.ImageManager;

public class TerrainController {

private LinkedList<Terrain> terrains = new LinkedList<Terrain>();
	
	Terrain tempTerrain;
	
	ImageManager im;
	
	public TerrainController(ImageManager im){
		this.im = im;
		
	}



    public void tick(){
		for(int i = 0; i < terrains.size(); i++){
			tempTerrain = terrains.get(i);
			
			if(tempTerrain.getx() < 0-16*GameView.SCALE ) removeTerrain(tempTerrain);
			
			tempTerrain.tick();
		}
	}
	
	public void render(Canvas canvas){
		for(int i = 0; i < terrains.size(); i++){
			tempTerrain = terrains.get(i);
			
			tempTerrain.render(canvas);
		}
	}

	public void addTerrain(Terrain t){
		terrains.add(t);
	}
		
	public void removeTerrain(Terrain t){
		terrains.remove(t);
	}

	public LinkedList<Terrain> getlist() {
		return terrains;
	}
}
