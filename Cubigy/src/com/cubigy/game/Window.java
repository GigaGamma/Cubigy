package com.cubigy.game;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends JFrame {
	
	private static final long serialVersionUID = -4280497867448417332L;

	public void init() throws IOException {
		setExtendedState(MAXIMIZED_BOTH); 
		setUndecorated(true);
		setSize(2000, 2000);
		setResizable(false);
		
		setIconImage(ImageIO.read(ClassLoader.getSystemResource("images/logo.png")));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		new Cubigy(this);
	}
	
}
