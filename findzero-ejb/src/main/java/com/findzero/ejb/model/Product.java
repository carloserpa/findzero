package com.findzero.ejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
@XmlRootElement
public class Product implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codproduct;

	private Timestamp created;

	private String description;

	private String locationcood;

	private String locationname;

	private Timestamp modified;

	private BigDecimal price;

	//bi-directional many-to-many association to Category
	@ManyToMany(mappedBy="products")
	private List<Category> categories;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="product")
	private List<Comment> comments;

	//bi-directional many-to-one association to Like
	@OneToMany(mappedBy="product")
	private List<Like> likes;

	//bi-directional many-to-many association to Picture
	@OneToMany(mappedBy="product")
	private List<Picture> pictures;
	
	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codusers")
	private User user;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="product")
	private List<Report> reports;

	public Product() {
	}

	public Long getCodproduct() {
		return this.codproduct;
	}

	public void setCodproduct(Long codproduct) {
		this.codproduct = codproduct;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocationcood() {
		return this.locationcood;
	}

	public void setLocationcood(String locationcood) {
		this.locationcood = locationcood;
	}

	public String getLocationname() {
		return this.locationname;
	}

	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@JsonIgnore
	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	@JsonIgnore
	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setProduct(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setProduct(null);

		return comment;
	}
	@JsonIgnore
	public List<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public Like addLike(Like like) {
		getLikes().add(like);
		like.setProduct(this);

		return like;
	}

	public Like removeLike(Like like) {
		getLikes().remove(like);
		like.setProduct(null);

		return like;
	}
	
	@JsonIgnore
	public List<Picture> getPictures() {
		return this.pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}
	@JsonIgnore
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@JsonIgnore
	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setProduct(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setProduct(null);

		return report;
	}

	@Override
	public Serializable getId() {
		return this.codproduct;
	}
	
}