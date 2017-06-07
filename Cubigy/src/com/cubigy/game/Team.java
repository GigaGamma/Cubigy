package com.cubigy.game;

import java.awt.Color;
import java.util.ArrayList;

public class Team {
	
	public static ArrayList<Team> teams = new ArrayList<Team>();
	
	public static final Team BLUE = new Team("Blue", Color.BLUE);
	public static final Team RED = new Team("Red", Color.RED);
	
	private String name;
	private Color color;
	
	public Team(String name, Color color) {
		setName(name);
		setColor(color);
		
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
	
}
