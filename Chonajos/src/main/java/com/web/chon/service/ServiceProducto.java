/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.chon.service;

import com.web.chon.dominio.Producto;
import com.web.chon.negocio.NegocioProducto;
import com.web.chon.util.Utilidades;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcogante
 */
public class ServiceProducto implements IfaceProducto {

    NegocioProducto ejb;

    @Override
    public ArrayList<Producto> getProductos() {
        try {
            ArrayList<Producto> lstProducto = new ArrayList<Producto>();
            ejb = (NegocioProducto) Utilidades.getEJBRemote("ejbProducto", NegocioProducto.class.getName());

            List<Object[]> lstObject = ejb.getProductos();

            for (Object[] obj : lstObject) {

                Producto producto = new Producto();
                producto.setIdProductoPk(new BigDecimal(obj[0].toString()));
                producto.setNombreProducto(obj[1].toString());
                producto.setDescripcionProducto(obj[2].toString());

                lstProducto.add(producto);
            }

            return lstProducto;
        } catch (Exception ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

//    private Producto contructProductoEntityToProductoDominio(Producto producto){
//        
//        ProductoD producto = new ProductoD();
//        producto.setIdProductoPk(entity.getIdProductoPk());
//        producto.setNombreProducto(entity.getNombreProducto());
//        producto.setDescripcionProducto(entity.getDescripcionProducto());
//        
//        return producto;
//    }
    @Override
    public Producto getProductoById(int idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteProducto(int idProducto) {
        System.out.println("service");
       return ejb.deleteProducto(idProducto);
    }

    @Override
    public int updateProducto(Producto producto) {
        System.out.println("service");
        return ejb.updateProducto(producto);
    }

    @Override
    public int insertarProducto(Producto producto) {
        System.out.println("service");
        return ejb.insertarProducto(producto);
    }

}
