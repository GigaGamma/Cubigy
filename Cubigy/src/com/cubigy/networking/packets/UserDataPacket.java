package com.cubigy.networking.packets;

import com.cubigy.game.Team;
import com.cubigy.resources.ResourceManager;

public class UserDataPacket extends Packet {

	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = 6107458081233809279L;
	
	private Team team;
	private int baseX;
	private int baseY;
	private ResourceManager resources;
	
	public UserDataPacket(Team team, int baseX, int baseY, ResourceManager resources) {
		setTeam(team);
		setBaseX(baseX);
		setBaseY(baseY);
		setResources(resources);
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getBaseX() {
		return baseX;
	}

	public void setBaseX(int baseX) {
		this.baseX = baseX;
	}

	public int getBaseY() {
		return baseY;
	}

	public void setBaseY(int baseY) {
		this.baseY = baseY;
	}

	public ResourceManager getResources() {
		return resources;
	}

	public void setResources(ResourceManager resources) {
		this.resources = resources;
	}

}
