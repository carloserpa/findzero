package com.findzero.ejb.repository.impl;

import java.util.List;

import com.findzero.ejb.model.Like;
import com.findzero.ejb.model.Product;

public interface LikeRepository { 
	public List<Like>  findByProduct(Product p) throws Exception;
}
