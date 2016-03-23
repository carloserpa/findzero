package com.findzero.ejb.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import com.findzero.ejb.model.Like;
import com.findzero.ejb.model.Product;
import com.findzero.ejb.repository.InjectRepository;
import com.findzero.ejb.repository.RepositoryAnnotation;
import com.findzero.ejb.repository.impl.LikeRepositoryImpl;

@Stateful
@Interceptors({InjectRepository.class})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LikeServiceImpl implements LikeService {
	@RepositoryAnnotation
	LikeRepositoryImpl likeRepositoryImpl;
	
	@Override
	public void add(Like entity) throws Exception {
		likeRepositoryImpl.save(entity);
		
	}

	@Override
	public void alter(Like entity) throws Exception {
		likeRepositoryImpl.save(entity);
		
	}

	@Override
	public void remove(Like entity) throws Exception {
		likeRepositoryImpl.delete(Like.class,entity.getCodlikes());
		
	}

	@Override
	public Like findByPk(Long id) throws Exception {
		return likeRepositoryImpl.findById(Like.class, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Like> listAll() throws Exception {
		return likeRepositoryImpl.findAll(Like.class);
	}

	@Override
	public List<Like> findByProduct(Product p) throws Exception {
		return likeRepositoryImpl.findByProduct(p);
	}
}
