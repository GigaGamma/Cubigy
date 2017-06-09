package com.cubigy.util;

import java.awt.Component;
import java.awt.event.*;

import com.cubigy.gui.ClickableGUI;
import com.cubigy.gui.GameScreen;
import com.cubigy.gui.Widget;
import com.cubigy.squares.Square;
import com.cubigy.units.Unit;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
	
	public boolean[] keys = new boolean[256];
	public MouseEvent mouseEvent;
	
	public int ox = 0;
	public int oy = 0;
	public int xdif = 0;
	public int ydif = 0;
	
	public InputHandler(Component c) {
		c.addKeyListener(this);
		c.addMouseListener(this);
		c.addMouseMotionListener(this);
	}
	
	public boolean isKeyDown(int keyCode) {
		if (keyCode > 0 && keyCode < 256) {
			return keys[keyCode];
		}
		
		return false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			keys[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			keys[e.getKeyCode()] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseEvent = e;
		if (e.getButton() == 1) { // Right
			for (Square s : Square.squares) {
				s.deselect();
				if (e.getX() > s.getX() + GameScreen.xOffset && e.getY() > s.getY() + GameScreen.yOffset && e.getX() < s.getX() + GameScreen.xOffset + 50 && e.getY() < s.getY() + GameScreen.yOffset + 50) {
					s.select();
				}
			}
			for (Unit u : Unit.units) {
				u.deselect();
				if (e.getX() > u.getX() + GameScreen.xOffset && e.getY() > u.getY() + GameScreen.yOffset && e.getX() < u.getX() + GameScreen.xOffset + u.getWidth() && e.getY() < u.getY() + GameScreen.yOffset + u.getHeight()) {
					u.select();
				}
			}
			for (Widget w : Widget.widgets) {
				if (w instanceof ClickableGUI) {
					if (e.getX() > w.getDisplayX() && e.getY() > w.getDisplayY() && e.getX() < w.getDisplayX() + w.getWidth() && e.getY() < w.getDisplayY() + w.getHeight()) {
						((ClickableGUI) w).onClick();
						break;
					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		xdif = (e.getX() - (ox + 1));
		ydif = (e.getY() - (oy + 1));
		ox = mouseEvent.getX();
		oy = mouseEvent.getY();
		
		if (mouseEvent.getButton() == 2) { // Center
			Camera.move(xdif / 50, ydif / 50);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
