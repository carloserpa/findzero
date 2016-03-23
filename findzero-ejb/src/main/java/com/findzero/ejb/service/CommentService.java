package com.findzero.ejb.service;

import java.util.List;

import com.findzero.ejb.model.Comment;
import com.findzero.ejb.model.Product;

public interface CommentService extends ServiceBase<Comment>{
	public List<Comment> findByProduct(Product p) throws Exception;	
}
