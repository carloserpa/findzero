package com.findzero.ejb.repository.impl;

import javax.persistence.EntityManager;

import com.findzero.ejb.model.Report;
import com.findzero.ejb.repository.RepositoryBase;

public class ReportRepositoryImpl extends RepositoryBase<Report> implements ReportRepository {

	public ReportRepositoryImpl(EntityManager em) {
		super(em);
	}


}
