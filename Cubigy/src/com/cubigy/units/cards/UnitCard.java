package com.cubigy.units.cards;

import java.awt.Color;
import java.awt.Graphics;

import com.cubigy.game.Cubigy;
import com.cubigy.gui.Card;

public class UnitCard extends Card {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = -519024103546164854L;
	
	private long timer = 0;

	public UnitCard(int displayX, int displayY) {
		super("Unit", new String[] {"A unit that Auguste was", "too lazy to label"}, displayX, displayY);
	}
	
	@Override
	public void onClick() {
		setCardColor(Color.RED);
		timer = 0;
	}
	
	@Override
	public void update() {
		timer++;
		if (timer > 3) {
			setCardColor(Color.WHITE);
		}
	}
	
}
