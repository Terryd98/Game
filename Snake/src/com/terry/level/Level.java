package com.terry.level;

import java.util.Random;

import com.terry.gfx.Render;
import com.terry.gfx.Sprite;

public class Level {

	public int width, height;
	public int[] tilesInt;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	Random random = new Random();

	private void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (random.nextInt(20) == 0) {
					tilesInt[x + y * width] = Tile.red.id;
				} else {
					tilesInt[x + y * width] = Tile.blue.id;
				}
			}
		}
	}

	public void tick() {

	}

	public void render(int xScroll, int yScroll, Render render) {
		render.setOffset(xScroll, yScroll);
		int x0 = xScroll / Sprite.TSIZE -1;
		int x1 = (xScroll + render.width + Sprite.TSIZE) /Sprite.TSIZE;
		int y0 = yScroll / Sprite.TSIZE -1;
		int y1 = (yScroll + render.height + Sprite.TSIZE) / Sprite.TSIZE;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTiles(x, y).render(x, y, render);
			}
		}
	}
	
	public Tile getTiles(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.void_Tile;
		return Tile.tiles[tilesInt[x + y * width]];
	}

}
