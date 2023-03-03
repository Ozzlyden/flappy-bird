package com.victor.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.victor.main.Game;
import com.victor.world.World;


public class Player extends Entity {
	
	private int frames = 0, maxFrames = 8, index = 0, maxIndex = 2;
	
	public boolean isPressed = false;
	

	
	public Player(int x, int y, int width, int height,double speed, BufferedImage sprite) {
		super(x, y, width, height,speed, sprite);
	

	}
	
	public void tick() {
		// CAMADA DE RENDER
		depth = 2;
		if(!isPressed) {
			y+=2;
		}else {
			y-=2;
		}
		
		if(y > Game.HEIGHT) {
			World.restartGame(null);
		}
		
		//COLISAO
		for(int i = 0; i < Game.entities.size(); i++){
			Entity e = Game.entities.get(i);
			if(e != this) {
				if(Entity.isColliding(this, e)) {
					World.restartGame(null);
					return;
				}
			}
				
		}
		
	}

	
	public void render(Graphics g) {
		super.render(g);
	}
		
}
	
