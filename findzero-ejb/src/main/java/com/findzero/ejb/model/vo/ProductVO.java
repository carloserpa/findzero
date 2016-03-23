package com.findzero.ejb.model.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "ProductVO", entities = {
		@EntityResult(entityClass = com.findzero.ejb.model.vo.ProductVO.class) })
@Entity
public class ProductVO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long codProduct;
	
	private String description;

	private Double price;

	private String locationName;

	private String locationCood;

	private String url;

	private Integer comments;

	private Integer likes;

	public Long getCodProduct() {
		return codProduct;
	}

	public void setCodProduct(Long codProduct) {
		this.codProduct = codProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationCood() {
		return locationCood;
	}

	public void setLocationCood(String locationCood) {
		this.locationCood = locationCood;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	

}
