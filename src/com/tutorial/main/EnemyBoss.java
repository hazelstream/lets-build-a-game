package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class EnemyBoss extends GameObject{
	
	private Handler handler;
	private Color color;
	private int timer = 20;
	private int timer2 = 50;
	Random random = new Random();

	public EnemyBoss(int x, int y, ID id, Handler handler, Color color) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		
		velX = 0;
		velY = 5;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(timer <= 0) velY = 0;
		else timer--;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0) {
			if(velX == 0) {
				velX = 3;
			}
			int spawn = random.nextInt(5);
			if(spawn == 0) handler.addObject(new EnemyBossBullet((int) x + 48,(int) y + 96, ID.BasicEnemy, handler, color));
		}
		
//		if(y <= 0 || y >= Game.HEIGHT - 42) {
//			velY *= -1;
//		}
		if (x <= 0 || x >= Game.WIDTH - 100) {
			velX *= -1;
		}
		
		//handler.addObject(new Trail((int)x, (int)y, ID.Trail, color, 16, 16, 0.05f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, 96, 96);
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 96, 96);
	}

}
