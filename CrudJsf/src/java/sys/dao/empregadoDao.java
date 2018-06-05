
package sys.dao;

import java.util.List;

import sys.model.*;



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
    public void alterarEmpregado (Tbempregado tbempregado);
    public void excluirEmpregado (Tbempregado tbempregado);
    
    /**
     * Método para gerar dinamicamente os select menus.
     */
    public List<Tbpais> listarpaises();
    public List<Tbestado> listarestados(Tbempregado tbempregado);
    public List<Tbcidade> liscarcidades(Tbempregado tbempregado);
    
   
}







