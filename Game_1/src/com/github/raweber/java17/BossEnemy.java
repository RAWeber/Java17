package com.github.raweber.java17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObject {

	Random r = new Random();
	private int timer = 75;
	private int timer2 = 50;

	public BossEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		velX = 0;
		velY = 2;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 96, 96);
	}

	public void tick() {
		x += velX;
		y += velY;

		if (timer <= 0)
			velY = 0;
		else
			timer--;

		if (timer <= 0)
			timer2--;
		if (timer2 <= 0) {
			if (velX == 0)
				velX = 2;

			if (velX > 0)
				velX += 0.005;
			else if (velX < 0)
				velX -= 0.005;

			//velX = Game.clamp(velX, -10, 10);

			int spawn = r.nextInt(10);
			if (spawn == 0)
				handler.addObject(new BulletEnemy((int) x + 48, (int) y + 48,
						ID.BossEnemy, handler));
		}

		if (x <= 0 || x >= Game.WIDTH - 96)
			velX *= -1;

		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.03,
				handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 96, 96);
	}
}
