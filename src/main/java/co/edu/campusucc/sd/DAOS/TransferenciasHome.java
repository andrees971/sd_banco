package co.edu.campusucc.sd.DAOS;
// Generated 23/05/2020 02:30:35 PM by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import co.edu.campusucc.sd.modelo.Transferencias;

/**
 * Home object for domain model class Transferencias.
 * @see co.edu.campusucc.sd.modelo.Transferencias
 * @author Hibernate Tools
 */
public class TransferenciasHome {

	private static final Logger logger = Logger.getLogger(TransferenciasHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Transferencias transientInstance) {
		logger.log(Level.INFO, "persisting Transferencias instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Transferencias instance) {
		logger.log(Level.INFO, "attaching dirty Transferencias instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(Transferencias instance) {
		logger.log(Level.INFO, "attaching clean Transferencias instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(Transferencias persistentInstance) {
		logger.log(Level.INFO, "deleting Transferencias instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public Transferencias merge(Transferencias detachedInstance) {
		logger.log(Level.INFO, "merging Transferencias instance");
		try {
			Transferencias result = (Transferencias) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public Transferencias findById(java.lang.String id) {
		logger.log(Level.INFO, "getting Transferencias instance with id: " + id);
		try {
			Transferencias instance = (Transferencias) sessionFactory.getCurrentSession()
					.get("co.edu.campusucc.sd.modelo.Transferencias", id);
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

	public List findByExample(Transferencias instance) {
		logger.log(Level.INFO, "finding Transferencias instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("co.edu.campusucc.sd.modelo.Transferencias").add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
