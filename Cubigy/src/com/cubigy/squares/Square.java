package com.cubigy.squares;

import java.awt.Graphics;
import java.util.ArrayList;

import com.cubigy.game.Cubigy;
import com.cubigy.game.Team;
import com.cubigy.gui.Button;
import com.cubigy.gui.TextDisplay;

public class Square {
	
	public static ArrayList<Square> squares = new ArrayList<Square>();
	
	private int x;
	private int y;
	private int displayX;
	private int displayY;
	
	private boolean selected = false;
	private String name;
	private TextDisplay text;
	private Button opengui;
	
	private Team team;
	
	public Square(String name, int x, int y, Team team) {
		setX(x);
		setY(y);
		setDisplayX(x);
		setDisplayY(y);
		setName(name);
		setTeam(team);
		squares.add(this);
		
		setText(new TextDisplay(getName(), getDisplayX() + 10, getDisplayY()));
		opengui = new Button("Manage", getDisplayX() + 55, getDisplayY() + getText().getHeight() + 20);
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public TextDisplay getText() {
		return text;
	}

	public void setText(TextDisplay text) {
		this.text = text;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void update() {
		draw(Cubigy.getInstance().background.getGraphics());
		if (isSelected()) {
			onSquareSelect();
		}
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void onUnitInSquare() {
		
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
	
	public void onSquareSelect() {
		getText().setDisplayX(getDisplayX() + 55);
		getText().setDisplayY(getDisplayY() + 5);
		opengui.setDisplayX(getDisplayX() + 55);
		opengui.setDisplayY(getDisplayY() + getText().getHeight() + 20);
		
		getText().draw(Cubigy.getInstance().background.getGraphics());
		if (getTeam() == Cubigy.getInstance().team) {
			opengui.draw(Cubigy.getInstance().background.getGraphics());
		}
	}
	
}
