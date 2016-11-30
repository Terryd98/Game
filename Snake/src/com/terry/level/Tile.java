package com.terry.level;

import com.terry.gfx.Render;
import com.terry.level.tiles.BlueTile;
import com.terry.level.tiles.CyanTile;
import com.terry.level.tiles.GreenTile;
import com.terry.level.tiles.MagentaTile;
import com.terry.level.tiles.RedTile;
import com.terry.level.tiles.TestTile;
import com.terry.level.tiles.VoidTile;

public class Tile {

	public static Tile[] tiles = new Tile[256];
	public int x, y;
	public int id;

	public static Tile test_Tile = new TestTile(0);
	public static Tile void_Tile = new VoidTile(1);
	
	public static Tile red = new RedTile(2);
	public static Tile green = new GreenTile(3);
	public static Tile cyan = new CyanTile(4);
	public static Tile blue = new BlueTile(5);
	public static Tile magenta = new MagentaTile(6);

	
	public Tile(int id) {
		this.id = id;
		tiles[id] = this;
	}

	public void render(int x, int y, Render render) {
	}

}
