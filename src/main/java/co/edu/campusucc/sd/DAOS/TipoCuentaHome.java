package co.edu.campusucc.sd.DAOS;
// Generated 23/05/2020 02:30:35 PM by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import co.edu.campusucc.sd.modelo.TipoCuenta;

/**
 * Home object for domain model class TipoCuenta.
 * @see co.edu.campusucc.sd.modelo.TipoCuenta
 * @author Hibernate Tools
 */
public class TipoCuentaHome {

	private static final Logger logger = Logger.getLogger(TipoCuentaHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TipoCuenta transientInstance) {
		logger.log(Level.INFO, "persisting TipoCuenta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TipoCuenta instance) {
		logger.log(Level.INFO, "attaching dirty TipoCuenta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipoCuenta instance) {
		logger.log(Level.INFO, "attaching clean TipoCuenta instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(TipoCuenta persistentInstance) {
		logger.log(Level.INFO, "deleting TipoCuenta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public TipoCuenta merge(TipoCuenta detachedInstance) {
		logger.log(Level.INFO, "merging TipoCuenta instance");
		try {
			TipoCuenta result = (TipoCuenta) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public TipoCuenta findById(java.lang.String id) {
		logger.log(Level.INFO, "getting TipoCuenta instance with id: " + id);
		try {
			TipoCuenta instance = (TipoCuenta) sessionFactory.getCurrentSession()
					.get("co.edu.campusucc.sd.modelo.TipoCuenta", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(TipoCuenta instance) {
		logger.log(Level.INFO, "finding TipoCuenta instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("co.edu.campusucc.sd.modelo.TipoCuenta")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
