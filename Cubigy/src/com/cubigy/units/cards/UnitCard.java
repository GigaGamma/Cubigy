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
	private Class<? extends Unit> unit;
	private int unitSpawnX;
	private int unitSpawnY;
	private Team unitTeam;

	public UnitCard(double price, int displayX, int displayY, Class<? extends Unit> unit, int unitSpawnX, int unitSpawnY, Team unitTeam) {
		super("Unit", new String[] {"A unit that Auguste was", "too lazy to label"}, displayX, displayY);
	
		setPrice(price);
		setUnit(unit);
		setUnitSpawnX(unitSpawnX);
		setUnitSpawnY(unitSpawnY);
		setUnitTeam(unitTeam);
	}
	
	@Override
	public void onClick() {
		if (GameScreen.resources.getGold().getAmount() < getPrice()) {
			setCardColor(Color.RED);
			rtimer = 0;
		}
		else {
			GameScreen.resources.getGold().setAmount(GameScreen.resources.getGold().getAmount() - getPrice());
			try {
				getUnit().getConstructor(int.class, int.class, Team.class).newInstance(getUnitSpawnX(), getUnitSpawnY(), getUnitTeam());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
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
	
	public Class<? extends Unit> getUnit() {
		return unit;
	}

	public void setUnit(Class<? extends Unit> unit) {
		this.unit = unit;
	}

	public int getUnitSpawnX() {
		return unitSpawnX;
	}

	public void setUnitSpawnX(int unitSpawnX) {
		this.unitSpawnX = unitSpawnX;
	}

	public int getUnitSpawnY() {
		return unitSpawnY;
	}

	public void setUnitSpawnY(int unitSpawnY) {
		this.unitSpawnY = unitSpawnY;
	}

	public Team getUnitTeam() {
		return unitTeam;
	}

	public void setUnitTeam(Team unitTeam) {
		this.unitTeam = unitTeam;
	}
	
}
