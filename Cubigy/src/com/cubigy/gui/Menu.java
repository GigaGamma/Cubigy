package com.cubigy.gui;

import java.awt.Font;
import java.awt.Graphics;

import com.cubigy.game.Cubigy;

public class Menu extends Screen {
	
	public Button play;
	
	public Menu(Graphics g) {
		super(g);
		this.play = new Button("Play", 200, 300);
		this.play.setFont(new Font(this.play.getFont().getFontName(), Font.PLAIN, 200));
	}
	
	@Override
	public void draw() {
		play.draw(getGraphics());
	}
	
}
