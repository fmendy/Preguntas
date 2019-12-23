package com.alvaro.preguntas.business.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alvaro.preguntas.bean.Categoria;
import com.alvaro.preguntas.business.dao.CategoriaDAO;
import com.alvaro.preguntas.persistence.HibernateUtil;

public class CategoriaDAOImpl implements CategoriaDAO{
	
	final static Logger log = LogManager.getLogger(CategoriaDAOImpl.class);

	public List<Categoria> getAllCategorias() {
		log.info("Inicio carga de Categorias disponibles");
		List<Categoria> result = new ArrayList<Categoria>();
		Transaction transaction = null;
		String hql = "from Categoria c where c.activo=1 order by c.nombre";
		System.out.println("ee");
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();

			Query query = session.createQuery(hql);
			result = query.list();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			log.error("Error al cargar las Categorias disponibles");
		} finally {
			session.close();
		}

		return result;
	}

}
