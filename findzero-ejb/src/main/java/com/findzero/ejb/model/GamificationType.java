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


/**
 * The persistent class for the gamification_type database table.
 * 
 */
@Entity
@Table(name="gamification_type")
@NamedQuery(name="GamificationType.findAll", query="SELECT g FROM GamificationType g")
public class GamificationType implements Serializable, EntityBase {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codgamification;

	private String description;

	//bi-directional many-to-one association to UsersGroup
	@OneToMany(mappedBy="gamificationType")
	private List<UsersGroup> usersGroups;

	public GamificationType() {
	}

	public Long getCodgamification() {
		return this.codgamification;
	}

	public void setCodgamification(Long codgamification) {
		this.codgamification = codgamification;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UsersGroup> getUsersGroups() {
		return this.usersGroups;
	}

	public void setUsersGroups(List<UsersGroup> usersGroups) {
		this.usersGroups = usersGroups;
	}

	public UsersGroup addUsersGroup(UsersGroup usersGroup) {
		getUsersGroups().add(usersGroup);
		usersGroup.setGamificationType(this);

		return usersGroup;
	}

	public UsersGroup removeUsersGroup(UsersGroup usersGroup) {
		getUsersGroups().remove(usersGroup);
		usersGroup.setGamificationType(null);

		return usersGroup;
	}

	@Override
	public Serializable getId() {
		return this.codgamification;
	}

}