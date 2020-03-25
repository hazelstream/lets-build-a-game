package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1550691097823471818L;

	public static final int WIDTH = 1080, HEIGHT = WIDTH / 12 * 9;

	private boolean running = false;
	private Thread thread;
	private Spawn spawner;

	private Random random;
	private Handler handler;
	private HUD hud;

	
	public Game() {
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler));

		new Window(WIDTH, HEIGHT, "Let's build a game", this);
		
		hud = new HUD();
		spawner = new Spawn(handler, hud);

		random = new Random();

		handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));


			
		handler.addObject(new BasicEnemy(random.nextInt(WIDTH - 20), random.nextInt(HEIGHT - 42), ID.BasicEnemy, handler, Color.red));
	

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;

		while (running) {

			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}

			if (running) {
				render();
			}
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		handler.tick();
		hud.tick();
		spawner.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics graphics = bs.getDrawGraphics();

		graphics.setColor(Color.gray);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(graphics);
		
		hud.render(graphics);

		graphics.dispose();
		bs.show();
	}

	public static int clamp(int var, int min, int max) {

		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		}
		return var;

	}

	public static void main(String[] args) {

		new Game();
	}

}
