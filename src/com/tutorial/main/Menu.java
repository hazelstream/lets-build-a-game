package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random random = new Random();

	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		
		//play button
		if(mouseOver(mx, my, 232, 190, 200, 64)) {
			game.gameState = STATE.Game;
			
			handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
//			handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, - 100, ID.EnemyBoss, handler, Color.black));
			handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 42), ID.BasicEnemy, handler, Color.red));
		}
		
		
		//help button
		if(mouseOver(mx, my, 232, 290, 200, 64)) {
			game.gameState = STATE.Help;
		}
		
		
		//back for help
		if(mouseOver(mx, my, 232, 390, 200, 64) && game.gameState == STATE.Help) {
			game.gameState = STATE.Menu;
			return;
		}
		
		
		//quit button
		if(mouseOver(mx, my, 232, 390, 200, 64)) {
			System.exit(1);
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	
	/*
	 * Checks if mx is bigger than x, then if it's smaller than x + width.
	 * After that it checks if my is bigger than y and smaller than y + height. 
	 * This makes it easy to see if a click is within certain parameters.
	 */
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public void render(Graphics g) {
		
		if(game.gameState == STATE.Menu) {
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString("Menu", 270, 50);
			
			
			g.setFont(font2);
			
			g.setColor(Color.WHITE);
			g.drawString("Play", 300, 230);
			g.drawRect(232, 190, 200, 64);
			

			g.drawString("Help", 300, 330);
			g.drawRect(232, 290, 200, 64);
			

			g.drawString("Quit", 300, 430);
			g.drawRect(232, 390, 200, 64);
		} else if(game.gameState == STATE.Help) {
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString("Help", 270, 50);
			
			g.setColor(Color.WHITE);
			g.setFont(font2);
			g.drawString("Back", 300, 430);
			g.drawRect(232, 390, 200, 64);
		}
		
	}
	
	public void tick() {
		
	}

}
