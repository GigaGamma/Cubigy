package com.cubigy.squares.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.cubigy.game.Cubigy;
import com.cubigy.gui.TextDisplay;

public class CityManagingGUI extends ManagingGUI {
	
	private String cityName;
	private TextDisplay shop;
	
	public CityManagingGUI(String cityName) {
		setCityName(cityName);
		shop = new TextDisplay(getCityName() + "'s Shop", 200, 200);
		shop.setFont(new Font("Century Gothic", Font.BOLD, 60));
	}
	
	public void draw(Graphics g) {
		shop.draw(g);
		ManagingGUI.setInstance(this);
		
		g.setColor(new Color(255, 255, 255, 150));
		g.fillRect(0, 0, Cubigy.getInstance().window.getWidth(), Cubigy.getInstance().window.getHeight());
		
		for (ManagingGUI mg : ManagingGUI.managingGUIs) {
			if (mg != this) {
				mg.showing = false;
			}
		}
		
		if (Cubigy.getInstance().input.isKeyDown(KeyEvent.VK_ESCAPE)) {
			showing = false;
		}
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
