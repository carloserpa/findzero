package com.findzero.ejb.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import com.findzero.ejb.model.Comment;
import com.findzero.ejb.repository.InjectRepository;
import com.findzero.ejb.repository.RepositoryAnnotation;
import com.findzero.ejb.repository.impl.CommentRepositoryImpl;

@Stateful
@Interceptors({InjectRepository.class})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CommentServiceImpl implements CommentService {
	@RepositoryAnnotation
	CommentRepositoryImpl commentRepositoryImpl;
	
	@Override
	public void add(Comment entity) throws Exception {
		commentRepositoryImpl.save(entity);
		
	}
	
	@Override
	public void alter(Comment entity) throws Exception {
		commentRepositoryImpl.save(entity);
		
	}

	@Override
	public void remove(Comment entity) throws Exception {
		commentRepositoryImpl.delete(Comment.class,entity.getCodcomment());
		
	}

	@Override
	public Comment findByPk(Long id) throws Exception {
		return commentRepositoryImpl.findById(Comment.class, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Comment> listAll() throws Exception {
		return commentRepositoryImpl.findAll(Comment.class);
	}

	@Override
	public List<Comment> findByProduct(Long idProduct) throws Exception {
		return commentRepositoryImpl.findByProduct(idProduct);
	}

	@Override
	public Integer countByProduct(Long idProduct) throws Exception {
		return commentRepositoryImpl.countByProduct(idProduct);
	}

	@Override
	public List<Comment> findByUser(Long idUser) throws Exception {
		return commentRepositoryImpl.findByUser(idUser);
	}

	@Override
	public Integer countByUser(Long idUser) throws Exception {
		return commentRepositoryImpl.countByUser(idUser);
	}

	
	
}
