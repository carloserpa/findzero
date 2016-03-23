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

import com.findzero.ejb.model.Like;
import com.findzero.ejb.service.LikeService;

@Path("like")
public class LikeResource {
	@EJB
	LikeService likeService;
			
	@GET
	@Path("/test")
	@Produces("text/plain")	
	public String test() throws Exception{
		return Boolean.TRUE.toString();
	}
	
	@GET
	@Path("/list")	
	@Produces("application/json")
	public List<Like> listAll() throws Exception{
		List<Like> likes = likeService.listAll();
		return likes;
		
	}
	
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addLike(Like like) throws Exception {
		likeService.add(like);
		return "Adicionado com sucesso";
	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String alterLike(Like like) throws Exception {
		likeService.alter(like);
		return "Atualizado com sucesso";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeLike(@PathParam("id") Long id) throws Exception {
		Like like = likeService.findByPk(id);
		likeService.remove(like);
		return "Deletado com sucesso";
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Like findLikeByPK(@PathParam("id") Long id) throws Exception {
		return likeService.findByPk(id);
	}
	
	@GET
	@Path("/count/{id}")	
	@Produces("application/json")
	public Integer countBy(@PathParam("id") Long id) throws Exception{
		return likeService.countByProduct(id);
		
	}
	
	@GET
	@Path("/find/{id}")	
	@Produces("application/json")
	public List<Like> findBy(@PathParam("id") Long id) throws Exception{
		return likeService.findByProduct(id);
		
	}
	

	@GET
	@Path("/countuser/{id}")	
	@Produces("application/json")
	public Integer countByUser(@PathParam("id") Long id) throws Exception{
		return likeService.countByUser(id);
		
	}
	
	@GET
	@Path("/finduser/{id}")	
	@Produces("application/json")
	public List<Like> findByUser(@PathParam("id") Long id) throws Exception{
		return likeService.findByUser(id);
		
	}
	
}
