package com.alvaro.preguntas.action.usuario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alvaro.preguntas.action.GeneralAction;
import com.alvaro.preguntas.bean.Usuario;
import com.alvaro.preguntas.session.SessionesGlobales;

public class UsuarioIrLoginAction extends GeneralAction {

	final static Logger log = LogManager.getLogger(UsuarioIrLoginAction.class);

	@Override
	public String execute() throws Exception {
		if (!isUserLoged()) {
			return SessionesGlobales.SUCCESS;
		} else {
			return SessionesGlobales.LOGEADO;
		}
	}

}
