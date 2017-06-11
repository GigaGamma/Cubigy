package com.cubigy.squares;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.cubigy.game.Cubigy;
import com.cubigy.game.Team;
import com.cubigy.gui.Button;
import com.cubigy.gui.GameScreen;
import com.cubigy.squares.gui.CityManagingGUI;

public class CitySquare extends Square {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = 171800711498801252L;
	
	private CityManagingGUI cmg;
	private String cityName;

	public CitySquare(String cityName, int x, int y, Team team) {
		super("City", x, y, team);
		
		setCityName(cityName);
		setCmg(new CityManagingGUI(this, getCityName()));
		getText().setText(new String[] {getCityName(), "", "Cities are very important squares.", "They produce resources and increase a", "teams maximum population."});
		opengui = new Button("Manage", getX() + GameScreen.xOffset + 55, getY() + GameScreen.yOffset + getText().getHeight() + 20) {

			/**
			 * @author Auguste Rame
			 */
			private static final long serialVersionUID = -7278575381863327040L;
			
			@Override
			public void onClick() {
				cmg.showing = true;
				
				super.onClick();
			}
			
		};
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.BOLD, 50));
		g.drawString("C", getX() + GameScreen.xOffset + 5, getY() + GameScreen.yOffset + 43);
		if (getCmg().showing) {
			getCmg().draw(Cubigy.getInstance().background.getGraphics());
		}
	}
	
	@Override
	public void onSquareSelect() {
		super.onSquareSelect();
	}
	
	public CityManagingGUI getCmg() {
		return cmg;
	}

	public void setCmg(CityManagingGUI cmg) {
		this.cmg = cmg;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
