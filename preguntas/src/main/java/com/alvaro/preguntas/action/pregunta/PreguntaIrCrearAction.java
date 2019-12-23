package com.alvaro.preguntas.action.pregunta;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alvaro.preguntas.action.GeneralAction;
import com.alvaro.preguntas.action.usuario.UsuarioIrLoginAction;
import com.alvaro.preguntas.bean.Categoria;
import com.alvaro.preguntas.business.dao.CategoriaDAO;
import com.alvaro.preguntas.business.dao.impl.CategoriaDAOImpl;
import com.alvaro.preguntas.session.SessionesGlobales;

public class PreguntaIrCrearAction extends PreguntaGeneralAction {
	
	final static Logger log = LogManager.getLogger(PreguntaIrCrearAction.class);
	
	
	private CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
	
	@Override
	public String execute() throws Exception {
		
		categorias = categoriaDAO.getAllCategorias();
		for (Categoria cat: categorias) {
			System.out.println(cat.getNombre());
		}
		
		return SessionesGlobales.SUCCESS;
		/*if (!isUserLoged()) {
			return SessionesGlobales.SUCCESS;
		} else {
			return SessionesGlobales.LOGEADO;
		}*/
	}

	
	

}
