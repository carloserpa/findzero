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

import com.findzero.ejb.model.User;
import com.findzero.ejb.service.UserService;

@Path("user")
public class UserResource {
	@EJB
	UserService userService;
			
	@GET
	@Path("/test")
	@Produces("text/plain")	
	public String test() throws Exception{
		return Boolean.TRUE.toString();
	}
	
	@GET
	@Path("/list")	
	@Produces("application/json")
	public List<User> listUsers() throws Exception{
		List<User> users = userService.listAll();
		return users;
		
	}
	
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addUser(User user) throws Exception {
		userService.add(user);
		return "Adicionado com sucesso";
	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String alterUser(User user) throws Exception {
		userService.alter(user);
		return "Atualizado com sucesso";
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeUser(@PathParam("id") Long id) throws Exception {
		User user = userService.findByPk(id);
		userService.remove(user);
		return "Deletado com sucesso";
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public User findUserByPK(@PathParam("id") Long id) throws Exception {
		return userService.findByPk(id);
	}

}
