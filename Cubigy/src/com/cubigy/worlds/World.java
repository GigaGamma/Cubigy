package com.cubigy.worlds;

import java.io.Serializable;
import java.util.ArrayList;

import com.cubigy.game.Team;
import com.cubigy.gui.TextDisplay;
import com.cubigy.networking.Server;
import com.cubigy.squares.CapitalSquare;
import com.cubigy.squares.Square;
import com.cubigy.units.Barbarian;
import com.cubigy.units.Unit;

public class World implements Serializable {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = 1628673058779930589L;
	
	public ArrayList<Square> tiles = new ArrayList<Square>();
	public ArrayList<Unit> units = new ArrayList<Unit>();
	
	private int width = 10000;
	private int height = 10000;
	
	public World() {
		
	}
	
	public void addTileToWorld(Square square) {
		tiles.add(square);
	}
	
	public void addUnitToWorld(Unit unit) {
		units.add(unit);
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
	
}
