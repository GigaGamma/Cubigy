package com.cubigy.util;

import com.cubigy.squares.Square;
import com.cubigy.units.Unit;

public class Camera {
	
	public static void move(int x, int y) {
		for (Square s : Square.squares) {
			s.setDisplayX(s.getDisplayX() + x);
			s.setDisplayY(s.getDisplayY() + y);
		}
		for (Unit u : Unit.units) {
			u.setDisplayX(u.getDisplayX() + x);
			u.setDisplayY(u.getDisplayY() + y);
		}
	}
	
}
