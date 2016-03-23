package com.findzero.ejb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.findzero.ejb.model.Product;
import com.findzero.ejb.model.vo.ProductVO;
import com.findzero.ejb.repository.RepositoryBase;

public class ProductRepositoryImpl extends RepositoryBase<Product> implements ProductRepository {

	public ProductRepositoryImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Product> findAllProductAndPictures() throws Exception {
		CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Product> c = cb.createQuery(Product.class);
		Root<Product> product = c.from(Product.class);
		product.fetch("pictures", JoinType.LEFT);
		product.fetch("user", JoinType.LEFT);
		product.fetch("likes", JoinType.LEFT);
		// product.fetch("comments",JoinType.LEFT);
		TypedQuery<Product> typedQuery = super.getEntityManager().createQuery(c);
		List<Product> listProducts = typedQuery.getResultList();
		//for (Product product2 : listProducts) {
			//super.getEntityManager().detach(product2);
		//}
		return listProducts;
		// return super.findAll(Product.class);

	}

	public List<ProductVO> findAllProductVO() throws Exception {
		Query query = this.getEntityManager()
				.createNativeQuery(
						"SELECT P.CODPRODUCT as codProduct, "+
						"P.DESCRIPTION as description, "+
						"P.PRICE as price, "+
						"P.LOCATIONNAME as locationName, "+
						"P.LOCATIONCOOD as locationCood, "+
						"PI.URL as url, "+
						"COUNT(C.CODCOMMENT) as comments, "+
						"COUNT(DISTINCT L.CODLIKES) as likes "+
						"FROM PRODUCT P "+
						"LEFT JOIN COMMENT C "+
						"ON P.CODPRODUCT = C.CODPRODUCT "+
						"LEFT JOIN LIKES L "+
						"ON P.CODPRODUCT = L.CODPRODUCT "+
						"LEFT JOIN PICTURE PI "+
						"ON PI.CODPRODUCT = P.CODPRODUCT "+
						"AND PI.PRINCIPAL = TRUE "+
						"GROUP BY P.CODPRODUCT, "+
						"P.DESCRIPTION, "+
						"P.PRICE, "+
						"PI.URL",
						ProductVO.class);
		List<ProductVO> products = query.getResultList();
		return products;
	}

}
