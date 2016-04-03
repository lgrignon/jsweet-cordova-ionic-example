package org.jsweet.ionicexercise.client.model;

public class CoffeeShopDto {

	public static CoffeeShopDto clone(CoffeeShopDto other) {
		return new CoffeeShopDto(other.id, other.name, other.address);
	}

	public String id;
	public String name;
	public String address;

	public CoffeeShopDto() {
		this(null, null, null);
	}

	public CoffeeShopDto(String id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
}
