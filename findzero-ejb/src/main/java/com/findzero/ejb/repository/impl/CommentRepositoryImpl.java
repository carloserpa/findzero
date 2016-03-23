package com.findzero.ejb.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.findzero.ejb.model.Comment;
import com.findzero.ejb.repository.RepositoryBase;

public class CommentRepositoryImpl extends RepositoryBase<Comment> implements CommentRepository {

	public CommentRepositoryImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Comment> findByProduct(Long idProduct) throws Exception {
		Query query = this.getEntityManager().createNativeQuery("SELECT c.* FROM comment c WHERE c.codproduct = :id",
				Comment.class);

		query.setParameter("id", idProduct);
		List<Comment> comments = query.getResultList();
		return comments;
	}

	@Override
	public Integer countByProduct(Long idProduct) throws Exception {
		Query query = this.getEntityManager()
				.createNativeQuery("SELECT count(c.*) FROM comment c WHERE c.codproduct = :id");

		query.setParameter("id", idProduct);

		return ((BigInteger) query.getSingleResult()).intValue();
	}

	/**
	 * Busca os comentarios todos os usuarios
	 */
	@Override
	public List<Comment> findByUser(Long idUser) throws Exception {
		Query query = this.getEntityManager().createNativeQuery("SELECT c.* FROM comment c WHERE c.codusers = :id",
				Comment.class);
		query.setParameter("id", idUser);
		List<Comment> comments = query.getResultList();
		return comments;
	}

	@Override
	public Integer countByUser(Long idUser) throws Exception {

		Query query = this.getEntityManager()
				.createNativeQuery("SELECT count(c.*) FROM comment c WHERE c.codusers = :id");

		query.setParameter("id", idUser);
		return ((BigInteger) query.getSingleResult()).intValue();
	}

}
