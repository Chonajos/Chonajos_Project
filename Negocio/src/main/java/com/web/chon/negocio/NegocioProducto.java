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
    public int deleteProducto(int idProducto);
    public int insertarProducto(Producto producto);
    public int updateProducto(Producto producto);
    

}
