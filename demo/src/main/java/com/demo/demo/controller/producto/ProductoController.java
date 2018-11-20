package com.demo.demo.controller.producto;

import com.demo.demo.controller.producto.ProductoService;
import com.demo.demo.model.Producto;
import com.demo.demo.zhelper.JsonResponse;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class ProductoController {
     private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductoService service;

    @RequestMapping(method = RequestMethod.GET)
    public String Producto(Model model) {

        List<Producto> productos = service.allProductos();
        model.addAttribute("lista", productos);

        return "producto";
    
}

    @ResponseBody
    @RequestMapping("allProductos")
    public JsonResponse allProductos() {

        JsonResponse response = new JsonResponse();
        List<Producto> productos = service.allProductos();
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        response.setSuccess(false);
        try {
            for (Producto producto : productos) {
                ObjectNode json = new ObjectNode(JsonNodeFactory.instance);
                json.put("id", producto.getId());
                json.put("nombre", producto.getNombre());
                json.put("cantidad", producto.getCantidad());
                json.put("modelo", producto.getModelo());
                json.put("tipo", producto.getTipo());
                json.put("proveedor", producto.getProveedor());
                json.put("color",producto.getColor());
                arrayNode.add(json);
            }
            response.setData(arrayNode);
            response.setSuccess(true);

        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("alerta al mostrar");
        }

        return response;

    }
}

