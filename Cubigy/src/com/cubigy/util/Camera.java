package com.cubigy.util;

import com.cubigy.gui.GameScreen;
import com.cubigy.squares.Square;
import com.cubigy.units.Unit;

public class Camera {
	
	public static void move(int x, int y) {
		GameScreen.xOffset += x;
		GameScreen.yOffset += y;
	}
	
}
