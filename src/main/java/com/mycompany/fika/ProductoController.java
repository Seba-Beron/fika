/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fika;

import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

/**
 *
 * @author Sebastian
 */
public class ProductoController {
    
    public static Route inicioCordova = (Request req, Response res) -> {
        ProductoDAO pDAO = new ProductoDAO();
        List<Producto> productos = pDAO.buscarProductos();
        
        HashMap model = new HashMap();
        model.put("productos", productos);
        model.put("cantidad", "0"); // la cantidad empieza siendo 0 para todos los productos
        
        //model.put("template", "templates/index.vsl"); 
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templatesCordova/index.vsl")); 
    };
    
    public static Route inicio = (Request req, Response res) -> {
        ProductoDAO pDAO = new ProductoDAO();
        List<Producto> productos = pDAO.buscarProductos();

        String email = req.session().attribute("email");
        Boolean admin = req.session().attribute("admin");
        
        HashMap model = new HashMap();
        model.put("email", email);
        model.put("admin", admin);

        model.put("productos", productos);
        model.put("cantidad", "1"); // la cantidad empieza siendo 1 para todos los productos
        model.put("template", "templates/index.vsl"); 
        
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl")); 
    };
    
    public static Route product = (Request req, Response res) -> {
        ProductoDAO pDAO = new ProductoDAO();
        List<Producto> productos = pDAO.buscarProductos();
        
        HashMap model = new HashMap();
        model.put("productos", productos);
        model.put("cantidad", "0"); // la cantidad empieza siendo 0 para todos los productos
        model.put("template", "templates/product.vsl"); 
        
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vsl")); 
    };
}
