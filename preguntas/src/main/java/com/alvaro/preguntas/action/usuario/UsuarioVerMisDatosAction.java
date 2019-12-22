package com.alvaro.preguntas.action.usuario;

import com.alvaro.preguntas.action.GeneralAction;
import com.alvaro.preguntas.session.SessionesGlobales;

public class UsuarioVerMisDatosAction extends GeneralAction{

	@Override
	public String execute() throws Exception {
		if (isUserLoged()) {
			this.usuario = getUsuarioEnSession();
			System.out.println(getUsuarioEnSession().getEmail());
			return SessionesGlobales.SUCCESS;
		}
		else {
			return SessionesGlobales.FAILED;
		}
	}

	
}
