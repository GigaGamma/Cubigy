package com.cubigy.util;

import java.awt.Color;
import java.util.Random;

public class ColorUtil {
	
	public static Color generateRandomColor() {
		Random rand = new Random();
		
		float r = (float) (rand.nextFloat());
		float g = (float) (rand.nextFloat());
		float b = (float) (rand.nextFloat());
		
		return new Color(r, g, b);
	}
	
}
