package com.cubigy.game;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.SplashScreen;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.imageio.ImageIO;

import com.cubigy.audio.Jukebox;
import com.cubigy.debug.ModInitException;
import com.cubigy.gui.ClickableGUI;
import com.cubigy.gui.Menu;
import com.cubigy.gui.Screen;
import com.cubigy.gui.Widget;
import com.cubigy.mods.Mod;
import com.cubigy.mods.ModLoader;
import com.cubigy.settings.VideoSettings;
import com.cubigy.squares.CapitalSquare;
import com.cubigy.squares.Square;
import com.cubigy.units.Barbarian;
import com.cubigy.units.Unit;
import com.cubigy.util.Camera;
import com.cubigy.util.InputHandler;
import com.cubigy.util.effects.Vignetting;

public class Cubigy {
	
	private static Cubigy instance;
	private static boolean devmode = true;
	
	public Window window;
	public ModLoader mloader;
	public VideoSettings vsettings;
	public BufferedImage background;
	public InputHandler input;
	public Jukebox jb;
	public long time;
	public Screen currentScreen;
	
	protected boolean isRunning = false;
	
	public Cubigy(Window window) throws IOException {
		Cubigy.instance = this;
		Jukebox.initSongs();
		this.jb = new Jukebox();
		this.window = window;
		this.mloader = new ModLoader();
		this.vsettings = new VideoSettings();
		this.background = new BufferedImage(window.getWidth(), window.getHeight(), BufferedImage.TYPE_INT_RGB);
		this.currentScreen = new Menu(background.getGraphics());
		
		for (int h = 0; h < background.getHeight(); h++) {
			for (int w = 0; w < background.getWidth(); w++) {
				background.setRGB(w, h, 170);
			}
		}
		
		this.input = new InputHandler(window);
		
		isRunning = true;
		
		window.getGraphics().drawImage(background, 0, 0, window);
		
		try {
			mloader.load_mods();
		} catch (ModInitException e1) {
			System.out.println(e1);
		}
		jb.start();
		
		new CapitalSquare(300, 300);
		new Barbarian(500, 500);
		//new CapitalSquare(0, 0);
		//Camera.move(1, 0);
		
		while (isRunning) {
			time = System.currentTimeMillis();
			
			update();
			draw();
			
			time = (1000 / vsettings.getFps()) - (System.currentTimeMillis() - time);
			
			if (time > 0) {
				try {
					Thread.sleep(time); 
				}
				catch(Exception e){}
            }
		}
		
		window.setVisible(false);
	}
	
	void update() {
		for (Mod m : ModLoader.mods) {
			try {
				m.getModClass().getMethod("onUpdate", Graphics.class).invoke(m.getModInstance(), this.background.getGraphics());
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				//e.printStackTrace();
			}
		}
		if (input.isKeyDown(KeyEvent.VK_ESCAPE) && Cubigy.devmode) {
			System.exit(0);
		}
		currentScreen.update();
	}
	
	void draw() {
		Graphics g = background.getGraphics();
		window.getGraphics().drawImage(background, 0, 0, window);
		g.clearRect(0, 0, window.getWidth(), window.getHeight());
		
		/*
		
		for (Square s : Square.squares) {
			s.update();
		}
		for (Unit u : Unit.units) {
			u.update();
		}
		for (Widget w : Widget.widgets) {
			w.update();
		}*/

		currentScreen.draw();
	}
	
	public static Cubigy getInstance() {
		return Cubigy.instance;
	}
	
}
