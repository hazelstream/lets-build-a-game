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
			
			if (hud.getLevel() == 1) {
				handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
			} else if(hud.getLevel() == 2) {	
				for (int i = 0; i < 2; i++) {
					handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
				}
			} else if (hud.getLevel() == 3) {
				handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
			} else if (hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
				handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
			} else if (hud.getLevel() == 5) {
				for (int i = 0; i < 2; i++) {
					handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
				}
				for (int i = 0; i < 2; i++) {
					handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
				}
			} else if (hud.getLevel() == 6) {
				for (int i = 0; i < 3; i++) {
					handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
				}
				for (int i = 0; i < 3; i++) {
					handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
				}
			} else if (hud.getLevel() == 7) {
				for (int i = 0; i < 5; i++) {
					handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
				}
				for (int i = 0; i < 5; i++) {
					handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
				}
			} else if (hud.getLevel() == 8) {
				for (int i = 0; i < 7; i++) {
					handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
				}
				for (int i = 0; i < 7; i++) {
					handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, randomColor()));
				}
			}
		}
	}
	
	private Color randomColor() {
		r = random.nextFloat();
		g = random.nextFloat();
		b = random.nextFloat();
		color = new Color(r, g, b);
		return color;
	}
}
