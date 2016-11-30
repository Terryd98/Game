package com.terry;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.terry.entity.mob.Player;
import com.terry.gfx.Render;
import com.terry.input.Keyboard;
import com.terry.level.Level;

public class Main extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private static int width = 240, height = 240, scale = 3;
	private Thread thread;
	private Render render;
	private JFrame frame;
	private Keyboard key;
	private Level level;
	private Player player;
	private String title = "Untitled";
	private boolean running = false;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Main() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		render = new Render(width, height, pixels);
		frame = new JFrame();
		level = new Level(30, 30);
		key = new Keyboard();
		player = new Player(7, 7, key);

		addKeyListener(key);
	}

	private void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	private void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(ticks + " Ticks | " + frames + " FPS");
				frame.setTitle(title + "  -  " + ticks + " Ticks | " + frames + " FPS");
				ticks = 0;
				frames = 0;
			}
		}
		stop();
	}

	int xTime = 0, yTime = 0;
	int counter = 0;

	private void tick() {
		key.tick();
		player.tick();
		level.tick();
		if (key.esc) {
			System.out.println("Closing.....");
			System.exit(0);
		}
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = render.pixels[i];
		}
		render.clear();
		int xScroll = player.x - render.width / 2;
		int yScroll = player.y - render.height / 2;

		level.render(0, 0, render);
		player.render(render);

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();

	}

	public static void main(String args[]) {
		Main main = new Main();

		main.frame.setResizable(false);
		main.frame.add(main);
		main.frame.pack();
		main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.frame.setLocation(0, 300);
		main.frame.setVisible(true);
		main.start();
		main.start();
		//Test for git hub   njk
	}

}
