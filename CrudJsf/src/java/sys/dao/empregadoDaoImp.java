package sys.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.model.Tbcidade;
import sys.model.Tbempregado;
import sys.model.Tbestado;
import sys.model.Tbpais;
import sys.util.HibernateUtil;

/**
 *
 * @author Augusto
 */
public class empregadoDaoImp implements empregadoDao {

    /**
     * Método para listar Empregados
     *
     * @return
     */
    @Override
    public List<Tbempregado> mostrarempregados() {

        List<Tbempregado> listarEmpregados = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Tbempregado as e inner join fetch e.tbpais left join fetch e.tbestado left join fetch e.tbcidade";

        try {
            listarEmpregados = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarEmpregados;
    }

    /**
     * Método para criar novo Empregado
     *
     * @param tbempregado
     */
    @Override
    public void novoEmpregado(Tbempregado tbempregado) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tbempregado);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
    
    
    @Override
    public void alterarEmpregado(Tbempregado tbempregado) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(tbempregado);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void excluirEmpregado(Tbempregado tbempregado) {
         Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(tbempregado);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    
    

    @Override
    public List<Tbpais> listarpaises() {
        List<Tbpais> listarPaises = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Tbpais";

        try {
            listarPaises = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarPaises;

    }

    @Override
    public List<Tbestado> listarestados(Tbempregado tbempregado) {
        List<Tbestado> listarEstados = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Tbestado WHERE tbpais_idpais = '" + tbempregado.getTbpais().getIdpais() + "'";

        try {
            listarEstados = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarEstados;

    }

    @Override
    public List<Tbcidade> liscarcidades(Tbempregado tbempregado) {
        List<Tbcidade> listarcidades = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Tbcidade WHERE tbestado_idestado = '" + tbempregado.getTbestado().getIdestado() + "'";

        try {
            listarcidades = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarcidades;
    }

    

}




