/**
 * 
 */
package com.alvaro.preguntas.business.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alvaro.preguntas.bean.Usuario;
import com.alvaro.preguntas.persistence.HibernateUtil;

/**
 * @author alvaro
 *
 */
public interface UsuarioDAO {

	public boolean guardarUsuario(Usuario usuario);
	
	public Usuario iniciarSesion(Usuario usuario);
	
	public boolean isApodoValidForRegistration(String apodo);
	
	public boolean isEmailValidForRegistration(String email);
	

}
