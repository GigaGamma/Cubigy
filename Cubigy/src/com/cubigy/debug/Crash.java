package com.cubigy.debug;

public class Crash extends Exception {

	private static final long serialVersionUID = 7375763963934981790L;
	
	public Crash() {
		super("Oh oh, a crash occured...");
	}
	
}
