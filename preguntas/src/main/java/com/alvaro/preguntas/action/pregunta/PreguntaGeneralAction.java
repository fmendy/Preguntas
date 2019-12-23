package com.alvaro.preguntas.action.pregunta;

import java.util.ArrayList;
import java.util.List;

import com.alvaro.preguntas.action.GeneralAction;
import com.alvaro.preguntas.bean.Categoria;
import com.alvaro.preguntas.bean.Pregunta;

public class PreguntaGeneralAction extends GeneralAction{

	protected Pregunta pregunta;
	protected List<Categoria> categorias = new ArrayList<Categoria>();

	/**
	 * @return the pregunta
	 */
	public Pregunta getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * @return the categorias
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	
	
	
	
}
