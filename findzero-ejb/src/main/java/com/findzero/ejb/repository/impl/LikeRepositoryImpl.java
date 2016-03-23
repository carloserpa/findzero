package com.findzero.ejb.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.findzero.ejb.model.Like;
import com.findzero.ejb.repository.RepositoryBase;

public class LikeRepositoryImpl extends RepositoryBase<Like> implements LikeRepository {

	public LikeRepositoryImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Like> findByProduct(Long idProduct) throws Exception {
		Query query = this.getEntityManager().createNativeQuery("SELECT l.* FROM likes l WHERE l.codproduct = :id",
				Like.class);

		query.setParameter("id", idProduct);
		List<Like> likes = query.getResultList();
		return likes;
	}

	@Override
	public Integer countByProduct(Long idProduct) throws Exception {
		Query query = this.getEntityManager()
				.createNativeQuery("SELECT count(l.*) FROM likes l WHERE l.codproduct = :id");

		query.setParameter("id", idProduct);

		return ((BigInteger) query.getSingleResult()).intValue();
	}

	/**
	 * Busca os comentarios todos os usuarios
	 */
	@Override
	public List<Like> findByUser(Long idUser) throws Exception {
		Query query = this.getEntityManager().createNativeQuery("SELECT l.* FROM likes l WHERE l.codusers = :id",
				Like.class);
		query.setParameter("id", idUser);
		List<Like> likes = query.getResultList();
		return likes;
	}

	@Override
	public Integer countByUser(Long idUser) throws Exception {

		Query query = this.getEntityManager()
				.createNativeQuery("SELECT count(l.*) FROM likes l WHERE l.codusers = :id");

		query.setParameter("id", idUser);
		return ((BigInteger) query.getSingleResult()).intValue();
	}

}
