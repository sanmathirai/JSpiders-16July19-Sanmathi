package com.ustglobal.jpawithhibernateapp.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "Pencil")
public class Pencil {
	@Id
	@Column
	private int pid;
	@Column
	private String color;
	
	@ManyToOne
	@JoinColumn(name = "bid" , nullable = false)//passing foreign key
	private PencilBox pencilBox;
}
