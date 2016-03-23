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
 * The persistent class for the report database table.
 * 
 */
@Entity
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
@XmlRootElement
public class Report implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codreport;

	private Timestamp datelog;

	private String description;

	private Boolean valid;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codproduct")
	private Product product;

	//bi-directional many-to-one association to ReportType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codreporttype")
	private ReportType reportType;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codusers")
	private User user;

	public Report() {
	}

	public Long getCodreport() {
		return this.codreport;
	}

	public void setCodreport(Long codreport) {
		this.codreport = codreport;
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

	public Boolean getValid() {
		return this.valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ReportType getReportType() {
		return this.reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Serializable getId() {
		return this.codreport;
	}

}