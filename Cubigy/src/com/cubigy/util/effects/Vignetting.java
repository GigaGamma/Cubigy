package com.cubigy.util.effects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.cubigy.game.Cubigy;
import com.cubigy.squares.CapitalSquare;

public class Vignetting {
	
	private static BufferedImage vignette;
	
	private Graphics graphics;
	
	public Vignetting(Graphics graphics) {
		this.graphics = graphics;

		if (Vignetting.vignette == null) {try {Vignetting.vignette = ImageIO.read(ClassLoader.getSystemResource("images/vignette.png"));} catch (IOException e) {e.printStackTrace();}}
	}

	public void draw() {
		graphics.drawImage(vignette, 0, 0, Cubigy.getInstance().window.getWidth(), Cubigy.getInstance().window.getHeight(), null);
	}

}
