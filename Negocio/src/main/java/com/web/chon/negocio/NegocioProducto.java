package com.web.chon.negocio;

import com.web.chon.dominio.Producto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author marcogante
 */
@Remote
public interface NegocioProducto {
    
   public List<Object[]> getProductos();
    
    public Object[] getProductoById(int idProducto);
    
    public int deleteProducto(int idProducto);
    
    public int updateProducto(Producto producto);
    
    public int insertarProducto(Producto producto);
}
