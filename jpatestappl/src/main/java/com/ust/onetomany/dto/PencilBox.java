package com.ust.onetomany.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pencilbox")
public class PencilBox {
	@Id
	@Column
	private int boxId;
	@Column
	private String boxName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "boxId", nullable = false)
	List<Pencil> pId;

	public List<Pencil> getpId() {
		return pId;
	}

	public void setpId(List<Pencil> pId) {
		this.pId = pId;
	}

	public int getBoxId() {
		return boxId;
	}

	public void setBoxId(int boxId) {
		this.boxId = boxId;
	}

	public String getBoxName() {
		return boxName;
	}

	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}

}
