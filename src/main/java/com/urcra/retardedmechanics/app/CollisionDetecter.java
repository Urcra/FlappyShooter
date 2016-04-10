package com.urcra.retardedmechanics.app;


import android.graphics.Rect;
import android.util.Log;

import com.urcra.retardedmechanics.app.entities.Bullet;
import com.urcra.retardedmechanics.app.entities.BulletController;
import com.urcra.retardedmechanics.app.entities.CircleEnemy;
import com.urcra.retardedmechanics.app.entities.CircleEnemyController;
import com.urcra.retardedmechanics.app.entities.Player;
import com.urcra.retardedmechanics.app.entities.Powerup;
import com.urcra.retardedmechanics.app.entities.PowerupController;
import com.urcra.retardedmechanics.app.entities.Terrain;
import com.urcra.retardedmechanics.app.entities.TerrainController;


public class CollisionDetecter {
	
	Player player;
	BulletController bc;
	CircleEnemyController cec;
	CircleEnemy tempenemy;
	Bullet tempbullet;
	PowerupController puc;
	Powerup temppowerup;
    TerrainController tec;
    Terrain tempterrain;


	public CollisionDetecter(Player player, BulletController bc, CircleEnemyController cec, PowerupController puc, TerrainController tec) {
		this.player = player;
		this.bc = bc;
		this.cec = cec;
		this.puc = puc;
        this.tec = tec;
	}

	public void tick(){
		for(int i = 0; i < cec.getlist().size(); i++){
			tempenemy = cec.getlist().get(i);
			//check with player and enemy
			if(checkcollision(tempenemy.getx(),tempenemy.gety(),tempenemy.getsize(), tempenemy.getsize(), player.getx(), player.gety(), player.getsize(), player.getsize())){
				cec.removeCircleEnemy(tempenemy);
		    	player.damage(1);
			}
			//checkplayer(tempenemy);
			for(int j = 0; j < bc.getlist().size(); j++){
				tempbullet = bc.getlist().get(j);
				// check with enemy and bullet
				if(checkcollision(tempenemy.getx(),tempenemy.gety(),tempenemy.getsize(),tempenemy.getsize(), tempbullet.getx(), tempbullet.gety(), tempbullet.getsize(), tempbullet.getsize())){
                    bc.removeBullet(tempbullet);
					tempenemy.damage(tempbullet.getattack());
				}
			}
		}
		for(int i = 0; i < puc.getlist().size(); i++){
			temppowerup = puc.getlist().get(i);
			//check with player and powerup
			if(checkcollision(temppowerup.getx(),temppowerup.gety(),temppowerup.getsize(), temppowerup.getsize(), player.getx(), player.gety(), player.getsize(), player.getsize())){
                puc.removePowerup(temppowerup);
				switch(temppowerup.gettype()){
				case 1:  player.attackup(); break;
				case 2:  player.damage(-3); break;
				default: System.out.println("error type was " + temppowerup.gettype()); break;
				}
			}
		}
        //collisions between player and pipe
        for(int i = 0; i < tec.getlist().size(); i++){
            tempterrain = tec.getlist().get(i);
            if (checkcollision(tempterrain.getx(),tempterrain.gety(),tempterrain.getydim(),tempterrain.getxdim(), player.getx(), player.gety(), player.getsize(), player.getsize())){
                player.sethp(0);
            }

        }
			
	}
	
	
	public boolean checkcollision(int x1, int y1, int size1x, int size1y, int x2, int y2, int size2x, int size2y){
		Rect r = new Rect(x1, y1, x1+size1x, y1+size1y);
	    Rect p = new Rect(x2, y2, x2+size2x, y2+size2y);

	    // Assuming there is an intersect method, otherwise just handcompare the values
	    if (r.intersects(x2, y2, x2+size2x, y2+size2y))
	    {
	    	return true;
	    }else{
	    	return false;
	    }
	}

}
