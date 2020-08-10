package com.bootcamp.Shop;

public class Thing {

	/**
	 * Name of thing
	 */
	private  String name;

	/**
	 * Description of thing
	 */
	private String description;

	public Thing(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}
	
	@Override
	public String toString() {
		return "ThingType [name=" + name + ", description=" + description + "]";
	}
	
		
	
}
