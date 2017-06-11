package com.cubigy.resources;

import java.io.Serializable;

public class Resource implements Serializable {
	
	/**
	 * @author Auguste Rame
	 */
	private static final long serialVersionUID = -7815828974999247023L;
	
	private String name;
	private double amount;
	
	public Resource(String name, double amount) {
		setName(name);
		setAmount(amount);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
