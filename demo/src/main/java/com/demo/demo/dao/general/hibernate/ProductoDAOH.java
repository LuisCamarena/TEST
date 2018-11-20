package com.demo.demo.dao.general.hibernate;

import com.demo.demo.dao.general.ProductoDAO;
import com.demo.demo.model.Producto;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.easydao.AbstractEasyDAO;


public class ProductoDAOH extends AbstractEasyDAO<Producto> implements ProductoDAO{
    
    public ProductoDAOH() {
        super();
        setClazz(Producto.class);
    }

    
}
