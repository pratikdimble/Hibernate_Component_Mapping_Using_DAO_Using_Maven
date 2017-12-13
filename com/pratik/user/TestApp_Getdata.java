package com.pratik.user;

import com.pratik.DAO.DAO_Factory;
import com.pratik.DAO.DAO_Interface;
import com.pratik.domain.Jobs;
import com.pratik.domain.person;

public class TestApp_Getdata {

	public static void main(String[] args) {
		//create session

		Jobs j=null;
		person p=null;
		
		//use the DAO
		DAO_Interface dao=null;
		dao=DAO_Factory.getInstance();
		
		dao.getdata();
	}

}
