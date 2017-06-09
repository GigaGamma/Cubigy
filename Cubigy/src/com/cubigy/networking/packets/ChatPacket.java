package com.cubigy.networking.packets;

public class ChatPacket extends Packet {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = 1439382062126014205L;
	
	private String message;
	
	public ChatPacket(String message) {
		setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
