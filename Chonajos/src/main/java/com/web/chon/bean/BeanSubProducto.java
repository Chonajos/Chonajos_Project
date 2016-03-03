package com.web.chon.bean;

import com.web.chon.dominio.Subproducto;
import com.web.chon.dominio.Producto;
import com.web.chon.service.ServiceProducto;
import com.web.chon.service.ServiceSubProducto;
import com.web.chon.util.Utilidades;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author juan Bean para el catlogo de productos
 */
@ViewScoped
public class BeanSubProducto implements Serializable, BeanSimple {

    private static final long serialVersionUID = 1L;

    private ArrayList<Subproducto> model;
    private ArrayList<Subproducto> selectedSubProducto;
    private ArrayList<Producto> lstProducto;

    private ServiceSubProducto serviceSubProducto;
    private ServiceProducto serviceProducto;
    private String title = "";
    public String viewEstate = "";
    public Subproducto data;

    @PostConstruct
    public void init() {

        data = new Subproducto();
        model = new ArrayList<Subproducto>();
        lstProducto = new ArrayList<Producto>();
        selectedSubProducto = new ArrayList<Subproducto>();
        lstProducto = serviceProducto.getProductos();
        model = serviceSubProducto.getSubProductos();

        setTitle("Catalogo de Productos.");
        setViewEstate("init");

    }

    @Override
    public String delete() {

        if (!selectedSubProducto.isEmpty()) {
            for (Subproducto producto : selectedSubProducto) {
                try {
                    serviceSubProducto.deleteSubProducto(producto.getIdSubproductoPk());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro eliminado."));
                } catch (Exception ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocurrio un error al intentar eliminar el registro :" + data.getNombreSubproducto() + "."));
                }
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Elija un registro a eliminar."));
        }
        return "producto";
    }

    @Override
    public String insert() {
        try {
            data.setIdSubproductoPk(data.getIdProductoFk().concat(Utilidades.rellenaEspacios(serviceSubProducto.getLastIdProducto(data.getIdProductoFk()))));
            data.setNombreSubproducto(getDescripcionCategoria(data.getIdProductoFk())+" "+data.getNombreSubproducto());
            serviceSubProducto.insertarSubProducto(data);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro insertado."));
        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocurrio un error al intentar insertar el registro :" + data.getNombreSubproducto() + "."));
        }

        return "producto";
    }

    @Override
    public String update() {

        try {
            serviceSubProducto.updateSubProducto(data);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro modificado."));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocurrio un error al intentar modificar el registro :" + data.getNombreSubproducto() + "."));
        }

        return "producto";
    }

    private String getDescripcionCategoria(String idCategoria) {
        String nombreCategoria = "";

        for (Producto producto : lstProducto) {

            if (producto.getIdProductoPk().trim().equals(idCategoria)) {
                nombreCategoria = producto.getNombreProducto();
                break;
            }
        }

        return nombreCategoria;

    }

    @Override
    public void searchById() {
        setTitle("Editar Productos.");
        setViewEstate("searchById");

    }

    public void viewNew() {
        data = new Subproducto();
        setTitle("Alta de Producto.");
        setViewEstate("new");
    }

    public void backView() {
        setTitle("Catalogo de Producto.");
        setViewEstate("init");
    }

    public ArrayList<Subproducto> getModel() {
        return model;
    }

    public void setModel(ArrayList<Subproducto> model) {
        this.model = model;
    }

    public Subproducto getData() {
        return data;
    }

    public void setData(Subproducto data) {
        this.data = data;
    }

    public ServiceSubProducto getServiceSubProducto() {
        return serviceSubProducto;
    }

    public void setServiceSubProducto(ServiceSubProducto serviceSubProducto) {
        this.serviceSubProducto = serviceSubProducto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViewEstate() {
        return viewEstate;
    }

    public void setViewEstate(String viewEstate) {
        this.viewEstate = viewEstate;
    }

    public ArrayList<Subproducto> getSelectedSubProducto() {
        return selectedSubProducto;
    }

    public void setSelectedSubProducto(ArrayList<Subproducto> selectedSubProducto) {
        this.selectedSubProducto = selectedSubProducto;
    }

    public ArrayList<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(ArrayList<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public ServiceProducto getServiceProducto() {
        return serviceProducto;
    }

    public void setServiceProducto(ServiceProducto serviceProducto) {
        this.serviceProducto = serviceProducto;
    }

}
