package com.kabhre.billingsystem.practice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DatabseConncection.DatabaseConncection;

public class ProductsImpl implements Billing{
	PreparedStatement ps=null;
	

	@Override
	public void AddProducts(ProductsDto productsDto) {
		String sql="insert into add_products(name,rate,category,availavility,quantity)values(?,?,?,?,?)";
		try {
		ps=DatabaseConncection.getConnection().prepareStatement(sql);
		ps.setString(1, productsDto.getName());
		ps.setInt(2, productsDto.getRate());
		ps.setString(3, productsDto.getCategory());
		ps.setString(4, productsDto.getAvailability());
		ps.setInt(5, productsDto.getQuantity());
		ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}


	@Override
	public ArrayList<ProductsDto> GetDatafromDb() {
		ArrayList<ProductsDto> productList=new ArrayList<>();
		String sql="select * from add_products";
		try {
			ps=DatabaseConncection.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				ProductsDto products=new ProductsDto();
				products.setId(rs.getInt("id"));
				products.setName(rs.getString("name"));
				products.setRate(rs.getInt("rate"));
				products.setCategory(rs.getString("category"));
				products.setAvailability(rs.getString("Availavility"));
				products.setQuantity(rs.getInt("quantity"));
				productList.add(products);
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return productList;
	}


	@Override
	public void deleteProducts(int id) {
		String sql="delete from add_products where id=?";
		try {
		ps=DatabaseConncection.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}


	@Override
	public void updateProducts(ProductsDto productsDto) {
		String sql="update add_products set name=?,rate=?,category=?,availavility=?,quantity=? where id=?";
		try {
			ps=DatabaseConncection.getConnection().prepareStatement(sql);
			ps.setString(1, productsDto.getName());
			ps.setInt(2, productsDto.getRate());
			ps.setString(3, productsDto.getCategory());
			ps.setString(4, productsDto.getAvailability());
			ps.setInt(5, productsDto.getQuantity());
			ps.setInt(6,productsDto.getId());
			ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
