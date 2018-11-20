/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demo.controller.producto;

import com.demo.demo.dao.general.ProductoDAO;
import com.demo.demo.model.Producto;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(readOnly = true)
public class ProductoServiceImp implements ProductoService{
    
     private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductoDAO productoDAO;
    
    @Override
    public List<Producto> allProductos() {
        return productoDAO.all();
    }
    
}
