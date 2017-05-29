package com.cubigy.gui;

import java.awt.Graphics;

public class Button extends TextDisplay implements ClickableGUI {
	
	public Button(String text, int displayX, int displayY) {
		super(text, displayX, displayY);
	}

	@Override
	public void onClick() {
		System.out.println("A");
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(getDisplayX(), getDisplayY(), getWidth(), getHeight());
		
		super.draw(g);
	}

}
