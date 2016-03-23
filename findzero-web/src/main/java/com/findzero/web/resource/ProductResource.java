package com.findzero.web.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.findzero.ejb.model.Product;
import com.findzero.ejb.model.vo.ProductVO;
import com.findzero.ejb.service.ProductService;

@Path("product")
public class ProductResource {
	@EJB
	ProductService productService;
			
	@GET
	@Path("/test")
	@Produces("text/plain")	
	public String test() throws Exception{
		return Boolean.TRUE.toString();
	}
	
	@GET
	@Path("/list")	
	@Produces("application/json")
	public List<ProductVO> listAll() throws Exception{
		List<ProductVO> products = productService.listAllProductVO();
		return products;
		
	}
	
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addProduct(Product product) throws Exception {
		productService.add(product);
		return "Adicionado com sucesso";
	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String alterProduct(Product product) throws Exception {
		productService.alter(product);
		return "Atualizado com sucesso";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeProduct(@PathParam("id") Long id) throws Exception {
		Product product = productService.findByPk(id);
		productService.remove(product);
		return "Deletado com sucesso";
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Product findProductByPK(@PathParam("id") Long id) throws Exception {
		return productService.findByPk(id);
	}

}
