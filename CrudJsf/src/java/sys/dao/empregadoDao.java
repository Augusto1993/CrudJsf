
package sys.dao;

import java.util.List;

import sys.model.Tbempregado;


/**
 *
 * @author Augusto
 */
public interface empregadoDao {
    /*Método para mostrar lista de empregados*/  
    /**
     * 
     * @return 
     */
    public List<Tbempregado> mostrarempregados();
    /*Método para criar novo Empregado */
    /**
     * 
     * @param tbempregado 
     */
    public void novoEmpregado (Tbempregado tbempregado);     
   
}



