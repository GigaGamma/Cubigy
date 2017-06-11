package com.cubigy.squares.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.cubigy.game.Cubigy;
import com.cubigy.gui.GameScreen;
import com.cubigy.gui.TextDisplay;
import com.cubigy.squares.Square;
import com.cubigy.units.Barbarian;
import com.cubigy.units.cards.UnitCard;

public class CityManagingGUI extends ManagingGUI {
	
	private String cityName;
	private TextDisplay title;
	private TextDisplay shop;
	private TextDisplay units;
	private UnitCard uc;
	
	public CityManagingGUI(Square square, String cityName) {
		super(square);
		setCityName(cityName);
		
		title = new TextDisplay(getCityName(), 200, 200);
		title.setFont(new Font(title.getFont().getFontName(), Font.BOLD, 80));
		
		shop = new TextDisplay(getCityName() + "'s Shop", 200, 400);
		shop.setFont(new Font(shop.getFont().getFontName(), Font.BOLD, 60));
		
		units = new TextDisplay("Train Units", 200, 800);
		units.setFont(new Font(units.getFont().getFontName(), Font.BOLD, 60));
		
		uc = new UnitCard(1, 200, 920, Barbarian.class, square.getX(), square.getY(), Cubigy.getInstance().team);
	}
	
	public void draw(Graphics g) {
		title.draw(g);
		shop.draw(g);
		units.draw(g);
		uc.draw(g);
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
