package com.findzero.ejb.repository.impl;

import java.util.List;

import com.findzero.ejb.model.Product;

public interface ProductRepository { 
	public List<Product> findAllProductAndPictures() throws Exception;
}
