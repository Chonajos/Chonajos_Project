package com.web.chon.bean;

import com.web.chon.dominio.TipoEmpaque;
import com.web.chon.service.ServiceEmpaque;
import com.web.chon.util.Utilidades;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Bean para el catlogo de Empaques
 * @author Juan de la Cruz 
 */
@ViewScoped
public class BeanEmpaque implements Serializable, BeanSimple {

    private static final long serialVersionUID = 1L;

    private ArrayList<TipoEmpaque> model;
    private ArrayList<TipoEmpaque> selectedEmpaque;

    private ServiceEmpaque serviceEmpaque;
    private String title = "";
    public String viewEstate = "";
    public TipoEmpaque data;

    @PostConstruct
    public void init() {

        data = new TipoEmpaque();
        model = new ArrayList<TipoEmpaque>();
        selectedEmpaque = new ArrayList<TipoEmpaque>();
        model = serviceEmpaque.getEmpaques();

        setTitle("Catalogo de Tipo Empaques.");
        setViewEstate("init");

    }

    @Override
    public String delete() {

        if (!selectedEmpaque.isEmpty()) {
            for (TipoEmpaque tipoEmpaque : selectedEmpaque) {
                try {
                    serviceEmpaque.deleteEmpaque(tipoEmpaque.getIdTipoEmpaquePk().intValue());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro eliminado."));
                } catch (Exception ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocurrio un error al intentar eliminar el registro :" + data.getNombreEmpaque() + "."));
                }
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Elija un registro a eliminar."));
        }

        return "empaque";
    }

    @Override
    public String insert() {
        try {
            serviceEmpaque.insertarEmpaque(data);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro insertado."));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocurrio un error al intentar insertar el registro :" + data.getNombreEmpaque()+ "."));
        }
        backView();
        return "empaque";
    }

    @Override
    public String update() {

        try {
            serviceEmpaque.updateEmpaque(data);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro modificado."));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocurrio un error al intentar modificar el registro :" + data.getNombreEmpaque()+ "."));
        }

        return "empaque";
    }

    @Override
    public void searchById() {
        setTitle("Editar Tipo Empaque.");
        setViewEstate("searchById");

    }

    public void viewNew() {
        data = new TipoEmpaque();
        setTitle("Alta de Tipo Empaque.");
        setViewEstate("new");
    }

    public void backView() {
        setTitle("Catalogo de Tipo de Empaque.");
        setViewEstate("init");
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

    public ArrayList<TipoEmpaque> getModel() {
        return model;
    }

    public void setModel(ArrayList<TipoEmpaque> model) {
        this.model = model;
    }

    public ArrayList<TipoEmpaque> getSelectedEmpaque() {
        return selectedEmpaque;
    }

    public void setSelectedEmpaque(ArrayList<TipoEmpaque> selectedEmpaque) {
        this.selectedEmpaque = selectedEmpaque;
    }

    public ServiceEmpaque getServiceEmpaque() {
        return serviceEmpaque;
    }

    public void setServiceEmpaque(ServiceEmpaque serviceEmpaque) {
        this.serviceEmpaque = serviceEmpaque;
    }

    public TipoEmpaque getData() {
        return data;
    }

    public void setData(TipoEmpaque data) {
        this.data = data;
    }

 
}
