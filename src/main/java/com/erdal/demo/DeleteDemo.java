package com.erdal.demo;

import com.erdal.entity.Instructor;
import com.erdal.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            // This will also save InstructorDetail object because of CascadeType.ALL
            Instructor instructor = session.get(Instructor.class, 3);
            if (instructor != null) {
                System.out.println("About to delete instructor: " + instructor);
                session.remove(instructor);
                System.out.println("Instructor removed");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}