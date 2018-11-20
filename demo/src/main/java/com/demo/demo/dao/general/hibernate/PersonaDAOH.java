package com.demo.demo.dao.general.hibernate;

import com.demo.demo.dao.general.PersonaDAO;
import com.demo.demo.model.Persona;
import org.springframework.stereotype.Repository;
import pe.albatross.octavia.easydao.AbstractEasyDAO;

@Repository
public class PersonaDAOH extends AbstractEasyDAO<Persona> implements PersonaDAO {

    public PersonaDAOH() {
        super();
        setClazz(Persona.class);
    }

}
