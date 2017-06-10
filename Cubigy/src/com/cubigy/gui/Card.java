package com.cubigy.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Card extends Widget implements ClickableGUI {

	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = -299500751194907259L;
	
	private TextDisplay title;
	private TextDisplay text;
	private Color cardColor = Color.WHITE;

	public Card(String title, String[] text, int displayX, int displayY) {
		super(displayX, displayY);
		
		setTitle(new TextDisplay(title, getDisplayX() + 30, getDisplayY()));
		setText(new TextDisplay("", getDisplayX() + 30, getDisplayY() + 80));
		
		getText().setText(text);
		
		getTitle().setFont(new Font(getTitle().getFont().getFontName(), Font.BOLD, 70));
		getText().setFont(new Font(getTitle().getFont().getFontName(), Font.PLAIN, 30));
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getCardColor());
		
		getTitle().draw(g);
		getText().draw(g);
		
		setWidth(getTitle().getWidth() + getText().getWidth());
		setHeight(getTitle().getHeight() + getText().getHeight());
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(getDisplayX(), getDisplayY() - 30, getWidth() + 30, getHeight() + 30, 15, 15);
	}

	@Override
	public void onClick() {
		
	}

	public TextDisplay getTitle() {
		return title;
	}

	public void setTitle(TextDisplay title) {
		this.title = title;
	}

	public TextDisplay getText() {
		return text;
	}

	public void setText(TextDisplay text) {
		this.text = text;
	}

	public Color getCardColor() {
		return cardColor;
	}

	public void setCardColor(Color cardColor) {
		this.cardColor = cardColor;
	}

}
