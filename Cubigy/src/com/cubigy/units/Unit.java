package com.cubigy.units;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import com.cubigy.game.Cubigy;
import com.cubigy.game.Team;
import com.cubigy.gui.GameScreen;
import com.cubigy.networking.packets.ChatPacket;
import com.cubigy.networking.packets.WorldPacket;

public class Unit implements Serializable {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = -4849449703316186540L;

	public static ArrayList<Unit> units = new ArrayList<Unit>();
	
	private String name;
	private float maxHealth;
	private float health;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private Color color;
	private boolean selected = false;
	
	private Team team;
	
	public Unit(String name, int x, int y, float maxHealth, Color color, Team team) {
		setName(name);
		setX(x);
		setY(y);
		setWidth(15);
		setHeight(15);
		setMaxHealth(maxHealth);
		setColor(color);
		setTeam(team);
		
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
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void update() {
		draw(Cubigy.getInstance().background.getGraphics());
		
		if (isSelected() && Cubigy.getInstance().input.mouseEvent != null && Cubigy.getInstance().input.mouseEvent.getX() != getX() + GameScreen.xOffset && Cubigy.getInstance().input.mouseEvent.getButton() == 3 && getTeam().getUniqueId().equals(Cubigy.getInstance().team.getUniqueId())) {
			if (Cubigy.getInstance().currentScreen instanceof GameScreen) {
				((GameScreen) Cubigy.getInstance().currentScreen).getClient().handler.sendPacket(new ChatPacket("Hello"));
			}
			
			setX(getX() + (Cubigy.getInstance().input.mouseEvent.getX() - (getX() + GameScreen.xOffset)));
			setY(getY() + (Cubigy.getInstance().input.mouseEvent.getY() - (getY() + GameScreen.yOffset)));
		}
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Cubigy.getInstance().team.getColor());
		g2d.setStroke(new BasicStroke(10));
		g2d.drawOval(getX() + GameScreen.xOffset, getY() + GameScreen.yOffset, 15, 15);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(getColor());
		g2d.fillOval(getX() + GameScreen.xOffset, getY() + GameScreen.yOffset, 15, 15);
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
