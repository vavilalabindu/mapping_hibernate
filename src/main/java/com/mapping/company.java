package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

public class company {

	public static void main(String[] args) {
		Configuration con=new Configuration().configure().addAnnotatedClass(employee.class).addAnnotatedClass(projects.class);
		SessionFactory sf=con.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		
		projects p1=new projects();
		p1.setProjectId(101);
		p1.setProjectName("java");
		
		projects p2=new projects();
		p2.setProjectId(102);
		p2.setProjectName("angular");
		
		projects p3=new projects();
		p3.setProjectId(103);
		p3.setProjectName("react");
		
		List<projects> projectlist=new ArrayList<projects>();
		projectlist.add(p1);
		projectlist.add(p2);
		
		List<projects> projectlist2=new ArrayList<projects>();
		projectlist2.add(p3);
		
		employee e1=new employee();
		e1.setEmpId(1);
		e1.setEmpName("bindu");
		e1.setEmpLocation("hyd");
		e1.setProject(projectlist);
		
		employee e2=new employee();
		e2.setEmpId(2);
		e2.setEmpName("ramya");
		e2.setEmpLocation("pak");
		e2.setProject(projectlist2);
		
		
		System.out.println(e1.getEmpName());
		ses.save(p1);
		ses.save(p2);
		ses.save(p3);
		ses.save(e1);
		ses.save(e2);
		
		Query qu=ses.createQuery("from employee");
		List<employee> emplist=qu.getResultList();
		
		for(employee emp:emplist)
		{
			//System.out.println(emp.getProject());
			
		   List<projects> pp=emp.getProject();
		   for(projects p:pp)
		   {
			 System.out.println(emp.getEmpName()+" is working in "+p.getProjectName());  
		   }
		}
		
		
		
		
		tx.commit();

	}

}
