package com.yaoge;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bubble extends Thread {
	public static final int[][] pos = {
		{956, 253, 40, 39},
		{851, 930, 46, 44},
		{41, 826, 114, 110},
		{41, 591, 125, 120},
		{41, 466, 126, 123},
		{449, 156, 127, 121}
	};
	public static final int pL = pos.length;
	
	public int pN;
	private BufferedImage originImage;
	private BufferedImage image;
	private int centerX;
	private int centerY;
	
	public Bubble(int centerX, int centerY) throws IOException {
		originImage = ImageIO.read(new File("images/ABC/INGAME_BIRDS_1.png"));
		
		image = originImage.getSubimage(pos[0][0], pos[0][1], pos[0][2], pos[0][3]);
		pN = -1;
		
		this.centerX = centerX;
		this.centerY = centerY;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	public int getX() {
		return centerX - image.getWidth() / 2;
	}
	public int getY() {
		return centerY - image.getHeight() / 2;
	}
	public int getCenterX() {
		return centerX;
	}
	public int getCenterY() {
		return centerY;
	}
	public void setCenterPostion(int centerX, int centerY) {
		this.centerX = centerX;
		this.centerY = centerY;
	}
	public int changeImage() {
		pN++;
		if (pN >= pL) {
			pN = pL-1;
		}
		image = originImage.getSubimage(pos[pN][0], pos[pN][1], pos[pN][2], pos[pN][3]);
		return pN;
	}

}
