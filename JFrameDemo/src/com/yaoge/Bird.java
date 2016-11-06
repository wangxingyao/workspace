package com.yaoge;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Bird extends Thread {
	private BufferedImage image;
	private double x;
	private double y;
	private double vx;
	private double vy;
	private int width;
	private int height;
	private int bgw;
	private int bgh;
	boolean isCatched;
	boolean isMoving;
	boolean isStatic;
	
	public Bird(int centerX, int centerY, int bgw, int bgh) throws IOException {
		image = ImageIO.read(new File("images/ABC/birds.png"));
		vx = vy = 0;
		width = image.getWidth();
		height = image.getHeight();
		this.x = centerX - width/2;
		this.y = centerY - height/2;
		this.bgw = bgw;
		this.bgh = bgh;
		isCatched = false;
		isMoving = false;
		isStatic = true;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	public int getX() {
		return (int)x;
	}
	public int getY() {
		return (int)y;
	}
	public int getCenterX() {
		return (int)x + width / 2;
	}
	public int getCenterY() {
		return (int)y + height / 2;
	}
	public void setCenterPosition(int centerX, int centerY) {
		x = centerX - width / 2;
		y = centerY - height / 2;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setVx(float vx) {
		this.vx = vx;
	}
	public void setVy(float vy) {
		this.vy = vy;
	}
	
	public void move() {
		vy += 0.25;
		double v = Math.sqrt(vx*vx + vy*vy);
		double newV = v-0.1;
		if (newV < 0) {
			vx = vy = 0;
			isStatic = true;
		} else {
			vx *= newV / v;
			vy *= newV / v;
			x += vx;
			y += vy;
			//System.out.println("("+vx+", "+vy+")");
		}
	}
	
	public void moveTo(int centerX, int centerY) {
		this.x = centerX - width / 2;
		this.y = centerY - height / 2;
	}
	
	public boolean catchCursor(int x, int y) {
		int dx = x - (int)this.x;
		int dy = y - (int)this.y;
		return (dx > 0 && dx < width) && (dy > 0 && dy < height);
	}

	// 线程方法，系统自动调用	
	public void run() {
		while (true) {
			try {
				if (isMoving) {
					if (x < 0) {
						vx = -vx;
						x = 0;
					} else if (x > bgw - width) {
						vx = -vx;
						x = bgw - width;
					}
					if (y < 0) {
						vy = -vy;
						y = 0;
					} else if (y > bgh - height) {
						vy = -vy;
						y = bgh - height;
					}
					move();
				}
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
