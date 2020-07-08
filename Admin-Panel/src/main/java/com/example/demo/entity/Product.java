package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name="products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="category_id")
	 private String categoryId;
	@Column(name="name")
	@NotBlank(message= "name not null")
    private String name;
	@Column(name="price")
	private double price;
	@Column(name="actual_price")
	 private double actualPrice;
	@Column(name="info")
	    private String info;
	@Column(name="img_path")
	    private String imgPath;
	@Column(name="info_id")
    private String infoId;
	
	
	public Product() {
		super();
	}
	
	

	
	public Product(int id, String categoryId, String name, double price, double actualPrice, String info,
			String imgPath, String infoId) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.actualPrice = actualPrice;
		this.info = info;
		this.imgPath = imgPath;
		this.infoId = infoId;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	


	public String getInfoId() {
		return infoId;
	}




	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}




	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", price=" + price
				+ ", actualPrice=" + actualPrice + ", info=" + info + ", imgPath=" + imgPath + "]";
	}
   
	
	


}
