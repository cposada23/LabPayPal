/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.model;

import com.udea.entity.Products;
import java.util.List;
import org.hibernate.HibernateException;



import org.hibernate.Session;
import org.hibernate.Query;


/**
 *
 * @author estudiantelis
 */
public class ProductDao {
    
    public List<Products> getAll(){
        Session session =  null;
        
        List<Products> lista = null;
        
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from pProducts");
            lista = (List<Products> )query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally{
            if(session!=null){
                session.close();
            }
            return lista;
        }
        
        
    }
    
}
