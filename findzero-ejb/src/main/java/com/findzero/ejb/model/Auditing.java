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
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the auditing database table.
 * 
 */
@Entity
@NamedQuery(name="Auditing.findAll", query="SELECT a FROM Auditing a")
@XmlRootElement
public class Auditing implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codauditing;
	
	private Timestamp datelog;

	private String description;

	private Long idregistrytable;

	private Integer points;

	private String tablename;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codusers")
	private User user;

	public Auditing() {
	}

	public Long getCodauditing() {
		return this.codauditing;
	}

	public void setCodauditing(Long codauditing) {
		this.codauditing = codauditing;
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

	public Long getIdregistrytable() {
		return this.idregistrytable;
	}

	public void setIdregistrytable(Long idregistrytable) {
		this.idregistrytable = idregistrytable;
	}

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

}