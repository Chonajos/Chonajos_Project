/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.chon.service;

import com.web.chon.dominio.Subproducto;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public interface IfaceSubProducto {
    
    public ArrayList<Subproducto> getSubProductos();
    
    public Subproducto getSubProductoById(int idSubProducto);
    
    public int deleteSubProducto(int idSubProducto);
    
    public int updateSubProducto(Subproducto subProducto);
    
    public int insertarSubProducto(Subproducto subProducto);
}
