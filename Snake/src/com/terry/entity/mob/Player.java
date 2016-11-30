package com.terry.entity.mob;

import com.terry.gfx.Render;
import com.terry.gfx.Sprite;
import com.terry.input.Keyboard;

public class Player extends Mob {

	private Keyboard key;

	public Player(int x, int y, Keyboard key) {
		this.x = x;
		this.y = y;
		this.key = key;
		dir = 1;
	}

	public void tick() {
		int xa = 0, ya = 0;
		if (key.up) dir = 4;
		if (key.down) dir = 3;
		if (key.left) dir = 2;
		if (key.right) dir = 1;

		if (dir == 1) xa++;
		if (dir == 2) xa--;
		if (dir == 3) ya++;
		if (dir == 4) ya--;

		if (xa != 0 || ya != 0) {
			move(xa, 0);
			move(0, ya);
		}
	}

	public void render(Render render) {
		if (dir == 2) {
			render.render(x, y, true, false, Sprite.player);
		} else if (dir == 1) {
			render.render(x, y, false, false, Sprite.player);
		}

		if (dir == 4) {
			render.render(x, y, false, false, Sprite.player_up);
		} else if (dir == 3) {
			render.render(x, y, false, false, Sprite.player_down);
		}
	}

}
