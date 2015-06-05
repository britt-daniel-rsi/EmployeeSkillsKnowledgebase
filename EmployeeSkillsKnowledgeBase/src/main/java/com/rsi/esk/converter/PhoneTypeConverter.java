package com.rsi.esk.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.rsi.esk.domain.PhoneType;
import com.rsi.esk.service.PhoneTypeService;

@FacesConverter("phoneTypeConverter")
public class PhoneTypeConverter implements Converter {
	
	private PhoneTypeService service;
	
	public PhoneTypeConverter(PhoneTypeService service) {
		this.service = service;
	}

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
        String value) {
    	
    	PhoneType type = service.getPhoneTypeByDescription(value);
        return type;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component,
        Object value) {
        return ((PhoneType) value).getDescription();
    }
}
