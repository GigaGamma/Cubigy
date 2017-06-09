package com.cubigy.gui;

import java.awt.Graphics;

public class Button extends TextDisplay implements ClickableGUI {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = -6673448231928422325L;

	public Button(String text, int displayX, int displayY) {
		super(text, displayX, displayY);
	}

	@Override
	public void onClick() {
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(getDisplayX(), getDisplayY(), getWidth(), getHeight());
		
		super.draw(g);
	}

}
