package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

public class team {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con=new Configuration().configure().addAnnotatedClass(laptop.class).addAnnotatedClass(manager.class);
    	SessionFactory sf=con.buildSessionFactory();
    	Session ses=sf.openSession();
    	Transaction tx=ses.beginTransaction();
    	
	
  	laptop l1=new laptop();
    	l1.setLaptopId(101);
    	l1.setLaptopName("hp");
    	
    	laptop l2=new laptop();
    	l2.setLaptopId(102);
    	l2.setLaptopName("lenovo");
    	
        	laptop l3=new laptop() ;
        	l3.setLaptopId(103);
        	l3.setLaptopName("dell");
    	
   	    	List<laptop> laplist1= new ArrayList<>();
   	        laplist1.add(l1);
   	    	laplist1.add(l2);
    	

    	List<laptop> laplist2= new ArrayList<>();
    	laplist2.add(l3);
    	laplist2.add(l2);
    	
    	
    	List<laptop> laplist3= new ArrayList<>();
    	laplist3.add(l3);
    	
    	
    	manager m1=new manager();
    	m1.setManagerId(1);
    	m1.setManagerName("bindu");
    	m1.setManagerLocation("hyd");
    	m1.setLap(laplist1);
    	
    	manager m2=new manager();
    	m2.setManagerId(2);
    	m2.setManagerName("ramya");
    	m2.setManagerLocation("pak");
    	m2.setLap(laplist2);
    	
    	manager m3=new manager();
    	m3.setManagerId(3);
    	m3.setManagerName("manvitha");
    	m3.setManagerLocation("bnglr");
    	m3.setLap(laplist3);
    	
    	
    	ses.save(l1);
    	ses.save(l2);
    	ses.save(l3);
    	ses.save(m1);
    	ses.save(m2);
    	ses.save(m3);
    	
    	
    	Query qu=ses.createQuery("from manager");
    	List<manager> manlist=qu.getResultList();
    	for(manager m:manlist) {
    		List<laptop> lap=m.getLap();
    		for(laptop li:lap)
    		{
    			System.out.println(m.getManagerName()+" from "+m.getManagerLocation()+ " using "+li.getLaptopName());
    		}
    	}
    	
    	
    	tx.commit();

	}

}
