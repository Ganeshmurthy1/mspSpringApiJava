package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "stock_details")
public class stockData implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private Long stockid;
	private String stockName;
	private Long stockQuantity;
	private String productImage;
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStockid() {
		return stockid;
	}
	public void setStockid(Long stockid) {
		this.stockid = stockid;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Long getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	 
	 
	

}
