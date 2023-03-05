package com.victor.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
			if(y > 0) {
				y-=2;

			}
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
		Graphics2D g2 = (Graphics2D) g;
		
		if(!isPressed) { 
			//g2.rotate(Math.toRadians(20), this.getX() + width / 2,  this.getY() + height / 2);
			g2.drawImage(sprite, this.getX(), this.getY(), null);
			//g2.rotate(Math.toRadians(-20), this.getX()+ width / 2,  this.getY() + height / 2);;
		}else {
			//g2.rotate(Math.toRadians(-20), this.getX() + width / 2,  this.getY() + height / 2);
			g2.drawImage(sprite, this.getX(), this.getY(), null);
			//g2.rotate(Math.toRadians(20), this.getX()+ width / 2,  this.getY() + height / 2);;
			
		}
		
		//DEBUG MASK
		//g.setColor(Color.RED);
		//g.fillRect(this.getX(), this.getY(), width, height);
	}
		
}
	
