/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.activa.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author richa
 */
public class UserManager {

        private EntityManagerFactory emf= Persistence.createEntityManagerFactory("JSFLoginDemoPU");
        private EntityManager em = emf.createEntityManager();
        private Query query;
        
        public List<User> findUserByName(String name){
            query = em.createNamedQuery("User.findByName");
            query.setParameter("name", name);
            return query.getResultList();
        }
}
