package com.cubigy.debug;

public class ModInitException extends Exception {
	
	private static final long serialVersionUID = -4026094203924693360L;
	
	public ModInitException(String mod) {
		super("'" + mod + "' failed to load");
	}
	
}
