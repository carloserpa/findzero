package com.findzero.ejb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.findzero.ejb.model.Auditing;
import com.findzero.ejb.repository.RepositoryBase;

public class AuditingRepositoryImpl extends RepositoryBase<Auditing> implements AuditingRepository {

	public AuditingRepositoryImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Auditing> findByProduct(Long idProduct) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByProduct(Long idProduct) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auditing> findByUser(Long idUser) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countByUser(Long idUser) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*SELECT PARA PEGAR SOMAR O MENSAL DOS USUARIOS PARAMETRO É O MES Q DESEJA VER POR PADRAO SE PASSA O ATUAL
	 * Select Extract('Month' From a.datelog) as mesatual,
     a.codusers as codusers,
     u.name as name,
     sum(a.points) as points
From auditing a
left join users u on u.codusers = a.codusers
where Extract('Month' From a.datelog) = 3 // Extract('Month' From Now()
group by Extract('Month' From a.datelog), a.codusers, u.name
order by  sum(a.points) desc, u.name
;
-- Select Extract('Month' From Now()); 

	 */
}
