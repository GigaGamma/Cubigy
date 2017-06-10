package com.cubigy.game;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = -8644267244137705369L;

	public static ArrayList<Team> teams = new ArrayList<Team>();
	
	public static final Team BLUE = new Team("Blue", Color.BLUE);
	public static final Team RED = new Team("Red", Color.RED);
	
	private String name;
	private Color color;
	private String uniqueId;
	
	public Team(String name, Color color) {
		setName(name);
		setColor(color);
		
		setUniqueId(String.valueOf(color.getRed()) + String.valueOf(color.getGreen()) + String.valueOf(color.getBlue()));
		
		teams.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
}
