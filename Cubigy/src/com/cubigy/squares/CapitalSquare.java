package com.cubigy.squares;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.cubigy.game.Cubigy;
import com.cubigy.game.Team;
import com.cubigy.gui.GameScreen;

public class CapitalSquare extends Square {
	
	private static BufferedImage img;
	
	public CapitalSquare(int x, int y, Team team) {
		super("Capital", x, y, team);
		
		if (CapitalSquare.img == null) {try {CapitalSquare.img = ImageIO.read(ClassLoader.getSystemResource("images/star.png"));} catch (IOException e) {e.printStackTrace();}}
		
		getText().setText(new String[] {"Capital", "", "The capital is the most important square, don't lose it.", "", "If you lose the capital, then it's game over."});
	}

	@Override
	public void draw(Graphics g) {
		/*int midX = 500;
		int midY = 340;
		int radius[] = {29, 10, 22, 10};
		int nPoints = 16;
		int[] X = new int[nPoints];
		int[] Y = new int[nPoints];

		for (double current=0.0; current<nPoints; current++) {
			int i = (int) current;
			double x = Math.cos(current*((2*Math.PI)/nPoints))*radius[i % 4];
			double y = Math.sin(current*((2*Math.PI)/nPoints))*radius[i % 4];

			X[i] = (int) x+midX;
			Y[i] = (int) y+midY;
	    }

		g.setColor(Color.WHITE);
		g.fillPolygon(X, Y, nPoints);*/
		
		g.drawImage(CapitalSquare.img, getX() + GameScreen.xOffset, getY() + GameScreen.yOffset, 50, 50, null);
	}
	
	@Override
	public void onSquareSelect() {
		super.onSquareSelect();
	}
	
}
