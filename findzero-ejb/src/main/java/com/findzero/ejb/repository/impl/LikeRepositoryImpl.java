package com.findzero.ejb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.findzero.ejb.model.Like;
import com.findzero.ejb.model.Product;
import com.findzero.ejb.repository.RepositoryBase;

public class LikeRepositoryImpl extends RepositoryBase<Like> implements LikeRepository {

	public LikeRepositoryImpl(EntityManager em) {
		super(em);
	}

	
	
	@Override
	public List<Like> findByProduct(Product p) throws Exception {
		CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();  
		CriteriaQuery<Like> c = cb.createQuery(Like.class);
		Root<Like> like = c.from(Like.class);

		//like.fetch("comments",JoinType.LEFT);
		TypedQuery<Like> typedQuery= super.getEntityManager().createQuery(c);  
		List<Like> listLikes = typedQuery.getResultList();
		//for (Like like2 : listLikes) {
			//super.getEntityManager().detach(like2);
		//}
		return listLikes;
		
	}

}
