package com.findzero.ejb.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import com.findzero.ejb.model.User;
import com.findzero.ejb.repository.InjectRepository;
import com.findzero.ejb.repository.RepositoryAnnotation;
import com.findzero.ejb.repository.impl.UserRepositoryImpl;

@Stateful
@Interceptors({InjectRepository.class})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserServiceImpl implements UserService {
	@RepositoryAnnotation
	UserRepositoryImpl userRepositoryImpl;
	
	@Override
	public void add(User entity) throws Exception {
		userRepositoryImpl.save(entity);
		
	}

	@Override
	public void alter(User entity) throws Exception {
		userRepositoryImpl.save(entity);
		
	}

	@Override
	public void remove(User entity) throws Exception {
		userRepositoryImpl.delete(User.class,entity.getCodusers());
		
	}

	@Override
	public User findByPk(Long id) throws Exception {
		return userRepositoryImpl.findById(User.class, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<User> listAll() throws Exception {
		return userRepositoryImpl.findAll(User.class);
	}
}
