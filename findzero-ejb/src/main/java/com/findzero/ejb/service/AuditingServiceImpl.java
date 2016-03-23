package com.findzero.ejb.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import com.findzero.ejb.model.Auditing;
import com.findzero.ejb.repository.InjectRepository;
import com.findzero.ejb.repository.RepositoryAnnotation;
import com.findzero.ejb.repository.impl.AuditingRepositoryImpl;

@Stateful
@Interceptors({InjectRepository.class})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AuditingServiceImpl implements AuditingService {
	@RepositoryAnnotation
	AuditingRepositoryImpl auditingRepositoryImpl;
	
	@Override
	public void add(Auditing entity) throws Exception {
		auditingRepositoryImpl.save(entity);
		
	}

	@Override
	public void alter(Auditing entity) throws Exception {
		auditingRepositoryImpl.save(entity);
		
	}

	@Override
	public void remove(Auditing entity) throws Exception {
		auditingRepositoryImpl.delete(Auditing.class,entity.getCodauditing());
		
	}

	@Override
	public Auditing findByPk(Long id) throws Exception {
		return auditingRepositoryImpl.findById(Auditing.class, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Auditing> listAll() throws Exception {
		return auditingRepositoryImpl.findAll(Auditing.class);
	}
}
