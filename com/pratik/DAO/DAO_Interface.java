package com.pratik.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.pratik.domain.person;
import com.pratik.utility.HibernateUtil;



public class DAO_Impl implements DAO_Interface {

	public int savedata(person details) {
		Session ses=null;
		Transaction tx=null;
		SessionFactory factory=null;
		int idVal=0;
		Configuration cfg=null;
	cfg=new Configuration();
	cfg=cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
	factory=cfg.buildSessionFactory();
		//get the session
		//ses=HibernateUtil.getSession();
	ses=factory.openSession();
		
		try {
			tx=ses.beginTransaction();			//begin the transaction for inserting
			idVal=(Integer)ses.save(details);	//save the record
			tx.commit();				//commit the transaction
		}catch (HibernateException he) {
			he.printStackTrace();
		tx.rollback();
		}
		catch (Exception e) {
			e.printStackTrace();
		tx.rollback();
		}
		HibernateUtil.closeSession(ses);
		return idVal;
	}//end getdata()method
	
	public List<person> getdata() {
		List<person> plist=null;
		Session ses=null;
		//get the session
		ses=HibernateUtil.getSession();
		//access the named query
		Query q=ses.getNamedQuery("select_All");
		//execute the QBC logic
		plist=q.list();
		//diaplsy the list
		plist.forEach(p->{
			System.out.println(p);
		});
		
		return null;
	}//end method
	
	@Override
	public List<Object[]> getdataCondition() {
		List<Object[]> newlist=null;
		Session ses=null;
		//get the session
		ses=HibernateUtil.getSession();
			//access the named query
		Query q=ses.getNamedQuery("select_by_range");
		q.setParameter("salary", 50000f);
			//execute the query
		newlist=q.list();
		newlist.forEach(row->{
			for(Object val:row)
			{
				System.out.println("--->"+val);
			}
			System.out.println();
			
		});
		
		return null;
	}

}//end class
