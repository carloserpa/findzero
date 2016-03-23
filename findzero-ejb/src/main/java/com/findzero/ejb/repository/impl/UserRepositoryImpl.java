package com.findzero.ejb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.findzero.ejb.model.User;
import com.findzero.ejb.repository.RepositoryBase;

public class UserRepositoryImpl extends RepositoryBase<User> implements UserRepository{

	public UserRepositoryImpl(EntityManager em) {
		super(em);		
	}

	public List<User> findAll(){
		TypedQuery<User> query = super.getEntityManager().createNamedQuery("User.findAll", User.class);
	    List<User> results = query.getResultList();	    
		return results;
	}
		
}
