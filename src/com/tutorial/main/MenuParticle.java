package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.util.Random;


public class MenuParticle extends GameObject{
	
	private Handler handler;
	private Random random;
	private Color color2;

	int dir = 0;	
	
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		random = new Random();
		
		velX = (random.nextInt(5 - -5) + -5);
		velY = (random.nextInt(5 - -5) + -5);
		
		color2 = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y >= Game.HEIGHT - 42) {
			velY *= -1;
		}
		if (x <= 0 || x >= Game.WIDTH - 20) {
			velX *= -1;
		}
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, color2, 16, 16, 0.05f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color2);
		g.fillRect((int)x, (int)y, 16, 16);

	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}
