package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	private Game game;
	
	public HUD(Game game) {
		this.game = game;
	}
	
	public static int HEALTH = 100;
	
	private int score = 0;
	private int level = 1;

	public void tick() {
		
		HEALTH = (int) Game.clamp(HEALTH, 0, 200);
		score++;
		if(HEALTH == 0) {
			game.setRunning(false);
		}
	}
	
	public void render(Graphics g) {
		
		//Healthbar
		g.setColor(Color.red);
		g.fillRect(15, 15, 200, 32);
		
		g.setColor(Color.green);
		g.fillRect(15, 15, HEALTH * 2, 32);
		
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		//Text
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
		
		g.setColor(Color.BLACK);
		g.drawString(HEALTH + "%", 100, 37);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
