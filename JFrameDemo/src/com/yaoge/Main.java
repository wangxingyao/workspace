package com.yaoge;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 捕鱼项目界面类
 */
public class Main {
	public static void main(String[] args) {

		JFrame frame = new JFrame("捕鱼达人"); // 创建一个窗体
		frame.setSize(800, 510); // 设置窗体的大小
		frame.setResizable(false); // 禁止窗口最大化
		frame.setLocationRelativeTo(null); // 让窗体居中
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体默认关闭事件
		Pool pool = new Pool(); // 创建鱼池对象
		frame.add(pool); // 将鱼池添加到窗体上
		frame.setVisible(true); // 显示窗体
		pool.action(); // 调用鱼池的控制方法
	}
}

/**
 * 捕鱼项目的鱼池,及捕鱼控制程序
 */
class Pool extends JPanel {
	BufferedImage background; // 背景图
	Fish[] fishes; // 声明一个鱼的数组
	Net net; // 声明一个渔网
	int count; // 计数
	int score; // 计分

	/** Pool类的构造方法, 用来给背景、鱼、网进行赋值 */
	public Pool() {
		try {
			background = ImageIO.read(new File("images/background.png")); // 加载背景图片
			fishes = new Fish[9 + 9 + 9 + 2]; // 创建鱼数组,长度29
			for (int i = 0; i < 9; i++) { // 创建鱼对象,并放入数组
				fishes[i] = new Fish("fish0" + (i + 1));
				fishes[i + 9] = new Fish("fish0" + (i + 1));
				fishes[i + 9 + 9] = new Fish("fish0" + (i + 1));
			}
			fishes[fishes.length - 2] = new Fish("fish13");
			fishes[fishes.length - 1] = new Fish("fish14");
			net = new Net(); // 创建渔网对象

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 绘图方法,系统自动调用 */
	public void paint(Graphics g) {

		g.drawImage(background, 0, 0, null); // 绘制背景图片
		for (int i = 0; i < fishes.length; i++) { // 绘制数组中所有的鱼
			g.drawImage(fishes[i].image, fishes[i].x, fishes[i].y, null);
		}

		/** 通过渔网中心点x,y，计算渔网的位置，并将渔网绘制出来 */
		if (net.show) {
			int x = net.x - net.width / 2;
			int y = net.y - net.height / 2;
			g.drawImage(net.image, x, y, null);
		}

		/** 绘制捕鱼的数量和分数 */
		Font f = new Font("", Font.BOLD, 30);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.drawString("count:" + count, 20, 30);
		g.drawString("score:" + score, 20, 60);
	}

	/** 在Pool类中增加捕鱼方法 */
	public void catchFish() {
		for (int i = fishes.length - 1; i >= 0; i--) {
			/** 判断鱼是否被捕获 */
			if (net.catchThe(fishes[i])) {
				count++; // 计数
				if (fishes[i].width > 100) { // 计分
					score += 15;
				} else {
					score += fishes[i].width / 10;
				}
				fishes[i].catched = true; // 鱼属性catched=true;
				break; // 退出循环
			}
		}
	}

	/** 控制鱼游动的方法 */
	public void action() {
		// 鼠标事件类
		MouseAdapter ma = new MouseAdapter() {
			// 鼠标按下
			@Override
			public void mousePressed(MouseEvent e) {
				catchFish();// 在Pool中增加捕鱼方法
			}

			// 鼠标进入
			@Override
			public void mouseEntered(MouseEvent e) {
				net.show = true;
			}

			// 鼠标移出
			@Override
			public void mouseExited(MouseEvent e) {
				net.show = false;
			}

			// 鼠标移动
			@Override
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				net.moveTo(x, y);
			}
		};
		
		/** 添加鼠标监听事件 */
		this.addMouseListener(ma);// 鼠标事件
		this.addMouseMotionListener(ma);// 拖动事件
		// 启动线程
		for (int i = 0; i < fishes.length; i++) {
			fishes[i].start();
		}
		while (true) {
			repaint();// 重新绘制界面
			try {
				Thread.sleep(20); // 线程休眠20ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 鱼对象类
 */
class Fish extends Thread { // 将鱼作为一个独立线程
	BufferedImage[] images; // 鱼图片的数组
	BufferedImage image; // 鱼显示的当前图片
	int width; // 鱼图片的宽度
	int height; // 鱼图片的高度
	int x; // 鱼的x坐标
	int y; // 鱼的y坐标
	int step; // 鱼游动的速度
	int index; // 鱼图片轮转
	boolean catched; // 鱼是否被捕获
	BufferedImage catch01;
	BufferedImage catch02;

	/** Fish类的构造方法，用来给属性赋值 */
	public Fish(String name) throws Exception {
		// 创建鱼图片数组
		images = new BufferedImage[10];
		// 加载每条鱼的10张图片，并放入数组
		for (int i = 0; i < 10; i++) {
			String file = "images/" + name + "_0" + i + ".png";
			images[i] = ImageIO.read(new File(file));
		}
		image = images[0]; // 将数组的第一张图片赋给当前图片
		width = image.getWidth(); // 获取当前图片的宽度
		height = image.getHeight(); // 获取当前图片的高度
		Random r = new Random();
		x = r.nextInt(800 - width); // 给鱼的x坐标赋值
		y = r.nextInt(480 - height); // 给鱼的y坐标赋值
		step = r.nextInt(5) + 1; // 初始化鱼的速度(1~5)
		index = 0; // 图片轮转的初始值为0
		catched = false;
		catch01 = ImageIO.read(new File("images/" + name + "_catch_01.png"));
		catch02 = ImageIO.read(new File("images/" + name + "_catch_02.png"));
	}

	/** 鱼游动的方法 */
	public void move() {
		index++; // 鱼游动时10张图片轮转,达到游动效果
		image = images[index % images.length];
		x -= step; // 让鱼从右向左游动
		if (x < -width) { // 当鱼游出界面,重新从右边进入
			x = 800;
			Random r = new Random();
			y = r.nextInt(480 - height);
			step = r.nextInt(5) + 1;
		}
	}

	// 线程方法，系统自动调用
	public void run() {
		while (true) {
			try {
				// 如果鱼被捕获
				if (catched) {
					turnOver(); // 1、原地翻腾
					catched = false; // 2、catched=false;
					getOut(); // 3、鱼消失
				} else {
					move(); // 否则鱼继续游动
					Thread.sleep(100);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/** 鱼原地翻腾的方法 */
	public void turnOver() {
		try {
			for (int i = 0; i < 5; i++) {
				image = catch01;
				Thread.sleep(100);
				image = catch02;
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 鱼滚出界面 */
	public void getOut() {
		x = 800;
		Random r = new Random();
		y = r.nextInt(480 - height);
		step = r.nextInt(5) + 1;
	}
}

class Net {
	BufferedImage image; // 渔网的图片
	int width; // 渔网的宽度
	int height; // 渔网的高度
	int x; // 渔网的中心点x坐标
	int y; // 渔网的中心点y坐标
	boolean show; // 渔网是否显示

	/** Net类构造方法,用来给网的属性赋值 */
	public Net() throws Exception {
		image = ImageIO.read( // 加载网的图片
				new File("images/net09.png"));
		width = image.getWidth(); // 获取图片的宽度
		height = image.getHeight(); // 获取图片的高度
		Random r = new Random();
		x = r.nextInt(800 - width); // 设置网第一次出现时的x坐标
		y = r.nextInt(480 - height); // 设置网第一次出现时的y坐标
		show = true; // 程序一开始让渔网处于显示状态
	}

	/** 渔网移动的方法 将渔网新位置的x,y 赋值给渔网的x,y属性 */
	public void moveTo(int x, int y) {
		this.x = x; // this.x表示渔网的属性,x表示渔网的新位置x坐标
		this.y = y; // this.y表示渔网的属性,y表示渔网的新位置y坐标
	}

	/** 判断鱼是否被捕获 判断网的中心点是否在鱼图片之上 如果被捕获就返回true 否则返回false */
	public boolean catchThe(Fish fish) {
		int dx = x - fish.x;
		int dy = y - fish.y;
		return dx > 0 && dx < fish.width && dy > 0 && dy < fish.height;
	}
}