package com.te.DesignPattren.hibernate.DTO.DesignPattren;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
@Id
private int eid;
private String ename;
private double sal;
private long ph_no;
}
