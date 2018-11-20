package com.demo.demo.controller;

import com.demo.demo.model.Persona;
import com.demo.demo.zhelper.JsonResponse;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IndexService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        List<Persona> personas = service.allPersonas();
        model.addAttribute("lista", personas);

        return "index";
    }

    @ResponseBody
    @RequestMapping("allPersonas")
    public JsonResponse allPersonas() {

        JsonResponse response = new JsonResponse();
        List<Persona> personas = service.allPersonas();
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        response.setSuccess(false);
        try {
            for (Persona persona : personas) {
                ObjectNode json = new ObjectNode(JsonNodeFactory.instance);
                json.put("id", persona.getId());
                json.put("paterno", persona.getPaterno());
                json.put("materno", persona.getMaterno());
                json.put("nombres", persona.getNombres());
                json.put("sexo", persona.getSexo());
                arrayNode.add(json);
            }
            response.setData(arrayNode);
            response.setSuccess(true);

        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("Error en el llamado");
        }

        return response;

    }
}
