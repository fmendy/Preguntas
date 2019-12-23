package com.alvaro.preguntas.action.pregunta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alvaro.preguntas.action.GeneralAction;

import com.alvaro.preguntas.bean.Pregunta;
import com.alvaro.preguntas.business.dao.PreguntaDAO;
import com.alvaro.preguntas.business.dao.impl.PreguntaDAOImpl;
import com.alvaro.preguntas.session.SessionesGlobales;

public class PreguntaGuardarAction extends PreguntaGeneralAction {

	final static Logger log = LogManager.getLogger(PreguntaGuardarAction.class);

	private PreguntaDAO preguntaDAO = new PreguntaDAOImpl();

	public String execute() throws Exception {
		if (isUserLoged()) {
			this.setUsuario(getUsuarioEnSession());
			pregunta.setUsuario(usuario);
			System.out.println(pregunta.getNombre());
			System.out.println(pregunta.getCategoria().getIdCategoria());
			System.out.println(pregunta.getUsuario().getIdUsuario());
			try {
				if (preguntaDAO.guardarPregunta(pregunta)) {
					return SessionesGlobales.SUCCESS;
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			return SessionesGlobales.FAILED;

		} else {
			// Usuario no logeado
			return SessionesGlobales.NO_LOGEADO;
		}
	}

}
