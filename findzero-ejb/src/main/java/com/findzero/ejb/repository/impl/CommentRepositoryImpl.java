package com.findzero.ejb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.findzero.ejb.model.Comment;
import com.findzero.ejb.model.Product;
import com.findzero.ejb.repository.RepositoryBase;

public class CommentRepositoryImpl extends RepositoryBase<Comment> implements CommentRepository {

	public CommentRepositoryImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Comment> findByProduct(Product p) throws Exception {
		CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();  
		CriteriaQuery<Comment> c = cb.createQuery(Comment.class);
		Root<Comment> comment = c.from(Comment.class);
		//comment.fetch("comments",JoinType.LEFT);
		TypedQuery<Comment> typedQuery= super.getEntityManager().createQuery(c);  
		List<Comment> listComments = typedQuery.getResultList();
		//for (Comment comment2 : listComments) {
			//super.getEntityManager().detach(comment2);
		//}
		return listComments;
		//return super.findAll(Comment.class);
		
	}

}
