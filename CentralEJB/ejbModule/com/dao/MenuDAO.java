package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.Menu;
import com.model.User;


@Stateless
public class MenuDAO extends GenericDAO<Menu> {
	
	public MenuDAO() {
		super(Menu.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Menu> montarMenu(User user){
		List<Menu> listaMenu = null;
		try {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("id", user.getTpUsuario().getId());
			
			listaMenu = ((List<Menu>) findAllResults(Menu.MONTAR_MENU, parametros));
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
		}
		
		return listaMenu;
	}

	
	
}
