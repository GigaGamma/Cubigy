package com.cubigy.units;

import java.awt.Color;

import com.cubigy.game.Team;

public class Barbarian extends Unit {

	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = -4816394597780354714L;

	public Barbarian(int x, int y, Team team) {
		super("Barbarian", x, y, 50, Color.RED, team);
	}
	
	@Override
	public void update() {
		super.update();
	}

}
