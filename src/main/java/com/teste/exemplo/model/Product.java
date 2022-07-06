package com.teste.exemplo.model;

public class Product {
	
	private Integer id;
	
	private String name;
	
	private Integer quantity;
	
	private Double price;
	
	private String obs;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public void setId(Integer id) {
		this.id = id;
	}



}
