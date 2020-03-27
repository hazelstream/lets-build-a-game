package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class LossScreen {
	
	private HUD hud;
	private int width, height;
	private Game game;

	public LossScreen(HUD hud, int width, int height, Game game) {
		this.hud = hud;
		this.height = height;
		this.width = width;
		this.game = game;
	}
	
	public void tick() {
		
	}
	
	public void render() {
		BufferStrategy bs = game.getBufferStrategy();
		if (bs == null) {
			game.createBufferStrategy(3);
			return;
		}

		Graphics graphics = bs.getDrawGraphics();
		
		graphics.setColor(Color.gray);
		graphics.fillRect(0, 0, width, height);
		
		graphics.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		graphics.setColor(Color.black );
		graphics.drawString("YOU LOST", width / 2 - 75, height / 2);
		
		graphics.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		graphics.drawString("You made it to level: " + hud.getLevel(), width / 2 - 70, height / 2 + 30);
		graphics.drawString("Score: " + hud.getScore(), width / 2 - 25, height / 2 + 60);
		
		
		graphics.dispose();
		bs.show();
	}
}
