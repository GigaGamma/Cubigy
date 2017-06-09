package com.cubigy.networking.packets;

import com.cubigy.units.Unit;

public class UnitMovementPacket extends Packet {

	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = -9022526778717417020L;
	
	private Unit unit;
	private int x;
	private int y;
	
	public UnitMovementPacket(Unit unit, int x, int y) {
		
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
