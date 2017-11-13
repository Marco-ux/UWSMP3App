package marco.uws.projects.UWSMP3App.controller;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MP3Controller {
	 
	/**
	 * Saves the given Object in its entity-table, if such a Table has been introduced to Hibernate in the hibernate.cfg.xml
	 * @param o Is the Object that should be added to the database
	 */
    public static void saveObject(Object o){
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.saveOrUpdate(o);
		session.beginTransaction().commit();
		session.close();
	}
    
    public static long saveObjectReturnsID(Object o){
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		Serializable ser = session.save(o);
		session.beginTransaction().commit();
		session.close();
		return (long) ser;
	}
    
    /**
	 * 
	 * Retrieves an Object with a primary key of type:string from the database.
	 * @param o Any Object from the same class of the desired output Object.
	 * @param primary The primary key of the desired Object.
	 * @return The desired Object. Cast this Object to the matching class.
	 */
	public static Object getObject(Object o, String primary){
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Object output = session.get(o.getClass(), primary);
		session.close();
		return output;
	}
	
	/**
	 * Retrieves an Object with a primary key of the type:long from the database.
	 * @param o Any Object from the same class of the desired output Object.
	 * @param primary The primary key of the desired Object.
	 * @return The desired Object. Cast this Object to the matching class.
	 */
	public static Object getObject(Object o, long primary){
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Object output = session.get(o.getClass(), primary);
		session.close();
		return output;
	}
	
	/**
	 * The method is able to delete data from the database via hibernate hql. Make sure that the object is not part of any other object
	 * and that is doesn`t contain any other objects.
	 * @param Object o
	 */
	public static void deleteObject(Object o){		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.delete(o);
		session.beginTransaction().commit();
		session.close();
	}
	
	/**
	 * Retrieves a List with all Object of a class that are currently present in the database.
	 * @param o Any Object from the same class as the desired List.
	 * @return A List of Objects from the same class as o.
	 */
	public static List<Object> getAllInstances(Object o){
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		List<Object> allInstances = session.createCriteria(o.getClass()).list();
		session.close();
		return allInstances;
	}
    
}
