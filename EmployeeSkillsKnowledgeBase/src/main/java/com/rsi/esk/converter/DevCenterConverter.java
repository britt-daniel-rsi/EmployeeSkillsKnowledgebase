package com.rsi.esk.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.rsi.esk.domain.DevCenter;

@FacesConverter("devCenterConverter")
public class DevCenterConverter implements Converter {

	List<DevCenter> centers;
	public DevCenterConverter(List<DevCenter> centers) {
		this.centers = centers;
	}
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
		for(DevCenter center : centers) {
			if(center.getName() != null && center.getName().equals(value)){
				return center;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object center) {
		return center != null ? ((DevCenter) center).getName() : null;
	}

}
