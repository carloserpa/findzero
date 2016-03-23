package com.findzero.ejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the report_type database table.
 * 
 */
@Entity
@Table(name="report_type")
@NamedQuery(name="ReportType.findAll", query="SELECT r FROM ReportType r")
public class ReportType implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codreporttype;

	private String description;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="reportType")
	private List<Report> reports;

	public ReportType() {
	}

	public Long getCodreporttype() {
		return this.codreporttype;
	}

	public void setCodreporttype(Long codreporttype) {
		this.codreporttype = codreporttype;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setReportType(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setReportType(null);

		return report;
	}

	@Override
	public Serializable getId() {
		return this.codreporttype;
	}

}