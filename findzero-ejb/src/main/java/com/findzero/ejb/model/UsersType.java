package com.findzero.ejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the users_type database table.
 * 
 */
@Entity
@Table(name="users_type")
@NamedQuery(name="UsersType.findAll", query="SELECT u FROM UsersType u")
@XmlRootElement
public class UsersType implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long coduserstype;

	private String description;

	//bi-directional many-to-one association to User
	@Transient
	@OneToMany(mappedBy="usersType")
	private List<User> users;

	public UsersType() {
	}

	public Long getCoduserstype() {
		return this.coduserstype;
	}

	public void setCoduserstype(Long coduserstype) {
		this.coduserstype = coduserstype;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUsersType(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUsersType(null);

		return user;
	}

	@Override
	public Serializable getId() {
		return this.coduserstype;
	}

}