package com.cubigy.gui;

import java.awt.Font;
import java.awt.Graphics;

import com.cubigy.game.Cubigy;
import com.cubigy.worlds.World;

public class MenuScreen extends Screen {
	
	public Button quickmatch;
	public Button multiplayer;
	
	public MenuScreen(Graphics g) {
		super(g);
		this.quickmatch = new Button("Quick Match", 200, 300) {
			@Override
			public void onClick() {
				Cubigy.getInstance().currentScreen = new GameScreen(g, true);
				widgets.clear();
			}
		};
		this.quickmatch.setFont(new Font(this.quickmatch.getFont().getFontName(), Font.PLAIN, 200));
		this.multiplayer = new Button("Multiplayer", 200, 600) {
			@Override
			public void onClick() {
				Cubigy.getInstance().currentScreen = new Screen(g);
				widgets.clear();
			}
		};
		this.multiplayer.setFont(new Font(this.multiplayer.getFont().getFontName(), Font.PLAIN, 200));
	}
	
	@Override
	public void draw() {
		quickmatch.draw(getGraphics());
		multiplayer.draw(getGraphics());
	}
	
}
