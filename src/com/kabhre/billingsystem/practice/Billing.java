package com.kabhre.billingsystem.practice;

import java.util.ArrayList;

public interface Billing {
	public void AddProducts(ProductsDto productsDto);
	public ArrayList<ProductsDto>GetDatafromDb();
	public void deleteProducts(int id);
	public void updateProducts(ProductsDto productsDto);

}
