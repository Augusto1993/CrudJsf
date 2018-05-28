
package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sys.dao.empregadoDao;
import sys.dao.empregadoDaoImp;
import sys.model.Tbempregado;

/**
 *
 * @author Augusto
 */
@ViewScoped
@ManagedBean
public class empregadoBean{
    
    private List<Tbempregado> listar;
    private Tbempregado tbempregado;
   
    /**
     *
     */
    public empregadoBean() {
        
        
    }
    /**
     * 
     * @return 
     */
    public List<Tbempregado> getListar() {
        empregadoDao eDao = new empregadoDaoImp();
        listar = eDao.mostrarempregados();
        return listar;
    }
    /**
     * 
     * @return 
     */
    public Tbempregado getTbempregado() {
        return tbempregado;
    }
    /**
     * 
     * @param tbempregado 
     */
    public void setTbempregado(Tbempregado tbempregado) {
        this.tbempregado = tbempregado;
    }
    /**
     * 
     */
    public void novoEmpregado(){
        empregadoDao eDao = new empregadoDaoImp();
        eDao.novoEmpregado(tbempregado);
        tbempregado = new Tbempregado();
        
    }
    
    
    
}




