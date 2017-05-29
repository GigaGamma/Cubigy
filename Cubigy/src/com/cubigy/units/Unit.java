package com.cubigy.units;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.cubigy.game.Cubigy;

public class Unit {
	
	public static ArrayList<Unit> units = new ArrayList<Unit>();
	
	private String name;
	private float maxHealth;
	private float health;
	
	private int x;
	private int y;
	private int displayX;
	private int displayY;
	private int width;
	private int height;
	
	private Color color;
	private boolean selected = false;
	
	public Unit(String name, int x, int y, float maxHealth, Color color) {
		setName(name);
		setX(x);
		setY(y);
		setDisplayX(x);
		setDisplayY(y);
		setWidth(15);
		setHeight(15);
		setMaxHealth(maxHealth);
		setColor(color);
		
		units.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(float maxHealth) {
		this.maxHealth = maxHealth;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
		this.health = health;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void update() {
		draw(Cubigy.getInstance().background.getGraphics());
		
		if (isSelected() && Cubigy.getInstance().input.mouseEvent != null && Cubigy.getInstance().input.mouseEvent.getButton() == 3) {
			setX(Cubigy.getInstance().input.mouseEvent.getX());
			setY(Cubigy.getInstance().input.mouseEvent.getY());
			setDisplayX(Cubigy.getInstance().input.mouseEvent.getX());
			setDisplayY(Cubigy.getInstance().input.mouseEvent.getY());
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(getDisplayX(), getDisplayY(), 15, 15);
	}
	
	public void select() {
		selected = true;
	}
	
	public void deselect() {
		selected = false;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
}
