package com.cubigy.gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class TextDisplay extends Widget {

	private String[] text;
	private Font font = new Font("Century Gothic", Font.PLAIN, 20);
	
	public TextDisplay(String text, int displayX, int displayY) {
		super(displayX, displayY);
		
		setText(text);
	}
	
	@Override
	public void draw(Graphics g) {
		int w = 0;
		int h = 0;
		for (int i = 0; i < text.length; i++) {
			String t = text[i];
			g.setFont(getFont());
			g.drawString(t, getDisplayX(), getDisplayY() + (i * 20) + getFont().getSize() - 3);
			
			FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
			
			w += (int)(font.getStringBounds(t, frc).getWidth());
			h += (int)(font.getStringBounds(t, frc).getHeight());
		}
		setWidth(w);
		setHeight(h);
	}
	
	public String[] getText() {
		return text;
	}
	
	public void setText(String[] text) {
		this.text = text;
	}
	
	public void setText(String text) {
		this.text = new String[] {text};
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
	
}
