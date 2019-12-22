package com.alvaro.preguntas.action.usuario;

import java.util.List;

import com.alvaro.preguntas.action.GeneralAction;
import com.alvaro.preguntas.bean.Usuario;
import com.alvaro.preguntas.session.SessionesGlobales;

public class UsuarioIrRegistroAction extends GeneralAction{
	
	public String execute() throws Exception {
		if (!isUserLoged()) {
			return SessionesGlobales.SUCCESS;
		}
		else {
			this.setUsuario(getUsuarioEnSession());
			return SessionesGlobales.FAILED;
		}
	}
}
