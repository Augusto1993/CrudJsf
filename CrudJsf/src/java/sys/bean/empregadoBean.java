package sys.bean;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import sys.dao.empregadoDao;
import sys.dao.empregadoDaoImp;
import sys.model.Tbcidade;
import sys.model.Tbempregado;
import sys.model.Tbestado;
import sys.model.Tbpais;

/**
 *
 * @author Augusto
 */
@ViewScoped
@ManagedBean
public class empregadoBean {

    private List<Tbempregado> listar;
    private Tbempregado tbempregado;

    private List<SelectItem> listPaises;
    private List<SelectItem> listEstados;
    private List<SelectItem> listCidades;

    /**
     *
     */
    public empregadoBean() {
        tbempregado = new Tbempregado();

    }

    /**
     *
     * @return
     */
    public List<Tbempregado> getListar() {
        if (listar == null) {
            try {
                empregadoDao eDao = new empregadoDaoImp();
                listar = eDao.mostrarempregados();
            } catch (Exception e) {
                System.out.println("Erro ao carregar a lista de empregados: "+e);
            }

        }
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
    public void prepararNovoEmpregado(ActionEvent actionEvent) {
        tbempregado = new Tbempregado();

    }

    public void novoEmpregado() {
        empregadoDao eDao = new empregadoDaoImp();
        eDao.novoEmpregado(tbempregado);
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Dados inseridos com sucesso!"));

    }

    public void alterarEmpregado() {
        empregadoDao eDao = new empregadoDaoImp();
        eDao.alterarEmpregado(tbempregado);
        tbempregado = new Tbempregado();

    }

    public void excluirEmpregado() {
        empregadoDao eDao = new empregadoDaoImp();
        eDao.excluirEmpregado(tbempregado);
        tbempregado = new Tbempregado();

    }

    public List<SelectItem> getListPaises() {
        this.listPaises = new ArrayList<SelectItem>();
        empregadoDao eDao = new empregadoDaoImp();
        List<Tbpais> p = eDao.listarpaises();
        listPaises.clear();

        for (Tbpais pais : p) {
            SelectItem paisItem = new SelectItem(pais.getIdpais(), pais.getNomepais());
            this.listPaises.add(paisItem);
        }
        return listPaises;
    }

    public List<SelectItem> getListEstados() {
        this.listEstados = new ArrayList<SelectItem>();
        empregadoDao eDao = new empregadoDaoImp();
        List<Tbestado> e = eDao.listarestados(this.tbempregado);
        listEstados.clear();

        for (Tbestado estado : e) {
            SelectItem estadoItem = new SelectItem(estado.getIdestado(), estado.getNomeEstado());
            this.listEstados.add(estadoItem);
        }

        return listEstados;
    }

    public List<SelectItem> getListCidades() {
        this.listCidades = new ArrayList<SelectItem>();
        empregadoDao eDao = new empregadoDaoImp();
        List<Tbcidade> c = eDao.liscarcidades(this.tbempregado);
        listCidades.clear();

        for (Tbcidade cidade : c) {
            SelectItem cidadeItem = new SelectItem(cidade.getIdcidade(), cidade.getNomecidade());
            this.listCidades.add(cidadeItem);
        }

        return listCidades;
    }

    public void cancelar() {
        tbempregado = new Tbempregado();
    }

}



