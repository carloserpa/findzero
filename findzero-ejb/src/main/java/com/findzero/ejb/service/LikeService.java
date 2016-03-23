package com.findzero.ejb.service;

import java.util.List;

import com.findzero.ejb.model.Like;
import com.findzero.ejb.model.Product;

public interface LikeService extends ServiceBase<Like>{
	public List<Like> findByProduct(Product p) throws Exception;
}
