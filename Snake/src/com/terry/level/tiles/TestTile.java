package com.terry.level.tiles;

import com.terry.gfx.Render;
import com.terry.gfx.Sprite;
import com.terry.level.Tile;

public class TestTile extends Tile {

	public TestTile(int id) {
		super(id);
	}
	
	public void render(int x, int y, Render render) {
		render.render(x*Sprite.TSIZE, y*Sprite.TSIZE, false, false, Sprite.test);
	}

}
