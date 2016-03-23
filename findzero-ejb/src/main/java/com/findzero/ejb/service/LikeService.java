package com.findzero.ejb.service;

import java.util.List;

import com.findzero.ejb.model.Like;

public interface LikeService extends ServiceBase<Like>{
	
	public List<Like> findByProduct(Long idProduct) throws Exception;
	public Integer countByProduct(Long idProduct) throws Exception;
	
	
	public List<Like> findByUser(Long idUser) throws Exception;
	public Integer countByUser(Long idUser) throws Exception;
	
}
