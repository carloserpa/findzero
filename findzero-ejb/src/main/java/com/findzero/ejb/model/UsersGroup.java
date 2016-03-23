package com.findzero.ejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the users_group database table.
 * 
 */
@Entity
@Table(name="users_group")
@NamedQuery(name="UsersGroup.findAll", query="SELECT u FROM UsersGroup u")
@XmlRootElement
public class UsersGroup implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codusersgroup;

	private String description;

	//bi-directional many-to-one association to User
	@Transient
	@OneToMany(mappedBy="usersGroup")
	private List<User> users;

	//bi-directional many-to-one association to GamificationType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codgamification")
	private GamificationType gamificationType;

	public UsersGroup() {
	}

	public Long getCodusersgroup() {
		return this.codusersgroup;
	}

	public void setCodusersgroup(Long codusersgroup) {
		this.codusersgroup = codusersgroup;
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
		user.setUsersGroup(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUsersGroup(null);

		return user;
	}

	public GamificationType getGamificationType() {
		return this.gamificationType;
	}

	public void setGamificationType(GamificationType gamificationType) {
		this.gamificationType = gamificationType;
	}

	@Override
	public Serializable getId() {
		return this.codusersgroup;
	}

}