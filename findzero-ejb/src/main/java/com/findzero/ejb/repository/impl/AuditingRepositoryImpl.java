package com.findzero.ejb.repository.impl;

import javax.persistence.EntityManager;

import com.findzero.ejb.model.Auditing;
import com.findzero.ejb.repository.RepositoryBase;

public class AuditingRepositoryImpl extends RepositoryBase<Auditing> implements AuditingRepository {

	public AuditingRepositoryImpl(EntityManager em) {
		super(em);
	}

}
