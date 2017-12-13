package com.pratik.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Type;

@Entity
@Table(name="person")
@NamedQueries({
				@NamedQuery(name="select_All",query="from person"),
				@NamedQuery(name="select_by_range",query="select pid,pname from person where sal=:salary")
})
public class person {
	private int pid;
	private String pname;
	private Jobs job;
@Id
@Column(name="PID",length=15)
@Type(type="int")
@GenericGenerator(name="gen",strategy="increment")
@GeneratedValue(generator="gen")
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

@Column(name="Pname",length=15)
@Type(type="string")
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	@Embedded
	public Jobs getJob() {
		return job;
	}
	public void setJob(Jobs job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "person [pid=" + pid + ", pname=" + pname + ", job=" + job + "]";
	}
	
}
