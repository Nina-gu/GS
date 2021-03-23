package com.example.springboot.dao;

import com.example.springboot.entity.InputString;
import com.example.springboot.entity.Palindrome;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class TestDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveLongest(Palindrome p) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Palindrome getLongestByString(String s) {
        Palindrome p = null;
        try (Session session = sessionFactory.openSession()) {
            p = session.get(Palindrome.class, s);
        }catch (NoResultException e) {
            return null;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
