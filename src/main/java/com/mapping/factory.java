package com.mapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class factory {

	public static void main(String[] args) {
		
          Configuration con=new Configuration().configure().addAnnotatedClass(worker.class).addAnnotatedClass(location.class);
          SessionFactory sf=con.buildSessionFactory();
          Session ses=sf.openSession();
          Transaction tx=ses.beginTransaction();
          
//          location loc1=new location();
//          loc1.setLocationId(101);
//          loc1.setLocationName("hyd");
//          loc1.setLocationState("ts");
//          
//          location loc2=new location();
//          loc2.setLocationId(102);
//          loc2.setLocationName("vizag");
//          loc2.setLocationState("ap");
//          
//          worker w1=new worker();
//          w1.setWorkerId(7);
//          w1.setWorkerName("bindu");
//          w1.setWorkerField("networking");
//          w1.setWorkerLocation(loc1);
//          
//          worker w2=new worker();
//          w2.setWorkerId(6);
//          w2.setWorkerName("ramya");
//          w2.setWorkerField("designing");
//          w2.setWorkerLocation(loc1);
//          
//          worker w3=new worker();
//          w3.setWorkerId(5);
//          w3.setWorkerName("manvitha");
//          w3.setWorkerField("accounts");
//          w3.setWorkerLocation(loc2);
//          
//          ses.save(w3);
//          ses.save(w2);
//          ses.save(w1);
//          ses.save(loc1);
//          ses.save(loc2);
//          
          
          Query qu=ses.createQuery("from worker");
          List <worker> workerlist=qu.getResultList();
          
          for(worker w:workerlist)
          {
        	  System.out.println(w.getWorkerName()+" from "+w.getWorkerLocation().getLocationName());
          }
          
          
          tx.commit();
	}

}
