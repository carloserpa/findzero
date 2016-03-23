package com.findzero.ejb.repository.impl;

import javax.persistence.EntityManager;

import com.findzero.ejb.model.Picture;
import com.findzero.ejb.repository.RepositoryBase;

public class PictureRepositoryImpl extends RepositoryBase<Picture> implements PictureRepository {

	public PictureRepositoryImpl(EntityManager em) {
		super(em);
	}


}
