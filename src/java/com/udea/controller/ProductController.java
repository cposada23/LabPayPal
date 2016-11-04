/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;



import com.udea.entity.Products;
import com.udea.model.ProductDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author estudiantelis
 */
@ManagedBean(name = "productController")

public class ProductController {

    
    private List<Products> list = new ArrayList<Products>();
            
    
   
 

    public ProductController() {
        
        
    }

    /**
     * @return the list
     */
    public List<Products> getList() {
        ProductDao dao = new ProductDao();
        return dao.getAll();
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Products> list) {
        this.list = list;
    }
    
}
