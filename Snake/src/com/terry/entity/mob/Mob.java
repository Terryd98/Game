package com.terry.entity.mob;

import com.terry.entity.Entity;
import com.terry.gfx.Render;
import com.terry.gfx.Sprite;

public class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (!collision()) {
			x += xa;
			y += ya;
		}
	}

	public void tick() {
	}

	public void render(int x, int y, Render render) {

	}

	private boolean collision() {
		return false;
	}

}
