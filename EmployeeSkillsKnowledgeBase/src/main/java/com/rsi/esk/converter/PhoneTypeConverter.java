package com.rsi.esk.converter;

import com.rsi.esk.domain.PhoneType;
import com.rsi.esk.service.PhoneTypeService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


public class PhoneTypeConverter implements Converter {
    private PhoneTypeService phoneTypeService;

    public void setPhoneTypeService(PhoneTypeService phoneTypeService) {
        this.phoneTypeService = phoneTypeService;
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component,
        String value) {
        return phoneTypeService.getPhoneTypeByDescription(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component,
        Object value) {
        return ((PhoneType) value).getDescription();
    }
}
