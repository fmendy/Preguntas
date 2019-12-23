package com.alvaro.preguntas.business.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alvaro.preguntas.bean.Pregunta;
import com.alvaro.preguntas.business.dao.PreguntaDAO;
import com.alvaro.preguntas.persistence.HibernateUtil;

public class PreguntaDAOImpl implements PreguntaDAO {

	final static Logger log = LogManager.getLogger(PreguntaDAOImpl.class);

	public boolean guardarPregunta(Pregunta pregunta) {
		log.info("Inicio guardado Pregunta");
		boolean result = false;
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			// Empieza Transaction
			transaction = session.beginTransaction();
			session.persist(pregunta);

			transaction.commit();
			result = true;
			log.info("Pregunta Guardada correctamente");

		} catch (Exception e) {
			System.err.println(e);
			log.error(e);
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
