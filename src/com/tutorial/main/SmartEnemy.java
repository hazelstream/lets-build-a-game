package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class SmartEnemy extends GameObject{
	
	private Handler handler;
	private Color color;
	private Random random;
	private int direction;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, Handler handler, Color color) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		random = new Random();
		
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
		
		velX = (float) ((-1.0 / distance) * diffX);
		velY = (float) ((-1.0 / distance) * diffY);
		
		direction = random.nextInt(2);
		if(y <= 0 || y >= Game.HEIGHT - 42) {
			velY *= -1;
			velX += direction;
		}
		if (x <= 0 || x >= Game.WIDTH - 20) {
			velX *= -1;
			velY += direction;
		}
		
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
