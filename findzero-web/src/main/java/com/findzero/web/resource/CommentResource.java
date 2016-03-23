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

import com.findzero.ejb.model.Comment;
import com.findzero.ejb.service.CommentService;

@Path("comment")
public class CommentResource {
	@EJB
	CommentService commentService;
			
	@GET
	@Path("/test")
	@Produces("text/plain")	
	public String test() throws Exception{
		return Boolean.TRUE.toString();
	}
	
	@GET
	@Path("/list")	
	@Produces("application/json")
	public List<Comment> listAll() throws Exception{
		List<Comment> comments = commentService.listAll();
		return comments;
		
	}
	
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addComment(Comment comment) throws Exception {
		commentService.add(comment);
		return "Adicionado com sucesso";
	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String alterComment(Comment comment) throws Exception {
		commentService.alter(comment);
		return "Atualizado com sucesso";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeComment(@PathParam("id") Long id) throws Exception {
		Comment comment = commentService.findByPk(id);
		commentService.remove(comment);
		return "Deletado com sucesso";
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Comment findCommentByPK(@PathParam("id") Long id) throws Exception {
		return commentService.findByPk(id);
	}
	
	@GET
	@Path("/count/{id}")	
	@Produces("application/json")
	public Integer countBy(@PathParam("id") Long id) throws Exception{
		return commentService.countByProduct(id);
		
	}
	
	@GET
	@Path("/find/{id}")	
	@Produces("application/json")
	public List<Comment> findBy(@PathParam("id") Long id) throws Exception{
		return commentService.findByProduct(id);
		
	}
	

	@GET
	@Path("/countuser/{id}")	
	@Produces("application/json")
	public Integer countByUser(@PathParam("id") Long id) throws Exception{
		return commentService.countByUser(id);
		
	}
	
	@GET
	@Path("/finduser/{id}")	
	@Produces("application/json")
	public List<Comment> findByUser(@PathParam("id") Long id) throws Exception{
		return commentService.findByUser(id);
		
	}
	
}
