package sys.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.model.Tbempregado;
import sys.util.HibernateUtil;

/**
 *
 * @author Augusto
 */
public class empregadoDaoImp implements empregadoDao{
    /**
     * Método para listar Empregados
     * @return 
     */
    @Override
    public List<Tbempregado> mostrarempregados() {
        
        List<Tbempregado> listarEmpregados = null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "FROM Tbempregado as e inner join fetch e.tbpais left join fetch e.tbestado left join fetch e.tbcidade";
        
        try{
            listarEmpregados = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
       return listarEmpregados;
    }
    /**
     * Método para criar novo Empregado
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
        }finally{
            if(session != null){
                session.close();
            }
        }





    }
    
    
      
}








