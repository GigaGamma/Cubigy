package com.cubigy.squares.gui;

import java.util.ArrayList;

public class ManagingGUI {
	
	public static ArrayList<ManagingGUI> managingGUIs = new ArrayList<ManagingGUI>();
	private static ManagingGUI instance;
	
	public boolean showing = false;
	
	public ManagingGUI() {
		managingGUIs.add(this);
	}
	
	public static ManagingGUI getInstance() {
		return instance;
	}

	public static void setInstance(CityManagingGUI instance) {
		ManagingGUI.instance = instance;
	}
	
}
