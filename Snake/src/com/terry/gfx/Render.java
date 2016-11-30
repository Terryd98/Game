package com.terry.gfx;

public class Render {

	public int width, height;
	public int[] pixels;
	private int xOffset = 0, yOffset = 0;

	public Render(int width, int height, int[] pixels) {
		this.pixels = pixels;
		this.width = width;
		this.height = height;
	}

	public void clear() {
		for (int i = 0; i < width; i++) {
			pixels[i] = 0;
		}
	}

	public void render(int xp, int yp, boolean xFlip, boolean yFlip, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			int ys = y;
			if (yFlip) ys = ((sprite.SIZE - 1)) - y;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				int xs = x;
				if (xFlip) xs = ((sprite.SIZE - 1)) - x;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * sprite.SIZE];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}

	public void setOffset(int xOff, int yOff) {
		this.xOffset = xOff;
		this.yOffset = yOff;
	}

}
