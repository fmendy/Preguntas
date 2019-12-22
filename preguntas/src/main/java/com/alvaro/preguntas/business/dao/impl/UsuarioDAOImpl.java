/**
 * 
 */
package com.alvaro.preguntas.business.dao.impl;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.preguntas.bean.Usuario;
import com.alvaro.preguntas.business.dao.UsuarioDAO;
import com.alvaro.preguntas.persistence.HibernateUtil;

/**
 * @author alvaro
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {

	public boolean guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();
			session.save(usuario);

			transaction.commit();
			result = true;

		} catch (Exception e) {
			System.err.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			result = false;
		} finally {
			session.close();
		}
		return result;

	}

	public Usuario iniciarSesion(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario user = null;
		Transaction transaction = null;
		String hql = "from Usuario u where u.email=:usuarioEmail and u.password=:usuarioPassword";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("usuarioEmail", usuario.getEmail());
			query.setParameter("usuarioPassword", usuario.getPassword());
			user = (Usuario) query.list().get(0);
			System.out.println(user.getIdUsuario());

			transaction.commit();

		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			user = null;
		} finally {
			session.close();
		}
		return user;
	}

	public boolean isApodoValidForRegistration(String apodo) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction transaction = null;
		String hql = "from Usuario u where u.apodo=:usuarioApodo";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("usuarioApodo", apodo);
			if(query.list().size()==0) {
				result = true;
			}

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			result = false;
		} finally {
			session.close();
		}

		return result;
	}

	public boolean isEmailValidForRegistration(String email) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction transaction = null;
		String hql = "from Usuario u where u.email=:usuarioEmail";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			query.setParameter("usuarioEmail", email);
			if(query.list().size()==0) {
				result = true;
			}
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			result = false;
		} finally {
			session.close();
		}

		return result;
	}

}
