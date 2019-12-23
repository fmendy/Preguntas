package com.alvaro.preguntas.persistence;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.alvaro.preguntas.bean.Categoria;
import com.alvaro.preguntas.bean.Pregunta;
import com.alvaro.preguntas.bean.Respuesta;
import com.alvaro.preguntas.bean.Usuario;
import com.fasterxml.classmate.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
			Configuration configuration = new Configuration();

			Properties prop = new Properties();

			prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			prop.put(Environment.URL, "jdbc:mysql://localhost:3306/preguntas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			prop.put(Environment.USER, "admin");
			prop.put(Environment.PASS, "admin");
			prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			prop.put(Environment.SHOW_SQL, "true");
			prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			

			configuration.setProperties(prop);

			configuration.addAnnotatedClass(Usuario.class);
			configuration.addAnnotatedClass(Categoria.class);
			configuration.addAnnotatedClass(Pregunta.class);
			configuration.addAnnotatedClass(Respuesta.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				System.err.println(e);
			}

		}
		return sessionFactory;

	}
}
