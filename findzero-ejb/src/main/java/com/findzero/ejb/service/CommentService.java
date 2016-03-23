package com.findzero.ejb.service;

import java.math.BigInteger;
import java.util.List;

import com.findzero.ejb.model.Comment;

public interface CommentService extends ServiceBase<Comment>{
	
	public List<Comment> findByProduct(Long idProduct) throws Exception;
	public Integer countByProduct(Long idProduct) throws Exception;
	
	
	public List<Comment> findByUser(Long idUser) throws Exception;
	public Integer countByUser(Long idUser) throws Exception;
	
}

