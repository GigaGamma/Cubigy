package com.cubigy.worlds;

import java.util.ArrayList;

import com.cubigy.game.Team;
import com.cubigy.networking.Server;
import com.cubigy.squares.CapitalSquare;
import com.cubigy.squares.Square;
import com.cubigy.units.Barbarian;
import com.cubigy.units.Unit;

public class World extends Server {
	
	public ArrayList<Square> tiles = new ArrayList<Square>();
	public ArrayList<Unit> units = new ArrayList<Unit>();
	
	public Team team = Team.BLUE;
	
	public World() {
		addTileToWorld(new CapitalSquare(300, 300, team));
		addUnitToWorld(new Barbarian(500, 500, team));
	}
	
	public void addTileToWorld(Square square) {
		tiles.add(square);
	}
	
	public void addUnitToWorld(Unit unit) {
		units.add(unit);
	}
	
	public void renderWorld() {
		for (Square s : tiles) {
			s.update();
		}
		for (Unit u : units) {
			u.update();
		}
	}
	
}
