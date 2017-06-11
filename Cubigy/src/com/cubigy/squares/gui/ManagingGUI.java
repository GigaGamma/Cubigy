package com.cubigy.squares.gui;

import java.util.ArrayList;

import com.cubigy.squares.Square;

public class ManagingGUI {
	
	public static ArrayList<ManagingGUI> managingGUIs = new ArrayList<ManagingGUI>();
	private static ManagingGUI instance;
	
	public boolean showing = false;
	public Square square;
	
	public ManagingGUI(Square square) {
		managingGUIs.add(this);
		this.square = square;
	}
	
	public static ManagingGUI getInstance() {
		return instance;
	}

	public static void setInstance(CityManagingGUI instance) {
		ManagingGUI.instance = instance;
	}
	
}
