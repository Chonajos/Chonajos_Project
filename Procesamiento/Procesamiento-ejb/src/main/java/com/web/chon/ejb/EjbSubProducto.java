/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.chon.ejb;

import com.web.chon.dominio.Subproducto;
import com.web.chon.negocio.NegocioSubProducto;
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
@Stateless(mappedName = "ejbSubProducto")
public class EjbSubProducto implements NegocioSubProducto {

    @PersistenceContext(unitName = "persistenceJR")
    EntityManager em;

    @Override
    public List<Object[]> getSubProductos() {
        try {

            Query query = em.createNativeQuery("Select * from SUBPRODUCTO");
            List<Object[]> resultList = null;
            resultList = query.getResultList();

            return resultList;

        } catch (Exception ex) {
            Logger.getLogger(EjbSubProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public int deleteSubProducto(int idSubProducto) {
        System.out.println("deleteProducto");
        try {

            System.out.println("id prodcuto a eliminar :" + idSubProducto);
            Query query = em.createNativeQuery("delete SUBPRODUCTO where ID_SUBPRODUCTO_PK = ?");
            query.setParameter(1, idSubProducto);

            return query.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(EjbSubProducto.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    @Override
    public int insertarSubProducto(Subproducto subProducto) {
        System.out.println("insertarProducto");
        try {
            System.out.println("insert : " + subProducto.toString());
            Query query = em.createNativeQuery("insert into SUBPRODUCTO (ID_SUBPRODUCTO_PK,NOMBRE_SUBPRODUCTO,DESCRIPCION_SUBPRODUCTO,ID_PRODUCTO_FK,PRECIO_MINIMO,PRECIO_MAXIMO,PRECIO_VENTA) values(s_subproducto.NextVal,?,?,?,?,?,?)");
            query.setParameter(1, subProducto.getNombreSubproducto());
            query.setParameter(2, subProducto.getDescripcionSubproducto());
            query.setParameter(3, subProducto.getIdProductoFk());
            query.setParameter(4, subProducto.getPrecioMinimo());
            query.setParameter(5, subProducto.getPrecioMaximo());
            query.setParameter(6, subProducto.getPrecioVenta());

            return query.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(EjbSubProducto.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    @Override
    public int updateSubProducto(Subproducto subProducto) {
        try {

            System.out.println("producto a modificar :" + subProducto.toString());
            Query query = em.createNativeQuery("update SUBPRODUCTO set NOMBRE_SUBPRODUCTO = ?,DESCRIPCION_SUBPRODUCTO =?,ID_PRODUCTO_FK = ?,PRECIO_MINIMO =?,PRECIO_MAXIMO =?,PRECIO_VENTA =?  where ID_SUBPRODUCTO_PK = ?");
            query.setParameter(1, subProducto.getNombreSubproducto());
            query.setParameter(2, subProducto.getDescripcionSubproducto());
            query.setParameter(3, subProducto.getIdProductoFk());
            query.setParameter(4, subProducto.getPrecioMinimo());
            query.setParameter(5, subProducto.getPrecioMaximo());
            query.setParameter(6, subProducto.getPrecioVenta());
            query.setParameter(7, subProducto.getIdSubproductoPk());

            return query.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(EjbSubProducto.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

}
