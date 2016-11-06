package com.yaoge;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel bottomPane = null; // 主要的JPanel，该JPanel的布局管理将被设置成CardLayout
    private CardLayout card = null; // CardLayout布局管理器
    private IndexPanel indexPanel = null;
    private GamePanel gamePanel = null;
    private JPanel p_1 = null, p_2 = null, p_3 = null; // 要切换的三个JPanel

    public Game() throws IOException {
        super("Angry Bird");
        /**创建一个具有指定的水平和垂直间隙的新卡片布局*/
        card = new CardLayout(0, 0);
        bottomPane = new JPanel(card); // JPanel的布局管理将被设置成CardLayout
        indexPanel = new IndexPanel();
        gamePanel  = new GamePanel(3);
        p_1 = new JPanel();
        p_2 = new JPanel();
        p_3 = new JPanel();
        bottomPane.setBackground(Color.PINK);
        p_1.setBackground(Color.RED);
        p_2.setBackground(Color.BLUE);
        p_3.setBackground(Color.GREEN);
        p_1.add(new JLabel("JPanel_1"));
        p_2.add(new JLabel("JPanel_2"));
        p_3.add(new JLabel("JPanel_3"));
        bottomPane.add(indexPanel, "indexPanel");
        bottomPane.add(gamePanel, "gamePanel");
        bottomPane.add(p_1, "p1");
        bottomPane.add(p_2, "p2");
        bottomPane.add(p_3, "p3");
        /**下面是翻转到卡片布局的某个组件，可参考API中的文档*/
//        card.previous(bottomPane);
//        card.next(bottomPane);
//        card.show(bottomPane, "p1");
        
        this.getContentPane().add(bottomPane);
        
        this.setResizable(false); 								// 禁止窗口最大化
        this.setUndecorated(true);								// 去掉标题栏
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// 设置窗体默认关闭事件
        this.setSize(gamePanel.getPanelWidth(), gamePanel.getPanelHeight());	// 设置窗体的大小
        this.setLocationRelativeTo(null); 						// 让窗体居中
        this.setVisible(true);
    }
    
    public void changeGamePanel() {
    	card.show(bottomPane, "gamePanel");
    }
    public void changeP1() {
    	card.show(bottomPane, "p1");    	
    }
    public void changeP2() {
    	card.show(bottomPane, "p2");
    }
    public void changeP3() {
    	card.show(bottomPane, "p3");    	
    }

    public void action() throws IOException {
    	String targetPanel = "indexPanel";
    	while (true) {
    		if (targetPanel == "indexPanel") {
    			targetPanel = indexPanel.action();
    		} else if (targetPanel == "gamePanel") {
    			targetPanel = gamePanel.action();
    		} else {
    			targetPanel = "indexPanel";
    			System.out.println("change Panel error");
    		}
    	 	card.show(bottomPane, targetPanel);
    	     		
   			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
}
