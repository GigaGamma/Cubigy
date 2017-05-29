package com.cubigy.mods;

public class Mod {
	
	private Class<?> modClass;
	private Object modInstance;
	
	public Mod(Class<?> modClass, Object modInstance) {
		this.modClass = modClass;
		this.modInstance = modInstance;
	}

	public Class<?> getModClass() {
		return modClass;
	}

	public void setModClass(Class<?> modClass) {
		this.modClass = modClass;
	}

	public Object getModInstance() {
		return modInstance;
	}

	public void setModInstance(Object modInstance) {
		this.modInstance = modInstance;
	}
	
}
