package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class BasicEnemy extends GameObject{
	
	private Handler handler;
	private Color color;
	private Random random;
	private int direction;

	public BasicEnemy(int x, int y, ID id, Handler handler, Color color) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		random = new Random();
		
		velX = 3;
		velY = 3;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		direction = random.nextInt(4);
		if(y <= 0 || y >= Game.HEIGHT - 42) {
			velY *= -1;
			velX += direction;
		}
		if (x <= 0 || x >= Game.WIDTH - 20) {
			velX *= -1;
			velY += direction;
		}
		
		handler.addObject(new Trail(x, y, ID.Trail, color, 16, 16, 0.05f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 16, 16);

	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 16, 16);
	}

}
