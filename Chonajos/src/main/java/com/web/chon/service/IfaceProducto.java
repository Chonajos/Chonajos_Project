/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.chon.service;

import com.web.chon.dominio.Producto;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public interface IfaceProducto {
    
    public ArrayList<Producto> getProductos();
    
    public Producto getProductoById(int idProducto);
    
    public int deleteProducto(int idProducto);
    
    public int updateProducto(Producto producto);
    
    public int insertarProducto(Producto producto);
}
