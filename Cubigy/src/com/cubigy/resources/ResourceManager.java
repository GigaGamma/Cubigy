package com.cubigy.resources;

import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import java.text.DecimalFormat;

import com.cubigy.gui.TextDisplay;

public class ResourceManager implements Serializable {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = 7666919244804105405L;
	
	private Resource gold;
	private TextDisplay goldDisplay;
	
	public ResourceManager() {
		goldDisplay = new TextDisplay("$ 0", 20, 10);
		goldDisplay.setFont(new Font(goldDisplay.getFont().getFontName(), Font.BOLD, 60));
		setGold(new Resource("Gold", 0));
	}
	
	public void draw(Graphics g) {
		goldDisplay.setText("$ " + new DecimalFormat("#0.00").format(getGold().getAmount()));
		goldDisplay.draw(g);
	}

	public Resource getGold() {
		return gold;
	}

	public void setGold(Resource gold) {
		this.gold = gold;
	}
	
}
