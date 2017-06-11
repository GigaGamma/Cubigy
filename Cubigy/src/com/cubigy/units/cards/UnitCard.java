package com.cubigy.units.cards;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;

import com.cubigy.game.Cubigy;
import com.cubigy.game.Team;
import com.cubigy.gui.Card;
import com.cubigy.gui.GameScreen;
import com.cubigy.units.Unit;

public class UnitCard extends Card {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = -519024103546164854L;
	
	private long rtimer = 1000;
	
	private double price;

	public UnitCard(double price, int displayX, int displayY) {
		super("Unit", new String[] {"A unit that Auguste was", "too lazy to label"}, displayX, displayY);
	
		setPrice(price);
	}
	
	@Override
	public void onClick() {
		if (GameScreen.resources.getGold().getAmount() < getPrice()) {
			setCardColor(Color.RED);
			rtimer = 0;
		}
		else {
			GameScreen.resources.getGold().setAmount(GameScreen.resources.getGold().getAmount() - getPrice());
			makeUnit();
		}
	}
	
	public void makeUnit() {
		
	}
	
	@Override
	public void update() {
		rtimer++;
		if (rtimer > 3) {
			setCardColor(Color.WHITE);
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
