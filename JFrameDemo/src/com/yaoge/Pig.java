package com.yaoge;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pig extends Thread {
	public static final int Living = 1;
	public static final int Dying = 2;
	public static final int Dead = 4;
	
	private BufferedImage pigImage;
	private BufferedImage image;
	Bubble bubble;
	private double x;
	private double y;
	private int width;
	private int height;
	int status;
	
	public Pig(int x, int y) throws IOException {
		pigImage = ImageIO.read(new File("images/ABC/pigs.png"));
		image = pigImage;
		bubble = new Bubble(0, 0);
		
		this.x = x;
		this.y = y;
		width = image.getWidth();
		height = image.getHeight();
		status = Living;
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
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getBubbleX() {
		return getCenterX() - bubble.getImage().getWidth() / 2;
	}
	public int getBubbleY() {
		return getCenterY() - bubble.getImage().getHeight() / 2;
	}
	
	// 线程方法，系统自动调用
	public void run() {
		while (true) {
			try {
				if (status == Living) {
				
				} else if (status == Dying) {
					int pN = bubble.changeImage();
					Thread.sleep(50);
					if (pN == Bubble.pL-1) {
						status = Dead;
					}
				} else if (status == Dead) {
					
				}
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
