package com.urcra.retardedmechanics.app.entities;

import android.graphics.Canvas;


import java.util.LinkedList;


import com.urcra.retardedmechanics.app.gfx.ImageManager;

public class PowerupController {

private LinkedList<Powerup> powerups = new LinkedList<Powerup>();
	
	Powerup tempPowerup;
	
	ImageManager im;
	
	public PowerupController(ImageManager im){
		this.im = im;
		
	}



    public void tick(){
		for(int i = 0; i < powerups.size(); i++){
			tempPowerup = powerups.get(i);
			
			/*if(tempPowerup.getx() < Flappy.getPlayer().getx()){
				removeCirclePowerup(tempPowerup);
				Flappy.getSpawner().Powerupkilled();
			}
			*/
			tempPowerup.tick();
		}
	}
	
	public void render(Canvas canvas){
		for(int i = 0; i < powerups.size(); i++){
			tempPowerup = powerups.get(i);
			
			tempPowerup.render(canvas);
		}
	}

	public void addPowerup(Powerup pu){
		powerups.add(pu);
	}
		
	public void removePowerup(Powerup pu){
		powerups.remove(pu);
	}
	public LinkedList<Powerup> getlist(){
		return powerups;
	}}


