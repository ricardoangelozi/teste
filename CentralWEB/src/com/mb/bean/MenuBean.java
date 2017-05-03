package com.mb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dao.MenuDAO;
import com.facade.MenuFacede;
import com.model.Menu;
import com.model.User;

@ManagedBean(name = "menuBean")
@SessionScoped
public class MenuBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String labelMenu;
	
	Menu menu = new Menu();
	
	@EJB
	MenuFacede DAOmenu;
	
	@PostConstruct
    public void init() {
       User user = (User)  SessionContext.getInstance().getUsuarioLogado();
       
       labelMenu = "";
       List<Menu> listaMenu = DAOmenu.montarMenu(user);
       labelMenu += MontarMenu(listaMenu, labelMenu);
       labelMenu +=  "";
    }
	
	public String MontarMenu(List<Menu> menu, String label){
		String monta = "";
		for (Menu listaMenu : menu) {
			monta += "<li><a href='" + listaMenu.getLinkPagina() + "'>" + listaMenu.getDsMenu() + " </a></li>";
		}
		return monta;
	}
	
	public String getLabelMenu() {
		return labelMenu;
	}
	
	public void setLabelMenu(String labelMenu) {
		this.labelMenu = labelMenu;
	}

	public Menu getMenu() {
		return menu;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
    public void save() {
       addMessage("Success", "Data saved");
    }
     
    public void update() {
       addMessage("Success", "Data updated");
    }
     
    public void delete() {
       addMessage("Success", "Data deleted");
    }
}