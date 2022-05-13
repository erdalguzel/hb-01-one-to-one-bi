package com.erdal.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.erdal.entity.Instructor;
import com.erdal.entity.InstructorDetail;

public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            Instructor instructor = new Instructor("Erdal", "Guzel", "guzel@luv2code.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.luv2code.com/youtube", "fitness");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            // This will also save InstructorDetail object because of CascadeType.ALL
            session.persist(instructor);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}