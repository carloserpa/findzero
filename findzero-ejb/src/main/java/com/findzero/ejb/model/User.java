package com.findzero.ejb.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable, EntityBase{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codusers;
	
	private Timestamp datelog;

	private String email;

	private String name;

	private String password;

	private String urlphoto;

	private Boolean valid;

	//bi-directional many-to-one association to Auditing
	@OneToMany(mappedBy="user")	
	private List<Auditing> auditings;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to Like
	@OneToMany(mappedBy="user")
	private List<Like> likes;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="user")
	private List<Product> products;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="user")
	private List<Report> reports;

	//bi-directional many-to-one association to UsersGroup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codusersgroup")
	private UsersGroup usersGroup;

	//bi-directional many-to-one association to UsersType	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="coduserstype")
	private UsersType usersType;

	public User() {
	}

	public Long getCodusers() {
		return this.codusers;
	}

	public void setCodusers(Long codusers) {
		this.codusers = codusers;
	}

	public Timestamp getDatelog() {
		return this.datelog;
	}

	public void setDatelog(Timestamp datelog) {
		this.datelog = datelog;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlphoto() {
		return this.urlphoto;
	}

	public void setUrlphoto(String urlphoto) {
		this.urlphoto = urlphoto;
	}

	public Boolean getValid() {
		return this.valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	@JsonIgnore
	public List<Auditing> getAuditings() {
		return this.auditings;
	}
	
	public void setAuditings(List<Auditing> auditings) {
		this.auditings = auditings;
	}

	public Auditing addAuditing(Auditing auditing) {
		getAuditings().add(auditing);
		auditing.setUser(this);

		return auditing;
	}

	public Auditing removeAuditing(Auditing auditing) {
		getAuditings().remove(auditing);
		auditing.setUser(null);

		return auditing;
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
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

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
		like.setUser(this);

		return like;
	}

	public Like removeLike(Like like) {
		getLikes().remove(like);
		like.setUser(null);

		return like;
	}
	
	@JsonIgnore
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setUser(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setUser(null);

		return product;
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
		report.setUser(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setUser(null);

		return report;
	}
	
	@JsonIgnore
	public UsersGroup getUsersGroup() {
		return this.usersGroup;
	}
	
	@JsonProperty("codusersgroup")
	public void setUsersGroup(UsersGroup usersGroup) {
		this.usersGroup = usersGroup;
	}
	
	@JsonIgnore
	public UsersType getUsersType() {
		return this.usersType;
	}
	
	@JsonProperty("coduserstype")
	public void setUsersType(UsersType usersType) {
		this.usersType = usersType;
	}

	@Override
	public Serializable getId() {
		return this.codusers;
	}
	/*
	@Override
	public String toString() {
		return new StringBuffer().append("codusers: ").append(this.codusers)
				.append("datelog: ").append(this.datelog)
				.append("email: ").append(this.email)
				.append("name: ").append(this.name)
				.append("password: ").append(this.password)
				.append("urlphoto: ").append(this.urlphoto)
				.append("valid: ").append(this.valid)
				.toString();

	}
	*/
}