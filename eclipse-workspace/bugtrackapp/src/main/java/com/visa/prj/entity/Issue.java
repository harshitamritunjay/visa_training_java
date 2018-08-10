package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="issues")
public class Issue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="desc",length=200)
	private String desc;
	
	@ManyToOne
	@JoinColumn(name="raised_by")
	private Employee raisedBy;
	
	@ManyToOne
	@JoinColumn(name="resolved_by")
	private Employee resolvedBy;
	 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Employee getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(Employee raisedBy) {
		this.raisedBy = raisedBy;
	}

	public Employee getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	@Column(name="raised_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date raisedDate= new Date();
	
	@Column(name="resolved_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date resolvedDate= new Date();
	
	private String solution;
	
	public Date getRaised_date() {
		return raisedDate;
	}
	public Date getResolved_date() {
		return resolvedDate;
	}
	
}
