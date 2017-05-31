package com.cubigy.gui;

import java.awt.Graphics;

import com.cubigy.squares.Square;
import com.cubigy.units.Unit;

public class GameScreen extends Screen {

	public GameScreen(Graphics g) {
		super(g);
	}
	
	@Override
	public void draw() {
		for (Square s : Square.squares) {
			s.update();
		}
		for (Unit u : Unit.units) {
			u.update();
		}
	}

}
