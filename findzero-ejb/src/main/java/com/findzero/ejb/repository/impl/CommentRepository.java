package com.findzero.ejb.repository.impl;

import java.util.List;

import com.findzero.ejb.model.Comment;
import com.findzero.ejb.model.Product;
import com.findzero.ejb.service.ServiceBase;

public interface CommentRepository {
	public List<Comment> findByProduct(Product p) throws Exception;		
}
