package com.ustglobal.lms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class Admin {
@Id
@Column
private int admin_id;
@Column
private String admin_name;
@Column
private String admin_password;

}
