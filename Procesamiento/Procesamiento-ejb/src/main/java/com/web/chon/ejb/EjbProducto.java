/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.chon.ejb;

import com.web.chon.dominio.Producto;
import com.web.chon.negocio.NegocioProducto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author juan
 */
@Stateless(mappedName = "ejbProducto")
public class EjbProducto implements NegocioProducto {

    @PersistenceContext(unitName = "persistenceJR")
    EntityManager em;

    @Override
    public Object[] getProductoById(int idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteProducto(int idProducto) {
        try {

            Query query = em.createNativeQuery("delete Producto where ID_PRODUCTO_PK :idProducto");
            query.setParameter("idProducto", idProducto);
            int i = query.executeUpdate();

            return i;

        } catch (Exception ex) {
            Logger.getLogger(EjbProducto.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int updateProducto(Producto producto) {

        try {

            Query query = em.createNativeQuery("update Producto set NOMBRE_PRODUCTO:nombre,DESCRIPCION_PRODUCTO:descripcion  where ID_PRODUCTO_PK :idProducto");
            query.setParameter("nombre", producto.getNombreProducto());
            query.setParameter("descripcion", producto.getDescripcionProducto());
            query.setParameter("idProducto", producto.getIdProductoPk().intValue());
            int i = query.executeUpdate();

            return i;

        } catch (Exception ex) {
            Logger.getLogger(EjbProducto.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    @Override
    public List<Object[]> getProductos() {
        try {

            Query query = em.createNativeQuery("Select * from Producto");
            List<Object[]> resultList = null;
            resultList = query.getResultList();

            return resultList;

        } catch (Exception ex) {
            Logger.getLogger(EjbProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public int insertarProducto(Producto producto) {

        try {

            Query query = em.createNativeQuery("insert into PRODUCTO (ID_PRODUCTO_PK,NOMBRE_PRODUCTO,DESCRIPCION_PRODUCTO) values(S_PRODUCTO.NextVal,:producto,:descripcion);");
            query.setParameter("producto", producto.getNombreProducto());
            query.setParameter("descripcion", producto.getDescripcionProducto());
      
            int i = query.executeUpdate();

            return i;

        } catch (Exception ex) {
            Logger.getLogger(EjbProducto.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }
}
