package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Menu;
import com.model.User;


@Local
public interface MenuFacede {
	public abstract List<Menu> montarMenu(User user);

}
