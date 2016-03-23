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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
@XmlRootElement
public class Comment implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codcomment;

	private Timestamp datelog;

	private String description;
	@Transient
	private Integer commentCount = 10;

	// bi-directional many-to-one association to Product
	// @LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codproduct")
	private Product product;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codusers")
	private User user;

	public Comment() {
	}

	public Long getCodcomment() {
		return this.codcomment;
	}

	public void setCodcomment(Long codcomment) {
		this.codcomment = codcomment;
	}

	public Timestamp getDatelog() {
		return this.datelog;
	}

	public void setDatelog(Timestamp datelog) {
		this.datelog = datelog;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@JsonIgnore
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Serializable getId() {
		return this.codcomment;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

}