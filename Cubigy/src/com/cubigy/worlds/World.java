package com.cubigy.worlds;

import java.io.Serializable;
import java.util.ArrayList;

import com.cubigy.game.Team;
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
	
	public Team team = Team.BLUE;
	
	public World() {
		addTileToWorld(new CapitalSquare(-500, -500, team));
		addUnitToWorld(new Barbarian(10, 10, team));
	}
	
	public void addTileToWorld(Square square) {
		tiles.add(square);
	}
	
	public void addUnitToWorld(Unit unit) {
		units.add(unit);
	}
	
}
