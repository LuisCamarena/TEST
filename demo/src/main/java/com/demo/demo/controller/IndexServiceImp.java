package com.demo.demo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.demo.dao.general.PersonaDAO;
import com.demo.demo.model.Persona;

@Service
@Transactional(readOnly = true)
public class IndexServiceImp implements IndexService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonaDAO personaDAO;

//    @Override
//    @Transactional
//    public Personaje findCharacter() {
//        Persona2 ps = persona2DAO.find(199L);
//        logger.debug("PERSONA2 {}", ps);
//        logger.debug("PERSONA2 {}", ps.getMaterno());
//        logger.debug("PERSONA2 {}", ps.getNombres());
//
//        Personaje personaje = characterDAO.find(4L);
//        personaje.setcLevel(140);
//        characterDAO.update(personaje);
//        return personaje;
//    }
    @Override
    public List<Persona> allPersonas() {
        return personaDAO.all();
    }

}
