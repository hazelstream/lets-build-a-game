package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import org.omg.PortableServer.ThreadPolicyOperations;

public class BasicEnemy extends GameObject{
	
	private Handler handler;
	private Color color;

	public BasicEnemy(int x, int y, ID id, Handler handler, Color color) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		
		velX = 3;
		velY = 3;
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
