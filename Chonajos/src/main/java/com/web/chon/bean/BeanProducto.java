package com.web.chon.bean;

import com.web.chon.dominio.Producto;
import com.web.chon.service.ServiceProducto;
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
public class BeanProducto implements Serializable, BeanSimple {

    private static final long serialVersionUID = 1L;

    private ArrayList<Producto> model;
    private ArrayList<Producto> selectedProducto;

    private ServiceProducto serviceProducto;
    private String title = "";
    public String viewEstate = "";
    public Producto data;

    @PostConstruct
    public void init() {

        data = new Producto();
        model = new ArrayList<Producto>();
        selectedProducto = new ArrayList<Producto>();
        model = serviceProducto.getProductos();

        setTitle("Catalogo de Productos.");
        setViewEstate("init");

    }

    @Override
    public String delete() {

        if (!selectedProducto.isEmpty()) {
            for (Producto producto : selectedProducto) {
                try {
                    serviceProducto.deleteProducto(producto.getIdProductoPk().intValue());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro eliminado."));
                } catch (Exception ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocurrio un error al intentar eliminar el registro :" + data.getNombreProducto() + "."));
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
            serviceProducto.insertarProducto(data);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro insertado."));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocurrio un error al intentar insertar el registro :" + data.getNombreProducto() + "."));
        }
        backView();
        return "producto";
    }

    @Override
    public String update() {

        try {
            serviceProducto.updateProducto(data);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro modificado."));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocurrio un error al intentar modificar el registro :" + data.getNombreProducto() + "."));
        }

        return "producto";
    }

    @Override
    public void searchById() {
        setTitle("Editar Producto.");
        setViewEstate("searchById");

        System.out.println("data" + data.getDescripcionProducto());

    }

    public void viewNew() {
        data = new Producto();
        setTitle("Alta de Productos.");
        setViewEstate("new");
    }

    public void backView() {
        setTitle("Catalogo de Productos.");
        setViewEstate("init");
    }

    public ArrayList<Producto> getModel() {
        return model;
    }

    public void setModel(ArrayList<Producto> model) {
        this.model = model;
    }

    public Producto getData() {
        return data;
    }

    public void setData(Producto data) {
        this.data = data;
    }

    public ServiceProducto getServiceProducto() {
        return serviceProducto;
    }

    public void setServiceProducto(ServiceProducto serviceProducto) {
        this.serviceProducto = serviceProducto;
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

    public ArrayList<Producto> getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(ArrayList<Producto> selectedProducto) {
        this.selectedProducto = selectedProducto;
    }
}
