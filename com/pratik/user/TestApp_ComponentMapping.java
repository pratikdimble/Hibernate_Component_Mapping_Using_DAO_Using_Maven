package com.pratik.user;

import com.pratik.DAO.DAO_Factory;
import com.pratik.DAO.DAO_Interface;
import com.pratik.domain.Jobs;
import com.pratik.domain.person;

public class TestApp_ComponentMapping {

	public static void main(String[] args) {
		//create session

		Jobs j=null;
		person p=null;
		//save the object or set the values
		j=new Jobs();
		j.setDsgn("Developer");j.setSal(40000f);j.setCompany("Persistent");
		
		p=new person();
		p.setPid(103);p.setPname("Queen");p.setJob(j);
		
		//use the DAO
		DAO_Interface dao=null;
		dao=DAO_Factory.getInstance();
			System.out.println("\n\tID: "+dao.savedata(p));
	}

}
