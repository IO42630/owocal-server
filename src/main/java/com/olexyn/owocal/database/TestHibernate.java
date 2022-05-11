package com.olexyn.owocal.database;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class TestHibernate {

    public static void main(String[] args) {




        Session session = HibernateUtil.getSessionFactory().openSession();

        readCustomers(session);



        EventEntity customer = new EventEntity();
        customer.setSummary("Powell");

        session.beginTransaction();
        //Save the Model object
        session.save(customer);

        session.getTransaction().commit();


        readCustomers(session);




        System.out.println("Closing...");
        HibernateUtil.getSessionFactory().close();
    }



    public static void readCustomers(Session session){
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            Query query = session.createQuery("from EventEntity");
            List list = query.list();
            tx.commit();
            int br=0;
        }catch (Throwable t){

        }
        int br=0;
    }

}




