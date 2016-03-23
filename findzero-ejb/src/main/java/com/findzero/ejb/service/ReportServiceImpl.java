package com.findzero.ejb.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import com.findzero.ejb.model.Report;
import com.findzero.ejb.repository.InjectRepository;
import com.findzero.ejb.repository.RepositoryAnnotation;
import com.findzero.ejb.repository.impl.ReportRepositoryImpl;

@Stateful
@Interceptors({InjectRepository.class})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ReportServiceImpl implements ReportService {
	@RepositoryAnnotation
	ReportRepositoryImpl reportRepositoryImpl;
	
	@Override
	public void add(Report entity) throws Exception {
		reportRepositoryImpl.save(entity);
		
	}

	@Override
	public void alter(Report entity) throws Exception {
		reportRepositoryImpl.save(entity);
		
	}

	@Override
	public void remove(Report entity) throws Exception {
		reportRepositoryImpl.delete(Report.class,entity.getCodreport());
		
	}

	@Override
	public Report findByPk(Long id) throws Exception {
		return reportRepositoryImpl.findById(Report.class, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Report> listAll() throws Exception {
		return reportRepositoryImpl.findAll(Report.class);
	}
}
