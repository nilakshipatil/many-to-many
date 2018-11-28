package demo;


import java.sql.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class MMClient {
	
	public static SessionFactory sf = HibernateUtil.getSessionfactory();
	public static void list(){
		Session session = null;
		
		try {
			session = sf.openSession();
						
		List<Event> events = session.createQuery("select e from Event e ").list();
			for (Event event : events) {
				System.out.println(event + "\t\t"+  event.getAttendees().size());
				
			}
			
		} catch (Exception e) {
			System.out.println("Exception " + e);
		} finally {
			session.close();
		}
	}
	public static void modify (){
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
	/*		Person p1 = session.get(Person.class, 1);
			Event e1 = session.get(Event.class,"e1");
			//	p1.getCommitments().add(e1);
			e1.getAttendees().add(p1);*/
			
			Person p1 = session.get(Person.class, 3);
			Person p2 = session.get(Person.class, 5);
			Event e1 = session.get(Event.class,"e1");
			e1.getAttendees().add(p1);
			e1.getAttendees().add(p2);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Exception " + e);
		} finally {
			session.close();
		}
	}
	public static void insert (){
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			for(int i = 1;i <4;i++){
				Event e = new Event();
				e.setEventid("e" + i);
				e.setDesc("mydesp" + i);
				e.setEventdate(new Date(new java.util.Date().getTime()));
				session.save(e);
			}
			for(int i = 1;i <6;i++){
				Person p1 =new Person();
				p1.setPid(i);
				p1.setName("Nameof"+i);
				session.save(p1);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Exception " + e);
		} finally {
			session.close();
		}
	}
	
	public static void main(String[] args) {
		insert();
		modify();
		list();
		sf.close();
	}
}
