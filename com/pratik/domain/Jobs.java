package com.pratik.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable

public class Jobs {
	private String Dsgn;
	private float sal;
	private String company;

@Column(name="Dsgn",length=15)
@Type(type="string")
	public String getDsgn() {
		return Dsgn;
	}
	public void setDsgn(String dsgn) {
		Dsgn = dsgn;
	}

@Column(name="sal",length=15)
@Type(type="float")
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}

@Column(name="company",length=15)
@Type(type="string")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Jobs [Dsgn=" + Dsgn + ", sal=" + sal + ", company=" + company + "]";
	}
	
}
