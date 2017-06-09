package com.cubigy.networking.packets;

import com.cubigy.worlds.World;

public class WorldPacket extends Packet {

	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = 5088580655121066369L;
	
	private World world;
	
	public WorldPacket(World world) {
		setWorld(world);
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
