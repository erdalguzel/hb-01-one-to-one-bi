package com.erdal.demo;

import com.erdal.entity.Instructor;
import com.erdal.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            int id = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("instructorDetail: " + instructorDetail);
            System.out.println("instructor: " + instructorDetail.getInstructor());

            // This will remove corresponding record from both tables because of CascadeType.ALL
            session.remove(instructorDetail);

            session.getTransaction().commit();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}