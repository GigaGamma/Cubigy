package com.cubigy.gui;

import java.awt.Graphics;

import com.cubigy.squares.Square;
import com.cubigy.units.Unit;
import com.cubigy.worlds.World;

public class GameScreen extends Screen {
	
	private World world;
	
	public GameScreen(Graphics g, World world) {
		super(g);
		setWorld(world);
	}
	
	@Override
	public void draw() {
		world.renderWorld();
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
