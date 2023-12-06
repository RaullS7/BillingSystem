package com.kabhre.billingsystem.practice;

import java.io.Serializable;

public class ProductsDto implements Serializable{
 private String name,category,availavility;
private int id,rate,quantity;

public void setName(String name) {
	this.name=name;
}
public String getName() {
	return name;
	
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getAvailability() {
	return availavility;
}
public void setAvailability(String availability) {
	this.availavility = availability;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
