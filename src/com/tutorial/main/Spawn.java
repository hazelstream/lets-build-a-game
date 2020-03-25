package com.tutorial.main;

import java.awt.Color;
import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random random = new Random();
	private float r, g, b;
	private Color color;
	

	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 250) {
			scoreKeep = 0;
			hud.setScore(0);
			hud.setLevel(hud.getLevel() + 1);
			
			//if(hud.getLevel() == 2) {
				r = random.nextFloat();
				g = random.nextFloat();
				b = random.nextFloat();
				color = new Color(r, g, b);
				
				handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, color));
			//}
		}
	}
}
