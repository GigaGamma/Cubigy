package com.cubigy.gui;

import java.awt.Graphics;

import com.cubigy.networking.Client;
import com.cubigy.networking.Server;
import com.cubigy.networking.packets.ChatPacket;
import com.cubigy.resources.Resource;
import com.cubigy.resources.ResourceManager;
import com.cubigy.squares.Square;
import com.cubigy.units.Unit;
import com.cubigy.worlds.World;

public class GameScreen extends Screen {
	
	private World world;
	private Client client;
	private Server server;
	
	public static int xOffset = 0;
	public static int yOffset = 0;
	public static ResourceManager resources;
	
	public GameScreen(Graphics g, boolean hostLocal) {
		super(g);
		server = new Server();
		try {
			server.start();
		} catch (InterruptedException e) {e.printStackTrace();}
		client = new Client("localhost");
		try {
			client.start();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public GameScreen(Graphics g, String ip) {
		super(g);
		client = new Client(ip);
		try {
			client.start();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@Override
	public void draw() {
		for (Square s : Square.squares) {
			s.update();
		}
		for (Unit u : Unit.units) {
			u.update();
		}
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

}
