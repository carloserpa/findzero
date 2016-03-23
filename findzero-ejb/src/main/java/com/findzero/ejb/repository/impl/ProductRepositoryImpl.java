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
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT P.CODPRODUCT as codProduct, ");
		sql.append("P.DESCRIPTION as description, ");
		sql.append("P.PRICE as price, ");
		sql.append("P.LOCATIONNAME as locationName, ");
		sql.append("P.LOCATIONNAME as locationName, ");
		sql.append("P.LOCATIONCOOD as locationCood, ");
		sql.append("PI.URL as url, ");
		sql.append("COUNT(C.CODCOMMENT) as comments, ");
		sql.append("COUNT(DISTINCT L.CODLIKES) as likes ");
		sql.append("FROM PRODUCT P ");
		sql.append("LEFT JOIN COMMENT C ");
		sql.append("ON P.CODPRODUCT = C.CODPRODUCT ");
		sql.append("LEFT JOIN LIKES L ");
		sql.append("ON P.CODPRODUCT = L.CODPRODUCT ");
		sql.append("LEFT JOIN PICTURE PI ");
		sql.append("ON PI.CODPRODUCT = P.CODPRODUCT ");
		sql.append("AND PI.PRINCIPAL = TRUE ");
		sql.append("GROUP BY P.CODPRODUCT, ");
		sql.append("P.DESCRIPTION, ");
		sql.append("P.PRICE, ");
		sql.append("PI.URL");
		
		Query query = this.getEntityManager().createNativeQuery(sql.toString(),	ProductVO.class);
		List<ProductVO> products = query.getResultList();
		return products;
	}

}
