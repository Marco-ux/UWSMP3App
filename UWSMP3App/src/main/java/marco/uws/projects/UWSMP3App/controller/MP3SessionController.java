package marco.uws.projects.UWSMP3App.controller;

import org.hibernate.Session;

import marco.uws.projects.UWSMP3App.model.Mp3;

public class MP3SessionController {

	MP3Controller basicController = new MP3Controller();
	
	public void createMP3(String title) {
    	basicController.setup();
    	Mp3 mp3 = new Mp3();
    	mp3.setTitle(title);
    	mp3.setAuthor("Joshua Bloch");
    	mp3.setPrice(32.59f);
     
        Session session = basicController.sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(mp3);
     
        session.getTransaction().commit();
        session.close();
        basicController.exit();
    }
	
	public Mp3 read(long id) {
		basicController.setup();
    	Session session = basicController.sessionFactory.openSession();
    	 
        long Id = id;
        Mp3 book = session.get(Mp3.class, Id);
     
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());
     
        session.close();
        basicController.exit();
        return book;
    }
	
	protected void update(Mp3 newmp3) {
		basicController.setup();

        Session session = basicController.sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(newmp3);
        
     
        session.getTransaction().commit();
        
        session.close();
        basicController.exit();
    }
    
    protected void delete(Mp3 newmp3) {
     
    	basicController.setup();
    	
        Session session = basicController.sessionFactory.openSession();
        session.beginTransaction();
     
        session.delete(newmp3);
     
        session.getTransaction().commit();
        session.close();
        basicController.exit();
    }
}
