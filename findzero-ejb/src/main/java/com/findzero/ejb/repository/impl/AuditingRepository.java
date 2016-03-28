package com.findzero.ejb.repository.impl;

import java.util.List;

import com.findzero.ejb.model.Auditing;

public interface AuditingRepository { 
	

	public List<Auditing> findByProduct(Long idProduct) throws Exception;
	public Integer countByProduct(Long idProduct) throws Exception;
	
	
	public List<Auditing> findByUser(Long idUser) throws Exception;
	public Integer countByUser(Long idUser) throws Exception;
}
