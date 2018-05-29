package sys.model;
// Generated 23/05/2018 21:26:43 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tbestado generated by hbm2java
 */
public class Tbestado  implements java.io.Serializable {


     private Integer idestado;
     private Tbpais tbpais;
     private String nomeEstado;
     private Set<Tbcidade> tbcidades = new HashSet<Tbcidade>(0);
     private Set<Tbempregado> tbempregados = new HashSet<Tbempregado>(0);

    public Tbestado() {
    }

	
    public Tbestado(Tbpais tbpais, String nomeEstado) {
        this.tbpais = tbpais;
        this.nomeEstado = nomeEstado;
    }
    public Tbestado(Tbpais tbpais, String nomeEstado, Set<Tbcidade> tbcidades, Set<Tbempregado> tbempregados) {
       this.tbpais = tbpais;
       this.nomeEstado = nomeEstado;
       this.tbcidades = tbcidades;
       this.tbempregados = tbempregados;
    }
   
    public Integer getIdestado() {
        return this.idestado;
    }
    
    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }
    public Tbpais getTbpais() {
        return this.tbpais;
    }
    
    public void setTbpais(Tbpais tbpais) {
        this.tbpais = tbpais;
    }
    public String getNomeEstado() {
        return this.nomeEstado;
    }
    
    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }
    public Set<Tbcidade> getTbcidades() {
        return this.tbcidades;
    }
    
    public void setTbcidades(Set<Tbcidade> tbcidades) {
        this.tbcidades = tbcidades;
    }
    public Set<Tbempregado> getTbempregados() {
        return this.tbempregados;
    }
    
    public void setTbempregados(Set<Tbempregado> tbempregados) {
        this.tbempregados = tbempregados;
    }




}

