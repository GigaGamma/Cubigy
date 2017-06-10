package com.cubigy.squares;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import com.cubigy.game.Cubigy;
import com.cubigy.game.Team;
import com.cubigy.gui.Button;
import com.cubigy.gui.GameScreen;
import com.cubigy.gui.TextDisplay;

public class Square implements Serializable {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = -6231753471823858435L;

	public static ArrayList<Square> squares = new ArrayList<Square>();
	
	private int x;
	private int y;
	
	private boolean selected = false;
	private String name;
	private TextDisplay text;
	public Button opengui;
	
	private Team team;
	
	public Square(String name, int x, int y, Team team) {
		setX(x);
		setY(y);
		setName(name);
		setTeam(team);
		squares.add(this);
		
		setText(new TextDisplay(getName(), getX() + GameScreen.xOffset + 10, getY() + GameScreen.yOffset));
		opengui = new Button("Manage", getX() + GameScreen.xOffset + 55, getY() + GameScreen.yOffset + getText().getHeight() + 20);
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
		g.setColor(Cubigy.getInstance().team.getColor());
		g.fillRoundRect(getX() + GameScreen.xOffset, getY() + GameScreen.yOffset, 50, 50, 10, 10);
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
		getText().setDisplayX(getX() + GameScreen.xOffset + 55);
		getText().setDisplayY(getY() + GameScreen.yOffset + 5);
		opengui.setDisplayX(getX() + GameScreen.xOffset + 55);
		opengui.setDisplayY(getY() + GameScreen.yOffset + getText().getHeight() + 20);
		
		getText().draw(Cubigy.getInstance().background.getGraphics());

		if (getTeam().getName().equals(Cubigy.getInstance().team.getName())) {
			opengui.draw(Cubigy.getInstance().background.getGraphics());
		}
	}
	
}
