package com.benilde.templates;

import javax.faces.bean.*;

@ManagedBean(name="templateController")
@SessionScoped
public class TemplateController {

	private String title = "";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String admins(){
		this.title = "JCH | Admins";
		return	"admin_acc?faces-redirect=true";
	}
	
	public String adminIndex(){
		this.title = "JCH | Admin";
		return	"index.xhtml?faces-redirect=true";
	}
	
	public String bootcamps(){
		this.title = "JCH | Bootcamps";
		return "allbootcamps?faces-redirect=true";
	}
	
	public String joinerProfile(){
		this.title = "JCH | Profile";
		return "joiner_profile?face-redirect=true";
	}
	
	public String joinerBootcamps(){
		this.title = "JCH | My Bootcamps";
		return "joiner_myBootcamps?face-redirect=true";
	}
	
	public String schoolAcc(){
		this.title = "JCH | School Profile";
		return "school_profile?face-redirect=true";
	}
	
	public String schoolBootcamps(){
		this.title = "JCH | My Bootcamps";
		return "schoolindex.xhtml?faces-redirect=true";
	}
	
	public String signOut(){
		this.title = "JCH | My Account";
		return "../index.xhtml?faces-redirect=true";
	}
}
