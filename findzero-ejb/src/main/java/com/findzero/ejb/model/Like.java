package com.findzero.ejb.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The persistent class for the likes database table.
 * 
 */
@Entity
@Table(name="likes")
@NamedQuery(name="Like.findAll", query="SELECT l FROM Like l")
@XmlRootElement
public class Like implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codlikes;

	private Timestamp datelog;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codproduct")
	private Product product;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codusers")
	private User user;

	public Like() {
	}

	public Long getCodlikes() {
		return this.codlikes;
	}

	public void setCodlikes(Long codlikes) {
		this.codlikes = codlikes;
	}

	public Timestamp getDatelog() {
		return this.datelog;
	}

	public void setDatelog(Timestamp datelog) {
		this.datelog = datelog;
	}

	@JsonIgnore
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Serializable getId() {
		return this.codlikes;
	}

}