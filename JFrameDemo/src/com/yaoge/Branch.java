package com.yaoge;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Branch {
	private BufferedImage leftBranch;
	private BufferedImage rightBranch;
	private int leftBranchX;
	private int leftBranchY;
	private int rightBranchX;
	private int rightBranchY;
	private float rate;
	
	
	public Branch(int x, int y, float rate) throws IOException {
		leftBranch = ImageIO.read(new File("images/pc/branch1.png"));
		rightBranch = ImageIO.read(new File("images/pc/branch2.png"));

		this.rate = rate;
		leftBranchX = x;
		leftBranchY = y;
		rightBranchX = leftBranchX + (int)(30*rate);
		rightBranchY = leftBranchY + (int)(10*rate);
	}
	
	public int getX() {
		return getLeftBranchX();
	}
	public int getY() {
		return getLeftBranchY();
	}
	public int getLeftBranchX() {
		return leftBranchX;
	}
	public int getLeftBranchY() {
		return leftBranchY;
	}
	public int getRightBranchX() {
		return rightBranchX;
	}
	public int getRightBranchY() {
		return rightBranchY;
	}
	public int getLeftBranchNodeX() {
		return leftBranchX + (int)(14*rate);
	}
	public int getLeftBranchNodeY() {
		return leftBranchY + (int)(36*rate);
	}
	public int getRightBranchNodeX() {
		return rightBranchX + (int)(27*rate);
	}
	public int getRightBranchNodeY() {
		return rightBranchY + (int)(30*rate);
	}
	public int getCenterX() {
		return (getLeftBranchNodeX() + getRightBranchNodeX()) / 2;
	}
	public int getCenterY() {
		return (getLeftBranchNodeY() + getRightBranchNodeY()) / 2;
	}
	public int getLeftBranchWidth() {
		return (int)(leftBranch.getWidth() * rate);
	}
	public int getLeftBranchHeight() {
		return (int)(leftBranch.getHeight() * rate);
	}
	public int getRightBranchWidth() {
		return (int)(rightBranch.getWidth() * rate);
	}
	public int getRightBranchHeight() {
		return (int)(rightBranch.getHeight() * rate);
	}
	public BufferedImage getLeftBranchImage() {
		return leftBranch;
	}
	public BufferedImage getRightBranchImage() {
		return rightBranch;
	}
}