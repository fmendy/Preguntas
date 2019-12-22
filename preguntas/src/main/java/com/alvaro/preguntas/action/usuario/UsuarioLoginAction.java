package com.alvaro.preguntas.action.usuario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alvaro.preguntas.action.GeneralAction;
import com.alvaro.preguntas.bean.Usuario;
import com.alvaro.preguntas.business.dao.UsuarioDAO;
import com.alvaro.preguntas.business.dao.impl.UsuarioDAOImpl;
import com.alvaro.preguntas.session.SessionesGlobales;
import com.opensymphony.xwork2.ActionSupport;

public class UsuarioLoginAction extends GeneralAction {
	private UsuarioDAO usuarioDao = new UsuarioDAOImpl();
	final static Logger log = LogManager.getLogger(UsuarioLoginAction.class);

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("logeando");
		if (isUserLoged()) {
			this.setUsuario(getUsuarioEnSession());
			return SessionesGlobales.SUCCESS;
		}
		if (this.getUsuario() != null) {
			Usuario userAux = usuarioDao.iniciarSesion(this.getUsuario());
			if (userAux != null) {
				guardarUsuarioEnSession(userAux);
				this.setUsuario(userAux);
				return SessionesGlobales.SUCCESS;
			}
		}
		return SessionesGlobales.FAILED;

	}

}
