package com.findzero.ejb.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

import com.findzero.ejb.model.Product;
import com.findzero.ejb.model.vo.ProductVO;
import com.findzero.ejb.repository.InjectRepository;
import com.findzero.ejb.repository.RepositoryAnnotation;
import com.findzero.ejb.repository.impl.ProductRepositoryImpl;

@Stateful
@Interceptors({InjectRepository.class})
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductServiceImpl implements ProductService {
	@RepositoryAnnotation
	ProductRepositoryImpl productRepositoryImpl;
	
	@Override
	public void add(Product entity) throws Exception {
		productRepositoryImpl.save(entity);
		
	}

	@Override
	public void alter(Product entity) throws Exception {
		productRepositoryImpl.save(entity);
		
	}

	@Override
	public void remove(Product entity) throws Exception {
		productRepositoryImpl.delete(Product.class,entity.getCodproduct());
		
	}

	@Override
	public Product findByPk(Long id) throws Exception {
		return productRepositoryImpl.findById(Product.class, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Product> listAll() throws Exception {
		return productRepositoryImpl.findAll(Product.class);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProductVO> listAllProductVO() throws Exception {
		return productRepositoryImpl.findAllProductVO();
	}
}
