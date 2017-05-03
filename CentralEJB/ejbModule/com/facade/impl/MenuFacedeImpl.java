package com.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MenuDAO;
import com.facade.MenuFacede;
import com.model.Menu;
import com.model.User;

@Stateless
public class MenuFacedeImpl implements MenuFacede {
	
	@EJB
	MenuDAO daoMenu;
	
	@SuppressWarnings("unchecked")
	public List<Menu> montarMenu(User user){
		List<Menu> listaMenu = null;
		try {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("id", user.getTpUsuario().getId());
			listaMenu = ((List<Menu>) daoMenu.findAllResults(Menu.MONTAR_MENU, parametros));
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
		}
		
		return listaMenu;
	}

	
	
}
