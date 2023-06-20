package com.hibernatefirst;

import java.text.Annotation;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory  factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    
	    //to save data
	   /* Student s1 = new Student();
		s1.setId(6);
		s1.setName("yashsvi");
		s1.setAddress("vardha");
		s1.setSalary(20000);
		session.save(s1);// automatically insert into table by using api save */
	    
	   //to fetch single record
	   /* Student student = (Student) session.get(Student.class,1);
	    System.out.println("fetching single Record");
	    System.out.println("Student id:"+student.getId());
	    System.out.println("Student name:"+student.getName());
	    System.out.println("Student address:"+student.getAddress());*/
	    
	    //fetch list of record
	  /* System.out.println("fetching list from Record");
	  
	    List<Student> list= session.createQuery("from Student As S").list();
        Iterator<Student> itr =list.iterator();
	    while(itr.hasNext())
	    {
	    	Student student =(Student)itr.next();
	    	System.out.println("Student id:"+student.getId());
	  	    System.out.println("Student name:"+student.getName());
	  	    System.out.println("Student address:"+student.getAddress());
	  	    System.out.println("Student salary:"+student.getSalary());
	    }*/
	    
	    
	    //fetch by id
	   /* Student student=(Student)session.get(Student.class, 1);
	    System.out.println("name:"+student.getName());*/
	    
	    //update
	   /* Student s1 = new Student();
		s1.setId(4);
		s1.setName("Shree");
		s1.setAddress("chandrapur");
		session.update(s1);*/
		
		//delete
		  /*  Student s1 = new Student();
			s1.setId(1);
			session.delete(s1);*/
	    
	    //from clause
	   /* System.out.println("fetching list from Record");
	   
	    String hql = "FROM Student AS S";
	    Query query = session.createQuery(hql);
	    List result = query.list();
	    Iterator itr =result.iterator();
	    while(itr.hasNext())
	    {
	    	Student student =(Student)itr.next();
	        System.out.println("Student id:"+student.getId());
	  	    System.out.println("Student name:"+student.getName());
	  	    System.out.println("Student address:"+student.getAddress());
	    }*/
       
	    //Group by
	   
	    /*String hql = "select S.name FROM Student S " + "GROUP BY S.name";
	    Query query = session.createQuery(hql);
	    List<String> result = query.list();
	    Iterator itr =result.iterator();
	    while(itr.hasNext())
	    {
	    	String student = (String)itr.next();
	    	System.out.println("Student name is:"+student);
	    }*/
	    
	   /*String hql = "SELECT S.name FROM Student AS S";
	    Query query = session.createQuery(hql);
	    List lists = query.list();
	    Iterator itr =lists.iterator();
	    while(itr.hasNext())
	    {
	    	String student = (String)itr.next();
	    	System.out.println("Student name is:"+student);
	    }*/
	    
	    /*String hql = "FROM Student S WHERE S.id = 3";
	    Query query = session.createQuery(hql);
	    List results = query.list();
	    Iterator itr =results.iterator();
	    while(itr.hasNext())
	    {
	    	Student student = (Student)itr.next();
	    	System.out.println("Student record is:"+student.getId()+ " "+student.getName()+" "+student.getAddress()+" "+student.getSalary());
	    }*/
	    
	    /*String hql = "FROM Student S WHERE S.id > 3 " +   "ORDER BY S.name DESC, S.salary DESC ";
	    Query query = session.createQuery(hql);
	    List results = query.list();
	    Iterator itr =results.iterator();
	    while(itr.hasNext())
	    {
	    	Student student = (Student)itr.next();
	    	System.out.println("Student record is:"+student.getId()+ " "+student.getName()+" "+student.getAddress()+" "+student.getSalary());
	    }*/
	    
	    //not run yet
	   String hql = "UPDATE Student set salary = :salary "  +  "WHERE id = :id";
	   Query query = session.createQuery(hql);
	   query.setParameter("salary", 15000);
	   query.setParameter("id", 3);
	   int res = query.executeUpdate();
	   System.out.println("Rows affected: " + res);
	    
	    //count
	   /* String hql = "select count(S.name) FROM Student S";
	    Query query =session.createQuery(hql);
	    long count = (long) query.list().get(0);
	    System.out.println("count:"+count);*/
	    
	    
	    //Restrictions
	    
	   /* System.out.println("hibernet operation using create criteria ");
	    Criteria cri = session.createCriteria(Student.class);
	    List<Student>list = cri.list();
	    Iterator itr =list.iterator();
	    while(itr.hasNext())
	    {
	    	Student student = (Student)itr.next();
	    	System.out.println("Student id:"+student.getId()+"  Student name:"+student.getName());
	    }*/
	    
	    
	    //not run yet
	   /* System.out.println("hibernet operation with Restriction");
	    Criteria criteria = session.createCriteria(Student.class);
	    criteria.add(Restrictions.between("salary", 10000, 70000));
	    List<Student>list = criteria.list();
	    Iterator itr =list.iterator();
	    while(itr.hasNext())
	    {
	    	Student student = (Student)itr.next();
	    	System.out.println("Student id:"+student.getId()+"  Student name:"+student.getName()+"  Student salary:"+student.getSalary());
	    }*/
	    
	   /* System.out.println("Hibernet opration with projection");
	    Criteria cri = session.createCriteria(Student.class);
	    cri.setProjection(Projections.rowCount());
	    System.out.println("RowCount:"+cri.list().get(0));*/
	    
		tx.commit();
		session.close();
	}

}
