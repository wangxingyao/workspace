package com.yaoge;

import java.io.IOException;

import javax.swing.*;


public class Test extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	public static void main(String[] args) throws IOException {
		Game game = new Game();
    	game.action();
    }    
}
