package com.findzero.ejb.service;

import java.util.List;

import com.findzero.ejb.model.Product;
import com.findzero.ejb.model.vo.ProductVO;

public interface ProductService extends ServiceBase<Product>{
	public List<ProductVO> listAllProductVO() throws Exception;
}
