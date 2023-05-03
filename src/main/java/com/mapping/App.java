package com.mapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(student.class).addAnnotatedClass(bike.class);
    	SessionFactory sf=con.buildSessionFactory();
    	Session ses=sf.openSession();
    	Transaction tx=ses.beginTransaction();
    	
//    	bike b1=new bike();
//    	b1.setBikeId(101);
//    	b1.setBikeName("BMW");
//    	
//    	
//    	bike b2=new bike();
//    	b2.setBikeId(102);
//    	b2.setBikeName("FZ");
//    	
//    	student s1=new student();
//    	s1.setStuId(1);
//    	s1.setStuName("bindu");
//    	s1.setStuClass("mca");
//    	s1.setBike(b1);
//    	
//    	
//    	student s2=new student();
//    	s2.setStuId(2);
//    	s2.setStuName("ramya");
//    	s2.setStuClass("mba");
//    	s2.setBike(b2);
//    	
//    	ses.save(b1);
//    	ses.save(b2);
//    	ses.save(s1);
//    	ses.save(s2);
//    	
    	
    	
    	Query qu=ses.createQuery("from student");
    	List<student> li=qu.getResultList();//or you can use qu.list();
    	for(student m:li)
    	{
    		System.out.println(m.getStuName());
    	}
    	
    
        tx.commit();
    }
}