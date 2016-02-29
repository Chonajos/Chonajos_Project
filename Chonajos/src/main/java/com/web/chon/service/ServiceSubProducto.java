/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.chon.service;

import com.web.chon.dominio.Subproducto;
import com.web.chon.negocio.NegocioSubProducto;
import com.web.chon.util.Utilidades;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcogante
 */
public class ServiceSubProducto implements IfaceSubProducto {

    NegocioSubProducto ejb;

    @Override
    public ArrayList<Subproducto> getSubProductos() {
        try {
            ArrayList<Subproducto> lstSubProducto = new ArrayList<Subproducto>();
            ejb = (NegocioSubProducto) Utilidades.getEJBRemote("ejbSubProducto", NegocioSubProducto.class.getName());

            List<Object[]> lstObject = ejb.getSubProductos();

            for (Object[] obj : lstObject) {

                Subproducto subProducto = new Subproducto();
                subProducto.setIdSubproductoPk(obj[0] == null ? null:new BigDecimal(obj[0].toString()));
                subProducto.setNombreSubproducto(obj[1] == null ? "":obj[1].toString());
                subProducto.setDescripcionSubproducto(obj[2] == null ? "":obj[2].toString());
                subProducto.setUrlImagenSubproducto(obj[3] == null ? "":obj[3].toString());
                subProducto.setIdProductoFk( obj[4]== null ? null:new BigDecimal(obj[4].toString()));
                subProducto.setPrecioMinimo(obj[5]== null ? null:new BigInteger(obj[5].toString()));
                subProducto.setPrecioMaximo(obj[6]== null ? null:new BigInteger(obj[6].toString()));
                subProducto.setPrecioVenta(obj[7]== null ? null:new BigInteger(obj[7].toString()));

                lstSubProducto.add(subProducto);
            }

            return lstSubProducto;
        } catch (Exception ex) {
            Logger.getLogger(ServiceSubProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Subproducto getSubProductoById(int idSubProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteSubProducto(int idSubProducto) {
       
       return ejb.deleteSubProducto(idSubProducto);
    }

    @Override
    public int updateSubProducto(Subproducto subProducto) {
      
        return ejb.updateSubProducto(subProducto);
    }
    
     @Override
    public int insertarSubProducto(Subproducto subProducto) {
         
      return ejb.insertarSubProducto(subProducto);
 
    }


}
