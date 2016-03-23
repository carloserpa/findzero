package com.findzero.ejb.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import com.findzero.ejb.model.Picture;
import com.findzero.ejb.repository.InjectRepository;
import com.findzero.ejb.repository.RepositoryAnnotation;
import com.findzero.ejb.repository.impl.PictureRepositoryImpl;

@Stateful
@Interceptors({InjectRepository.class})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PictureServiceImpl implements PictureService {
	@RepositoryAnnotation
	PictureRepositoryImpl pictureRepositoryImpl;
	
	@Override
	public void add(Picture entity) throws Exception {
		pictureRepositoryImpl.save(entity);
		
	}

	@Override
	public void alter(Picture entity) throws Exception {
		pictureRepositoryImpl.save(entity);
		
	}

	@Override
	public void remove(Picture entity) throws Exception {
		pictureRepositoryImpl.delete(Picture.class,entity.getCodpicture());
		
	}

	@Override
	public Picture findByPk(Long id) throws Exception {
		return pictureRepositoryImpl.findById(Picture.class, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Picture> listAll() throws Exception {
		return pictureRepositoryImpl.findAll(Picture.class);
	}
}
