package com.findzero.ejb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The persistent class for the picture database table.
 * 
 */
@Entity
@NamedQuery(name = "Picture.findAll", query = "SELECT p FROM Picture p")
public class Picture implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codpicture;

	private String url;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="codproduct")
	private Product product;

	public Picture() {
	}

	public Long getCodpicture() {
		return this.codpicture;
	}

	public void setCodpicture(Long codpicture) {
		this.codpicture = codpicture;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonIgnore
	public Product getProducts() {
		return this.product;
	}

	public void setProducts(Product product) {
		this.product = product;
	}

	@Override
	public Serializable getId() {
		return this.codpicture;
	}
	/*
	 * public String getImageBase64() throws Exception{ String resultado = "";
	 * resultado = Utilities.encondeBase64(this.url); return resultado; }
	 */
}