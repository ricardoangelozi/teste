package com.mb.bean.converter;

import java.lang.reflect.Field;  
import java.util.Collection;  
  
import javax.faces.component.UIComponent;  
import javax.faces.context.FacesContext;  
import javax.faces.convert.Converter;  
import javax.faces.convert.ConverterException;  
import javax.faces.convert.FacesConverter; 

@FacesConverter("selectItensMenu")
public class ConveterCampos implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		if (value == null || value.equals(""))
			return null;

		try {
			Long id = Long.valueOf(value);
			Collection items = (Collection) component.getAttributes().get(
					"items");
			return findById(items, id);
		} catch (Exception ex) {
			throw new ConverterException("Não foi possível aplicar conversão de item com valor ["+ value + "] no componente [" + component.getId() + "]", ex);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null)
			return "";

		return getIdByReflection(value).toString();
	}

	private Object findById(Collection collection, Long idToFind) {
		for (Object obj : collection) {
			Long id = getIdByReflection(obj);
			if (id == idToFind)
				return obj;
		}

		return null;
	}

	private Long getIdByReflection(Object bean) {
		try {
			Field idField = bean.getClass().getDeclaredField("id");
			idField.setAccessible(true);
			return (Long) idField.get(bean);
		} catch (Exception ex) {
			throw new RuntimeException("Não foi possível obter a propriedade 'id' do item", ex);
		}
	}

}
