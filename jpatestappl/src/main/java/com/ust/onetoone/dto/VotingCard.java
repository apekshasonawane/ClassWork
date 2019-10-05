package com.ust.onetoone.dto;

import javax.persistence.CascadeType ;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="votingCard")
public class VotingCard {

	@Id
	@Column
	private int v_id;
	@Column
	private String name;
	@OneToOne(mappedBy = "voterId")
	private Person id;
	

	public Person getId() {
		return id;
	}
	public void setId(Person id) {
		this.id = id;
	}
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
