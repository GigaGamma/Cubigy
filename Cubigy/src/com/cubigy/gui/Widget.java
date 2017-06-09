package com.cubigy.gui;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import com.cubigy.game.Cubigy;

public class Widget implements Serializable {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = 4453910033742336032L;

	public static ArrayList<Widget> widgets = new ArrayList<Widget>();
	
	private int displayX;
	private int displayY;
	private int width;
	private int height;
	
	public Widget(int displayX, int displayY) {
		setDisplayX(displayX);
		setDisplayY(displayY);
		widgets.add(this);
	}
	
	public int getDisplayX() {
		return displayX;
	}

	public void setDisplayX(int displayX) {
		this.displayX = displayX;
	}

	public int getDisplayY() {
		return displayY;
	}

	public void setDisplayY(int displayY) {
		this.displayY = displayY;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void update() {
		
	}
	
	public void draw(Graphics g) {
		
	}
	
}
