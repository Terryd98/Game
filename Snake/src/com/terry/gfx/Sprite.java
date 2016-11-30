package com.terry.gfx;

public class Sprite {

	public final int SIZE;
	public static final int TSIZE = 8;
	public int x, y;
	private SpriteSheet sheet;
	public int[] pixels;

	public static Sprite test = new Sprite(TSIZE, 0, 0, SpriteSheet.sheet);
	public static Sprite red = new Sprite(TSIZE, 1, 0, SpriteSheet.sheet);
	public static Sprite green = new Sprite(TSIZE, 2, 0, SpriteSheet.sheet);
	public static Sprite cyan = new Sprite(TSIZE, 3, 0, SpriteSheet.sheet);
	public static Sprite blue = new Sprite(TSIZE, 4, 0, SpriteSheet.sheet);
	public static Sprite magenta = new Sprite(TSIZE, 5, 0, SpriteSheet.sheet);


	public static Sprite void_Sprite = new Sprite(TSIZE, 0x272727);

	public static Sprite player = new Sprite(TSIZE * 2, 0, 7, SpriteSheet.sheet);
	public static Sprite player_up = new Sprite(TSIZE * 2, 1, 7, SpriteSheet.sheet);
	public static Sprite player_down = new Sprite(TSIZE * 2, 2, 7, SpriteSheet.sheet);


	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE];
		load();
	}

	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}
	}

	public void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
