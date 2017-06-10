package com.cubigy.resources;

public class ResourceManager {
	
	private Resource gold;
	
	public ResourceManager() {
		setGold(new Resource("Gold", 0));
	}

	public Resource getGold() {
		return gold;
	}

	public void setGold(Resource gold) {
		this.gold = gold;
	}
	
}
