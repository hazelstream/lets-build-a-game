package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class SmartEnemy extends GameObject{
	
	private Handler handler;
	private Color color;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, Handler handler, Color color) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		
		for (int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}
		
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
		
		velX = (float) ((-2.0 / distance) * diffX);
		velY = (float) ((-2.0 / distance) * diffY);
		
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, color, 16, 16, 0.05f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}
