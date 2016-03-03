package com.web.chon.bean;

import com.web.chon.dominio.Subproducto;
import com.web.chon.service.ServiceSubProducto;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Bean para el Mantenimiento a Precios
 *
 * @author Juan de la Cruz
 */
@ViewScoped
public class BeanMantenimientoPrecio implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Subproducto> model;
    private ArrayList<Subproducto> lstSubProducto;

    private ServiceSubProducto serviceSubProducto;
    private String title = "";
    public String viewEstate = "";
    private String idProductoSelecionado = "";
    public Subproducto data;

    @PostConstruct
    public void init() {

        data = new Subproducto();
        lstSubProducto = new ArrayList<Subproducto>();
        lstSubProducto = serviceSubProducto.getSubProductos();

        setTitle("Mantenimiento de Precios.");
        setViewEstate("init");

    }

    public String updatePrecio() {

        if (serviceSubProducto.updateSubProducto(data) == 1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro modificado."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Registro modificado."));
        }
        return "mantenimientoPrecios";
    }

    public void searchById() {
        data = serviceSubProducto.getSubProductoById(data.getIdSubproductoPk());

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

    public ArrayList<Subproducto> getModel() {
        return model;
    }

    public void setModel(ArrayList<Subproducto> model) {
        this.model = model;
    }

    public ArrayList<Subproducto> getLstSubProducto() {
        return lstSubProducto;
    }

    public void setLstSubProducto(ArrayList<Subproducto> lstSubProducto) {
        this.lstSubProducto = lstSubProducto;
    }

    public ServiceSubProducto getServiceSubProducto() {
        return serviceSubProducto;
    }

    public void setServiceSubProducto(ServiceSubProducto serviceSubProducto) {
        this.serviceSubProducto = serviceSubProducto;
    }

    public Subproducto getData() {
        return data;
    }

    public void setData(Subproducto data) {
        this.data = data;
    }

    public String getIdProductoSelecionado() {
        return idProductoSelecionado;
    }

    public void setIdProductoSelecionado(String idProductoSelecionado) {
        this.idProductoSelecionado = idProductoSelecionado;
    }

}
