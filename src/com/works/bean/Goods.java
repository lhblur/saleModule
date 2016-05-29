package com.works.bean;

import com.works.util.Utils;

public class Goods {
	
	private String barcode;
	private String name;
	private String unit;
	private String category;
	private String subcategory;
	private double price;

	private int count;
	private String saleType;

	public Goods() {
		
	}
	
	public Goods(String barcode,String name,String unit,String category,String subcategory,double price,int count,String saleType) {
		this.barcode = barcode;
		this.name = name;
		this.unit = unit;
		this.category = category;
		this.subcategory = subcategory;
		this.price = price;
		this.count = count;
		this.saleType = saleType;
	}
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSaletype() {
		return saleType;
	}

	public void setSaletype(String saleType) {
		this.saleType = saleType;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "名称：" + name + ", 数量：" + count + unit + ", 单价：" + Utils.numberFormat(price,"0.00") + "(元), 小计：";
	}
	
	private volatile int hashCode = 0; 
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		if(hashCode == 0) {  
			int result = 17;
			result = 37*result + barcode.hashCode();
			result = 37*result + name.hashCode();
			result = 37*result + unit.hashCode();
			result = 37*result + category.hashCode();
			result = 37*result + subcategory.hashCode();
 			long tolong = Double.doubleToLongBits(price);
			result = 37*result + (int) (tolong ^ (tolong >>> 32));
			result = 37*result + count;
			result = 37*result + saleType.hashCode();
			hashCode = result;  
			}  
			return hashCode;  

	}

	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(obj == null) 
			return false;
	
		if(this == obj)
			return true;
		
		if(!(obj instanceof Goods))
			return false;
		
		Goods goods = (Goods)obj;
		
		return (this.barcode.equals(goods.barcode)) &&
				(this.name.equals(goods.name)) &&
				(this.unit.equals(goods.unit)) &&
				(this.category.equals(goods.category)) &&
				(this.subcategory.equals(goods.subcategory)) &&
				(Double.doubleToLongBits(this.price) == Double.doubleToLongBits(goods.price)) &&
				(this.count == goods.count) &&
				(this.saleType.equals(goods.saleType));
	}

}
