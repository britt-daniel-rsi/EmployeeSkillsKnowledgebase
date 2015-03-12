package com.rsi.esk.service;

import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;


public abstract class SerializationHandler implements Serializable {
    private static final long serialVersionUID = 1L;

    @PostConstruct
    private void init() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                                                      .getExternalContext();
        ServletContext servletContext = (ServletContext) externalContext.getContext();
        WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext)
                                  .getAutowireCapableBeanFactory()
                                  .autowireBean(this);
    }

    private void readObject(ObjectInputStream ois)
        throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        init();
    }
}
