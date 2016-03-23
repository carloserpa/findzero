package com.findzero.ejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codcategory;

	private String name;

	// bi-directional many-to-many association to Product
	@ManyToMany
	@JoinTable(name = "category_product", joinColumns = { @JoinColumn(name = "codcategory") }, inverseJoinColumns = {
			@JoinColumn(name = "codproduct") })
	private List<Product> products;

	public Category() {
	}

	public Long getCodcategory() {
		return this.codcategory;
	}

	public void setCodcategory(Long codcategory) {
		this.codcategory = codcategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public Serializable getId() {
		return this.codcategory;
	}

}