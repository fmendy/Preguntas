/**
 * 
 */
package com.alvaro.preguntas.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alvaro.preguntas.bean.Usuario;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author alvaro
 *
 */
public class GeneralAction extends ActionSupport {

	protected Usuario usuario;

	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	public void guardarUsuarioEnSession(Usuario usuario) {
		HttpSession session = getSession();
		session.setAttribute("usuario", usuario);
	}

	public Usuario getUsuarioEnSession() {
		return (Usuario) getSession().getAttribute("usuario");
	}

	public boolean isUserLoged() {
		return (getUsuarioEnSession() == null ? false : true);
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
